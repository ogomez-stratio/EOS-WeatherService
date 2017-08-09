package com.stratio.weatherService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ControllerResponseDto {

    private String code;
    private String date;
    private String high;
    private String low;
    private String sunny;

}
