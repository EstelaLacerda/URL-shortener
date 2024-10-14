package com.estela.urlshortener.urlshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.estela.urlshortener.urlshortener.models.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    Url findByShortenedUrl(String shortenedUrl);
}
