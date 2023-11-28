package com.example.resttemplate.webclient.cryptocurrency;

import com.example.resttemplate.dto.CryptocurrencyDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import static com.example.resttemplate.constants.ConstantsUtil.CRYPTOCURRENCY_URL;

@Component
public class CryptocurrencyClient {
    @Value(value = "${apiKey}")
    private String apiKey;
    private final RestTemplate restTemplate = new RestTemplate();

    public CryptocurrencyDTO getCurrencyForSymbols(String symbols) {
        OpenCryptocurrencyDTO openCryptocurrencyDTO = restTemplate.getForObject(
                CRYPTOCURRENCY_URL + "live?access_key={apiKey}&target={target}&symbols={symbols}",
                OpenCryptocurrencyDTO.class, apiKey, "USD", symbols);

        if (openCryptocurrencyDTO != null && openCryptocurrencyDTO.isSuccess()) {
            return CryptocurrencyDTO.builder()
                    .success(openCryptocurrencyDTO.isSuccess())
                    .target(openCryptocurrencyDTO.getTarget())
                    .cryptocurrencies(openCryptocurrencyDTO.getRates())
                    .build();
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid cryptocurrency symbols");
        }
    }

}
