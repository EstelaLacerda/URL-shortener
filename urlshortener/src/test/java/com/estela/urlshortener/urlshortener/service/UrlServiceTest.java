package com.estela.urlshortener.urlshortener.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.estela.urlshortener.urlshortener.models.Url;
import com.estela.urlshortener.urlshortener.repository.UrlRepository;
import com.estela.urlshortener.urlshortener.services.UrlService;

@ExtendWith(MockitoExtension.class)
public class UrlServiceTest {

    @Mock
    private UrlRepository urlRepository;

    @InjectMocks
    private UrlService urlService;

    @Test
    public void testRegisterUrl_Success() {
        Url url = new Url();
        url.setId(1L);
        url.setOriginalUrl("https://github.com/EstelaLacerda/URL-shortener/commits/main/");

        when(urlRepository.save(any(Url.class))).thenReturn(url);

        String shortenedUrl = urlService.registerUrl("https://github.com/EstelaLacerda/URL-shortener/commits/main/");

        assertNotNull(shortenedUrl);
        assertTrue(shortenedUrl.length() > 0);

        assertEquals(shortenedUrl, url.getShortenedUrl());

        verify(urlRepository, times(2)).save(any(Url.class));
    }

    @Test
    public void testRegisterUrl_SaveFailure() {
        when(urlRepository.save(any(Url.class))).thenThrow(new RuntimeException("Erro ao salvar Url"));

        assertThrows(RuntimeException.class, () -> {
            urlService.registerUrl("https://github.com/EstelaLacerda/URL-shortener/commits/main/");
        });
    }

    @Test
    public void testRegisterUrl_Duplicate() {
        Url existingUrl = new Url();
        existingUrl.setId(1L);
        existingUrl.setOriginalUrl("https://github.com/EstelaLacerda/URL-shortener/commits/main/");

        when(urlRepository.save(any(Url.class))).thenReturn(existingUrl);

        String shortenedUrl = urlService.registerUrl("https://github.com/EstelaLacerda/URL-shortener/commits/main/");

        assertNotNull(shortenedUrl);
        assertEquals(existingUrl.getShortenedUrl(), shortenedUrl);
    }

    @Test
    public void testRegisterUrl_InvalidFormat() {
        String invalidUrl = "htp://invalid-url";

        assertThrows(IllegalArgumentException.class, () -> {
            urlService.registerUrl(invalidUrl);
        });
    }

    @Test
    public void testViewStatistics_NotFound() {
        String shortenedUrl = "short.ly/invalid";

        when(urlRepository.findByShortenedUrl(shortenedUrl)).thenReturn(null);

        Url result = urlService.viewStatistics(shortenedUrl);

        assertNull(result);
        verify(urlRepository, times(1)).findByShortenedUrl(shortenedUrl);
    }
}
