package com.stratio.weatherService.service;

import com.stratio.weatherService.config.WeatherConfig;
import com.stratio.weatherService.dto.CitiesEnum;
import com.stratio.weatherService.dto.WeatherResponseDto;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WeatherConfig config;

    private CitiesEnum cities;



    @Override
    public WeatherResponseDto getweatherBycity(String city) throws UnsupportedEncodingException
            , HttpClientErrorException {

        WeatherResponseDto ret = null;

        if (EnumUtils.isValidEnum(CitiesEnum.class,city)) {

           String uriString = config.getBaseUrl()+config.getPath()+"?q="
                   +config.getQuery()+CitiesEnum.valueOf(city).getCode()+"&format="+config.getFormat();

            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uriString);

            ret = restTemplate.getForObject(builder.build(true).toUri(), WeatherResponseDto.class);
        }

        return ret;
    }
}
