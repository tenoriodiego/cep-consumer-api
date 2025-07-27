package com.salutis.cep_consumer_api.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(".env")
public class DBConfig {
    @Value("${DATABASE_URL}")
    private String databaseUrl;

    @Value("${DATABASE_USERNAME}")
    private String databaseUser;

    @Value("${DATABASE_PASSWORD}")
    private String databasePassword;

    @Value("${DATABASE_DRIVER}")
    private String databaseDriver;

    @Value("${DATABASE_HIBERNATE_DDL}")
    private String databaseDll;

    


}
