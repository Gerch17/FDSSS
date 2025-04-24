package ru.tbank.fdsspring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currencies")
public class CurrencyController {

    @GetMapping
    public ResponseEntity<String> getCurrencies(Long id) {
        return ResponseEntity.ok("OK");
    }
    @PostMapping
    public ResponseEntity<Void> addCurrency(@RequestBody Map<String, Object> request) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurrency(@PathVariable String id) {
        return ResponseEntity.ok("OK");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCurrency(@PathVariable String id, @RequestBody Map<String, Object> request) {
        return ResponseEntity.ok("OK");
    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, String>> getCurrency(@PathVariable String id) {
        Map<String, String> a = new HashMap<>();
        return ResponseEntity.ok("OK");
    }
}