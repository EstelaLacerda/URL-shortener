package com.estela.urlshortener.urlshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estela.urlshortener.urlshortener.models.Url;

public interface UrlRepository extends JpaRepository<Url, Long> {
    public void insertUrl(Url newUrl);

    public void getAllUrl();

    public void updateUrl(int id);

    public void deleteUrl(int id);
}
