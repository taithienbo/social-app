package com.tbo.sn.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Base configuration class.
 * @author tai
 * @since 3/17/18.
 */
// Enable spring boot auto configuration features and pick up other bean configurations by scanning the specified
// package.
@SpringBootApplication(scanBasePackages = {"com.tbo.sn"},
        // exclude DataSourceAutoConfiguration because we don't use a DataSource for this project. Spring boot
        // throws exceptions when it tries to auto configure the data source as there is not enough information.
exclude = {DataSourceAutoConfiguration.class})
public class AppConfig
{
}
