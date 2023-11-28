package com.example.resttemplate.service;

import com.example.resttemplate.dto.CryptocurrencyDTO;
import com.example.resttemplate.webclient.cryptocurrency.CryptocurrencyClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import static com.example.resttemplate.constants.ConstantsUtil.DEFAULT_SYMBOLS;

@Service
@Log4j2
@RequiredArgsConstructor
public class CryptocurrencyService {
    private final CryptocurrencyClient cryptocurrencyClient;

    public CryptocurrencyDTO getCryptocurrency(String symbols) {
        if (symbols == null || symbols.isEmpty()) {
            symbols = DEFAULT_SYMBOLS;
        }
        return cryptocurrencyClient.getCurrencyForSymbols(symbols);
    }
}
