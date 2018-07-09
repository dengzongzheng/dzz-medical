package com.dzz.medical.config.web.security;import org.springframework.context.annotation.Bean;import org.springframework.context.annotation.Configuration;import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;import org.springframework.security.config.annotation.web.builders.HttpSecurity;import org.springframework.security.config.annotation.web.builders.WebSecurity;import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;import org.springframework.security.core.userdetails.UserDetailsService;import org.springframework.security.web.access.AccessDeniedHandler;import org.springframework.security.web.util.matcher.AntPathRequestMatcher;/** * WebSecurity访问控制配置 * @author dzz * @since  2017年04月20 上午7:12 * @version  1.0.0 */@Configuration@EnableWebSecurity@EnableGlobalMethodSecurity(prePostEnabled = true)public class WebSecurityConfig extends WebSecurityConfigurerAdapter {    @Override    protected void configure(HttpSecurity http) throws Exception {        http.headers().frameOptions().disable();        http.authorizeRequests()                .antMatchers("/manage/**").authenticated()                .and()                .formLogin()                .loginPage("/login")                .defaultSuccessUrl("/index",true)                .failureHandler(getMyAuthenticationFailureHandler())                .permitAll()                .and().exceptionHandling().authenticationEntryPoint(                        new AjaxAwareAuthenticationEntryPoint("/login"))                .accessDeniedHandler(getAccessDeniedHandler())                .and()                .logout()                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))                .logoutSuccessUrl("/login")                .permitAll();    }    @Override    public void configure(WebSecurity web) throws Exception {        web.ignoring().antMatchers("/js/**","/plugins/**","/fonts/**",                "/css/**", "/images/**", "/img/**", "/**/favicon.ico");    }    @Override    protected void configure(AuthenticationManagerBuilder auth) throws Exception {        auth.authenticationProvider(getMyAuthenticationProvider());    }    @Bean    public UserDetailsService customUserDetailsService(){        return new SelfUserDetailsService();    }    @Bean    public SelfAuthenticationProvider getMyAuthenticationProvider() {        return new SelfAuthenticationProvider();    }    @Bean    public SelfAuthenticationFailureHandler getMyAuthenticationFailureHandler() {        return new SelfAuthenticationFailureHandler();    }    @Bean    public AccessDeniedHandler getAccessDeniedHandler() {        return new MissingCsrfTokenAccessDeniedHandler();    }}