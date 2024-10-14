package com.estela.urlshortener.urlshortener.controllers;

import com.estela.urlshortener.urlshortener.models.Url;
import com.estela.urlshortener.urlshortener.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/urls")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/create")
    public ResponseEntity<String> registerUrl(@RequestBody String originalUrl) {
        try {
            String shortenedUrl = urlService.registerUrl(originalUrl);
            return ResponseEntity.status(HttpStatus.CREATED).body(shortenedUrl);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar a URL.");
        }
    }

    @GetMapping("/{shortenedUrl}")
    public ResponseEntity<Void> accessShortenedUrl(@PathVariable String shortenedUrl) {
        try {
            String originalUrl = urlService.accessShortenedUrl(shortenedUrl);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create(originalUrl))
                    .build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/stats/{shortenedUrl}")
    public ResponseEntity<Url> getStatistics(@PathVariable String shortenedUrl) {
        Url urlStats = urlService.viewStatistics(shortenedUrl);
        if (urlStats != null) {
            return ResponseEntity.ok(urlStats);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}