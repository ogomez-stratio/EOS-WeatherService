package com.stratio.weatherService.service;


import com.stratio.weatherService.dto.WeatherResponseDto;

import java.io.UnsupportedEncodingException;

public interface WeatherService {

    WeatherResponseDto getweatherBycity(String City) throws UnsupportedEncodingException;
}
