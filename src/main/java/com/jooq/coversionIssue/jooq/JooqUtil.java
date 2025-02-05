package com.jooq.coversionIssue.jooq;

import static org.jooq.SQLDialect.POSTGRES;

import javax.sql.DataSource;
import lombok.AllArgsConstructor;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class JooqUtil {

  private final DataSource dataSource;
  @Bean
  public DefaultConfiguration configuration() {
    final DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
    jooqConfiguration.set(new DataSourceConnectionProvider(dataSource));
    jooqConfiguration.set(POSTGRES);
    return jooqConfiguration;
  }
  @Bean
  public DefaultDSLContext getDSLContext() {
    return new DefaultDSLContext(configuration());
  }

}
