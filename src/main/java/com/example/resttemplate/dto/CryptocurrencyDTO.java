package com.example.resttemplate.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CryptocurrencyDTO {
    private String target;
    private Map<String, BigDecimal> cryptocurrencies;
}
