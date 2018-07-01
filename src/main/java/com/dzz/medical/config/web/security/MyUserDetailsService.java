package com.dzz.medical.config.web.security;import java.util.HashSet;import java.util.Set;import lombok.extern.slf4j.Slf4j;import org.springframework.security.core.GrantedAuthority;import org.springframework.security.core.userdetails.UserDetails;import org.springframework.security.core.userdetails.UserDetailsService;import org.springframework.security.core.userdetails.UsernameNotFoundException;import org.springframework.stereotype.Component;import org.springframework.util.StringUtils;/** * 用户数据服务 * @author dzz * @since  2017年04月20 上午9:52 * @version  1.0.0 */@Component@Slf4jpublic class MyUserDetailsService implements UserDetailsService {    /**     * 用户认证     * @param userName 用户名     * @return 用户实体     * @throws UsernameNotFoundException 未找到相关用户异常     */    @Override    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {        if (StringUtils.isEmpty(userName)) {            throw new UsernameNotFoundException("用户名不能为空");        }        Set<GrantedAuthority> authorities = new HashSet<>();        MyUserDetails user = new MyUserDetails(userName,"123456",true,true,true,true,authorities);        user.setUserId(String.valueOf("admin"));        user.setStatus(1);        return user;    }}