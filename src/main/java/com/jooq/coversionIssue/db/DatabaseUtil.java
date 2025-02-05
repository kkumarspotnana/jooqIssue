package com.jooq.coversionIssue.db;

import static com.jooq.coversionIssue.db.DBConstants.DOCKER_POSTGRES_IMAGE_NAME;
import static com.jooq.coversionIssue.db.DBConstants.POSTGRES_DB_NAME;
import static com.jooq.coversionIssue.db.DBConstants.POSTGRES_PWED;
import static com.jooq.coversionIssue.db.DBConstants.POSTGRES_USER;

import com.zaxxer.hikari.HikariDataSource;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import javax.sql.DataSource;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.utility.DockerImageName;
import org.testcontainers.utility.MountableFile;
@Slf4j
@Configuration
public class DatabaseUtil {

  private static final String initScript = "init.sql";
  @Getter
  private static final PostgresContainerConfig postgresContainerConfig;
  static {
    final PostgreSQLContainer<?> sharedPostgresqlContainer = startPgTestContainer(initScript);
    postgresContainerConfig =
        new PostgresContainerConfig(
            sharedPostgresqlContainer.getDatabaseName(),
            sharedPostgresqlContainer.getUsername(),
            sharedPostgresqlContainer.getPassword(),
            sharedPostgresqlContainer.getHost(),
            sharedPostgresqlContainer.getFirstMappedPort(),
            sharedPostgresqlContainer.getJdbcUrl());
  }

  @Bean
  @SuppressWarnings("SameParameterValue")
  public DataSource getDataSource() {
    val dataSource = new HikariDataSource();
    dataSource.setJdbcUrl(postgresContainerConfig.jdbcUrl());
    dataSource.setMaximumPoolSize(2);
    dataSource.setUsername(postgresContainerConfig.username());
    dataSource.setPassword(postgresContainerConfig.password());
    return dataSource;

  }


  @SuppressWarnings("resource")
  private static PostgreSQLContainer<?> startPgTestContainer(final String initScript) {
    PostgreSQLContainer<?> sharedPostgresqlContainer = null;
    try {
      sharedPostgresqlContainer =
          new PostgreSQLContainer<>(
              DockerImageName.parse(DOCKER_POSTGRES_IMAGE_NAME)
                  .asCompatibleSubstituteFor("postgres"))
              .withDatabaseName(POSTGRES_DB_NAME)
              .withUsername(POSTGRES_USER)
              .withPassword(POSTGRES_PWED)
              .withStartupTimeout(Duration.of(3, ChronoUnit.MINUTES))
              // why not initScript:
              // https://github.com/testcontainers/testcontainers-java/issues/570
              .withCopyFileToContainer(
                  MountableFile.forClasspathResource(initScript),
                  "/docker-entrypoint-initdb.d/init.sql");

      sharedPostgresqlContainer.waitingFor(Wait.forListeningPort()).start();
      return sharedPostgresqlContainer;
    } catch (final Exception e) {
      log.error("Failed to start postgres container", e);
      if (sharedPostgresqlContainer != null) {
        log.info("Postgres container logs {}", sharedPostgresqlContainer.getLogs());
      }
      throw e;
    }
  }

}
