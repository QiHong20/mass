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
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


@MapperScan(basePackages = {"com.example.demomultisourceofmybatis.mapper1"},sqlSessionFactoryRef="sqlSessionFactory1")
@Configuration
public class Mapper1Config {

    @Value("${jdbc1.datasource.url}")
    private String url;

    @Value("${jdbc1.datasource.username}")
    private String user;

    @Value("${jdbc1.datasource.password}")
    private String password;

    @Value("${jdbc1.datasource.driver-class-name}")
    private String driverClass;

    @Bean(name = "mysqlDataSource1")
    @ConfigurationProperties(prefix = "jdbc1.datasource")
    @Primary
    public DataSource masterDataSource() {
        DataSource dataSource = DataSourceBuilder.create().build();
        return dataSource;
    }

    @Bean(name = "transactionManager1")
    public DataSourceTransactionManager masterTransactionManager(@Qualifier("mysqlDataSource1")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


    @Bean(name ="sqlSessionFactory1")
    @Primary
    public SqlSessionFactory sqlSessionFactory2(@Qualifier("mysqlDataSource1")DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource); //

        return factoryBean.getObject();

    }
}
