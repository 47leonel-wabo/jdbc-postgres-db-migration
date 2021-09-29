package com.work.beat.talent.jdbcpostgresdbmigration.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DatasourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.main") // here, we pass properties defined in our application.yml file
    public HikariDataSource hikariDatasource() {
        return DataSourceBuilder
                .create()
                .type(HikariDataSource.class)
                .build();
    }

}
