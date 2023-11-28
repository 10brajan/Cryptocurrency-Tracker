package com.example.resttemplate.controller;

import com.example.resttemplate.dto.CryptocurrencyDTO;
import com.example.resttemplate.service.CryptocurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class CryptocurrencyController {

    private final CryptocurrencyService cryptocurrencyService;

    @GetMapping("/currency")
    public ResponseEntity<?> getCryptocurrency(@RequestParam(required = false) String symbols) {
        try {
            CryptocurrencyDTO cryptocurrency = cryptocurrencyService.getCryptocurrency(symbols);
            return ResponseEntity.ok(cryptocurrency);
        } catch (ResponseStatusException e) {
            Map<String, String> errorResponse = Map.of("error", Objects.requireNonNull(e.getReason()));
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
}
