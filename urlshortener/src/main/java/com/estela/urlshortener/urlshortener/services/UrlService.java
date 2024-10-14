package com.estela.urlshortener.urlshortener.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estela.urlshortener.urlshortener.models.Url;
import com.estela.urlshortener.urlshortener.repository.UrlRepository;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public List<Url> getAllUrl() {
        return urlRepository.findAll();
    }

    public void updateUrl(long id, Url updatedUrl) {
        Url existingUrl = urlRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("URL de ID: " + id + " não encontrada."));

        existingUrl.setOriginalUrl(updatedUrl.getOriginalUrl());
        existingUrl.setShortenedUrl(updatedUrl.getShortenedUrl());
        urlRepository.save(existingUrl);
    }

    public void deleteUrl(long id) {
        urlRepository.deleteById(id);
    }

    public String registerUrl(String originalUrl) {
        if (!isThisValidUrl(originalUrl)) {
            throw new IllegalArgumentException("Esse formato de URL é inválido.");
        }

        Url url = new Url();
        url.setOriginalUrl(originalUrl);

        url = urlRepository.save(url);

        String shortenedUrl = encodeBase62(url.getId());

        url.setShortenedUrl(shortenedUrl);

        url = urlRepository.save(url);

        return shortenedUrl;
    }

    public String accessShortenedUrl(String shortenedUrl) {
        try {
            Url url = urlRepository.findByShortenedUrl(shortenedUrl);

            if (url != null) {
                url.setAccessCount(url.getAccessCount() + 1);
                urlRepository.save(url);

                return url.getOriginalUrl();
            } else {
                throw new Exception("URL encurtada não encontrada.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao acessar a URL: " + e.getMessage());
            return "URL não encontrada.";
        }
    }

    public Url viewStatistics(String shortenedUrl) {
        try {
            Url url = urlRepository.findByShortenedUrl(shortenedUrl);

            if (url != null) {
                int totalAccess = url.getAccessCount();

                long daysSinceCreation = ChronoUnit.DAYS.between(url.getCreatedAt(), LocalDate.now());
                double avgAccessDay = (daysSinceCreation > 0) ? (double) totalAccess / daysSinceCreation
                        : totalAccess;

                System.out.println("Número total de Acessos: " + totalAccess);
                System.out.println("Média de Acessos por Dia: " + avgAccessDay);

                return url;
            } else {
                throw new Exception("URL encurtada não encontrada.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao visualizar as estatísticas: " + e.getMessage());
            return null;
        }
    }

    private String encodeBase62(long id) {
        String base62Chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder encoded = new StringBuilder();
        while (id > 0) {
            int rest = (int) (id % 62);
            encoded.append(base62Chars.charAt(rest));
            id /= 62;
        }
        return encoded.reverse().toString();
    }

    private boolean isThisValidUrl(String url) {
        String urlRegex = "^(https?://)?(www\\.)?([\\w-]+\\.)+[a-zA-Z]{2,6}(/\\S*)?$";
        return url != null && url.matches(urlRegex);
    }

}
