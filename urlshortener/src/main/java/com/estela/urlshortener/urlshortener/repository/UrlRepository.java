package com.estela.urlshortener.urlshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estela.urlshortener.urlshortener.models.Url;

public interface UrlRepository extends JpaRepository<Url, Long> {
    
}
