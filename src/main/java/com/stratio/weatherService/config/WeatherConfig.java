package com.stratio.weatherService.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "service")
@Data
public class WeatherConfig {

    private String baseUrl;
    private String path;
    private String format;
    private String query;
    private String dasWeatherServiceId;
}
