package com.dzz.medical.config.web.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.csrf.MissingCsrfTokenException;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;

/**
 * @author 何红霞~Angelina
 */
public class MissingCsrfTokenAccessDeniedHandler extends AccessDeniedHandlerImpl {
    private RequestCache requestCache = new HttpSessionRequestCache();
    private String loginPage = "/login";

    @Override
    public void handle(HttpServletRequest req, HttpServletResponse res, AccessDeniedException exception) throws IOException, ServletException {
        if (exception instanceof MissingCsrfTokenException && isSessionInvalid(req)) {
            requestCache.saveRequest(req, res);
            req.getRequestDispatcher("/login").forward(req, res);

        }
        super.handle(req, res, exception);
    }

    private boolean isSessionInvalid(HttpServletRequest req) {
        try {
            HttpSession session = req.getSession(false);
            return session == null || !req.isRequestedSessionIdValid();
        }
        catch (IllegalStateException ex) {
            return true;
        }
    }

    public void setRequestCache(RequestCache requestCache) {
        this.requestCache = requestCache;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

}
