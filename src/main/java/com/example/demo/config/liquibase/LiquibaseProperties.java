package com.example.demo.config.liquibase;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.liquibase", ignoreUnknownFields = false)
public class LiquibaseProperties {

  private String changeLog = "classpath:db/liquibase/changelog/db.changelog-master.yaml";
  private Boolean enabled = true;

  public String getChangeLog() {
    return changeLog;
  }

  public void setChangeLog(String changeLog) {
    this.changeLog = changeLog;
  }

  public Boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }
}
