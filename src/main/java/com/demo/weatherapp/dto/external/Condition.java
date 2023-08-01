package com.demo.weatherapp.dto.external;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Condition {

    private String text;
    private String icon;
    private String code;

}
