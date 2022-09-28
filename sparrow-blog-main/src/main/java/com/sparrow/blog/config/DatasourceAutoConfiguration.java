package com.sparrow.blog.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.sparrow.datasource.DataSourceFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceAutoConfiguration {

    @Autowired
    private SparrowConfig sparrowConfig;

    @Bean
    public DruidDataSource sparrow_default() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(this.sparrowConfig.getUsername());
        druidDataSource.setPassword(this.sparrowConfig.getPassword());
        druidDataSource.setUrl(this.sparrowConfig.getUrl());
        druidDataSource.setDriverClassName(this.sparrowConfig.getDriverClassName());
        druidDataSource.setInitialSize(10);
        druidDataSource.setBreakAfterAcquireFailure(true);
        return druidDataSource;
    }

    @Bean
    public DataSourceFactoryImpl dataSourceFactory(DruidDataSource sparrow_default) {
        return new DataSourceFactoryImpl("sparrow_default");
    }
}