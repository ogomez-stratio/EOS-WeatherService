package com.stratio.weatherService.service;


import com.stratio.weatherService.dto.WeatherResponseDto;
import org.springframework.web.client.HttpClientErrorException;

public interface WeatherService {

    WeatherResponseDto getweatherBycity(String City) throws HttpClientErrorException;
}
