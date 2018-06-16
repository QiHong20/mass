package com.example.demomultisourceofmybatis.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@MapperScan(basePackages = {"com.example.demomultisourceofmybatis.mapper2"},sqlSessionFactoryRef="sqlSessionFactory2")
@Configuration
public class Mapper2Config {

    @Value("${jdbc2.datasource.url}")
    private String url;

    @Value("${jdbc2.datasource.username}")
    private String user;

    @Value("${jdbc2.datasource.password}")
    private String password;

    @Value("${jdbc2.datasource.driver-class-name}")
    private String driverClass;

    @Bean(name = "mysqlDataSource2")
    @ConfigurationProperties(prefix = "jdbc2.datasource")
    public DataSource masterDataSource() {
        DataSource dataSource = DataSourceBuilder.create().build();
        return dataSource;
    }

    @Bean(name = "transactionManager2")
    public DataSourceTransactionManager masterTransactionManager(@Qualifier("mysqlDataSource2")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


    @Bean(name ="sqlSessionFactory2")
    public SqlSessionFactory sqlSessionFactory2(@Qualifier("mysqlDataSource2")DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource); //

        return factoryBean.getObject();

    }
}
