package com.jooq.coversionIssue.db;

public record PostgresContainerConfig(
    String dbName,
    String username,
    String password,
    String host,
    Integer firstMappedPort,
    String jdbcUrl) {}
