package com.example.resttemplate.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Builder
public class CryptocurrencyDTO {
    private boolean success;
    private String target;
    private Map<String, BigDecimal> cryptocurrencies;
}
