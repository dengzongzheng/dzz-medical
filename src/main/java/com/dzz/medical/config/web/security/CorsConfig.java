package com.dzz.medical.config.web.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


/**
 * @author dzz
 * @since 2016年11月12 上午9:12
 * @version 1.0.0
 */
@Configuration
public class CorsConfig {

    /**
     * 项目运行环境
     */
    @Value("${spring.profiles.active}")
    private String profilesActive;



    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        switch (profilesActive) {
            case "local":
                corsConfiguration.addAllowedOrigin("*");
                break;
            case "dev":
                corsConfiguration.addAllowedOrigin("*");
                break;
            case "test":
                corsConfiguration.addAllowedOrigin("*");
                break;
            case "prod":
                corsConfiguration.addAllowedOrigin("*");
                break;
            default:
                corsConfiguration.addAllowedOrigin("*");
                break;
        }
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }

}

