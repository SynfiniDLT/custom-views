package com.daml.quickstart.iou.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringJdbcConfig {
  @Bean
  public DataSource pgDataSource(@Value("${projection.db.url}") String url,
                                 @Value("${projection.db.username}") String user,
                                 @Value("${projection.db.password}") String password,
                                 @Value("${spring.datasource.driver-class-name}") String driver) {
    DriverManagerDataSource dataSource = new DriverManagerDataSource(url, user, password);
    dataSource.setDriverClassName(driver);

    return dataSource;
  }
}
