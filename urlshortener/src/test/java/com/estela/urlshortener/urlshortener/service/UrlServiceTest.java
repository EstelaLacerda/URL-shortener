package com.estela.urlshortener.urlshortener.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
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

        String result = urlService.registerUrl("https://github.com/EstelaLacerda/URL-shortener/commits/main/");

        assertNotNull(result);
        assertTrue(result.length() > 0);
    }
}
