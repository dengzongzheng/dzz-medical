package com.dzz.medical.config.exception;import com.alibaba.fastjson.JSONObject;import com.dzz.medical.common.response.ResponseDzz;import java.io.IOException;import java.io.PrintWriter;import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpServletResponse;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import org.springframework.web.bind.annotation.ControllerAdvice;import org.springframework.web.bind.annotation.ExceptionHandler;import org.springframework.web.servlet.ModelAndView;/** * 普通页面跳转异常捕获 * * @author dzz * @since  2017年04月21 上午11:48 * @version  1.0.0 */@ControllerAdvicepublic class GlobalExceptionHandler {    private Logger logger = LoggerFactory.getLogger(this.getClass());    /**     * 异常补获     * @param request request     * @param response response     * @param ex 异常信息     * @return 处理结果     */    @ExceptionHandler(value = { Exception.class })    public ModelAndView constraintViolationException(HttpServletRequest request,                                                     HttpServletResponse response, Exception  ex) {        logger.info("捕获异常啦,请求地址为:{}",request.getRequestURL().toString());        if (ex instanceof UserException) {            return returnExceptionResult(request, response, ((UserException) ex).getCode(), ex.getMessage());        }        return  returnExceptionResult(request, response, "100", "无权限访问");    }    /**     * 统一处理异常返回     * @param request request     * @param response response     * @param code code     * @param message 消息     * @return 处理结果     */    private ModelAndView returnExceptionResult(HttpServletRequest request, HttpServletResponse response,                                              String code, String message) {        boolean isAjax = isAjax(request);        if (isAjax) {            writeResult(response, code, message);            return null;        }        switch (code) {            case "100":                return new ModelAndView("/error/error","message","无权限访问");            default:        }        return null;    }    /**     * 写出异常结果     * @param response response     * @param code 消息状态     * @param message 消息说明     */    private void writeResult(HttpServletResponse response, String code, String message) {        PrintWriter writer = null;        try {            writer = response.getWriter();            writer.write(JSONObject.toJSONString(ResponseDzz.build("0", message)));            writer.flush();        } catch (IOException e) {            logger.error("writeResult出现异常",e);        }    }    /**     * 判断是否为Ajax请求     * @param request 请求对象     * @return 是否为ajax请求     */    private static boolean isAjax(HttpServletRequest request){        return  (request.getHeader("X-Requested-With") != null                && "XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) ;    }}