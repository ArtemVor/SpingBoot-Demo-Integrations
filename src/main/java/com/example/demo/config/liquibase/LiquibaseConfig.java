package com.example.demo.config.liquibase;



import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(LiquibaseProperties.class)
public class LiquibaseConfig {
  @Value("${spring.datasource.url}")
  private String datasourceUrl;

  @Value("${spring.datasource.username}")
  private String userName;

  @Value("${spring.datasource.password}")
  private String password;

  private String changeLog = "classpath:/db/liquibase/changelog/db.changelog-master.yaml";


  @Bean
  public DataSource dataSource() {

    DriverManagerDataSource dataSource = new DriverManagerDataSource();

    dataSource.setUrl(datasourceUrl);
    dataSource.setUsername(userName);
    dataSource.setPassword(password);

    return dataSource;
  }

  @Bean
  public SpringLiquibase liquibase(LiquibaseProperties properties) {
    properties.setChangeLog(changeLog);
    properties.setEnabled(true);
    SpringLiquibase liquibase = new SpringLiquibase();
    liquibase.setChangeLog(properties.getChangeLog());
    liquibase.setDataSource(dataSource());
    liquibase.setShouldRun(properties.isEnabled());
    return liquibase;
  }
}
