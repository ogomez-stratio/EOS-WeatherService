package com.stratio.weatherService.controller;

import com.stratio.weatherService.service.WeatherService;
import com.stratio.weatherService.util.ResponseUtil;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Api(value = "EOS Weather Service", produces = MediaType.APPLICATION_JSON_VALUE)
public class WeatherRestController {

    private final WeatherService weatherService;

    @GetMapping("weather/{city}")
    @ApiOperation(value = "Given a city Get weather prediction for next 5 days")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Standard response for successful HTTP requests"),
            @ApiResponse(code = 404, message = "User does not exist or is missing city")
    })
    public ResponseEntity<String> getWeatherByCity(
        @ApiParam(required = true, value = "Id of client to calculate the analitics")
        @PathVariable String city) throws UnsupportedEncodingException {

        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(weatherService.getweatherBycity(city)));
    }

    public WeatherRestController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
}
