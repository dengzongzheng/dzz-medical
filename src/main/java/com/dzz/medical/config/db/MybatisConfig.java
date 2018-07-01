package com.dzz.medical.config.db;


import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import java.util.Properties;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.lang.annotation.After;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;


/**
 * Mysql 数据源配置
 * @author dzz
 * @since  2016年11月28 下午2:27
 * @version 1.0.0
 */
@Slf4j
@Configuration
public class MybatisConfig implements EnvironmentAware {

    private RelaxedPropertyResolver propertyResolver;

    @Override
    public void setEnvironment(Environment env) {
        this.propertyResolver = new RelaxedPropertyResolver(env, "");
    }

    @Bean(name = "dataSource")
    @Primary
    public DataSource openDataSource() {
        log.info("Configuring OpenDataSource");
        DruidDataSource datasource = new DruidDataSource();
        datasource.setDriverClassName(propertyResolver.getProperty("spring.dataSource.driver-class-name"));
        datasource.setUrl(propertyResolver.getProperty("spring.dataSource.url"));
        datasource.setUsername(propertyResolver.getProperty("spring.dataSource.username"));
        datasource.setPassword(propertyResolver.getProperty("spring.dataSource.password"));
        datasource.setDefaultAutoCommit(false);
        datasource.setMaxActive(20);
        datasource.setInitialSize(10);
        datasource.setMaxWait(60000);
        datasource.setMinIdle(5);
        datasource.setTimeBetweenEvictionRunsMillis(60000);
        datasource.setMinEvictableIdleTimeMillis(30000);
        datasource.setValidationQuery("select 'x'");
        datasource.setTestWhileIdle(true);
        datasource.setTestOnBorrow(true);
        datasource.setTestOnReturn(true);
        datasource.setPoolPreparedStatements(true);
        datasource.setMaxOpenPreparedStatements(20);
        return datasource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) {
        try {
            SqlSessionFactoryBean readSqlSessionFactory = new SqlSessionFactoryBean();
            readSqlSessionFactory.setDataSource(dataSource);
            readSqlSessionFactory
                    .setTypeAliasesPackage("com.dzz.medical.controller.*.model");
            PageHelper pageHelper = new PageHelper();
            Properties properties = new Properties();
            properties.setProperty("reasonable", "true");
            properties.setProperty("supportMethodsArguments", "true");
            properties.setProperty("returnPageInfo", "check");
            properties.setProperty("params", "count=countSql");
            pageHelper.setProperties(properties);
            readSqlSessionFactory.setPlugins(new Interceptor[]{pageHelper});
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = (Resource[]) ArrayUtils.addAll(resolver.getResources("classpath:mapper/*/*.xml")
                    , resolver.getResources("classpath:mapper/*/*/*.xml"));
            readSqlSessionFactory.setMapperLocations(resources);
            return readSqlSessionFactory.getObject();
        } catch (Exception e) {
            log.error("Could Not Configure Mybatis Session Factory", e);
            return null;
        }
    }


    @Bean(name = "platformTransactionManager")
    public PlatformTransactionManager annotationDrivenTransactionManager(
            @Qualifier("dataSource") DataSource dataSource) {
        log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~连接平台数据库事务开启~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "mapperScannerConfigurer")
    @After("sqlSessionFactory")
    public MapperScannerConfigurer openMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.dzz.medical.controller.*.dao");
        Properties properties = new Properties();
        properties.setProperty("mappers", "com.dzz.medical.common.BaseMapper");
        properties.setProperty("IDENTITY", "MYSQL");
        properties.setProperty("notEmpty", "false");
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }

}
