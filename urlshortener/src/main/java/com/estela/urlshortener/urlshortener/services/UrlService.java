package com.estela.urlshortener.urlshortener.services;

import java.util.List;
import com.estela.urlshortener.urlshortener.models.Url;
import com.estela.urlshortener.urlshortener.repository.UrlRepository;

public class UrlService {
    
    private UrlRepository urlRepository;

    public void insertUrl(Url newUrl) {
        urlRepository.save(newUrl); 
    }

    public List<Url> getAllUrl() {
        return urlRepository.findAll();
    }

    public void updateUrl(long id, Url updatedUrl) {
        Url existingUrl = urlRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("URL não encontrada com o ID: " + id));
        
        existingUrl.setOriginalUrl(updatedUrl.getOriginalUrl());
        existingUrl.setShortenedUrl(updatedUrl.getShortenedUrl());
        urlRepository.save(existingUrl); 
    }

    public void deleteUrl(long id){
        urlRepository.deleteById(id); 
    }

}
