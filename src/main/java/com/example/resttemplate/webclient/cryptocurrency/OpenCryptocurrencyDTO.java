package com.example.resttemplate.webclient.cryptocurrency;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Map;

@Getter
public class OpenCryptocurrencyDTO {
    private boolean success;
    private String target;
    private Map<String, BigDecimal> rates;
}
