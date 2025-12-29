package com.santana.encurtador.service;

import com.santana.encurtador.model.Url;
import com.santana.encurtador.model.UrlRequest;
import com.santana.encurtador.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class UrlService {

    private final UrlRepository urlRepository;
    private final String CARACTERES = "ABCDUFGHIJKLMNOPQRSTUVWXYZqwertyuiopasdfghjklzxcvbnm0123456789";

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }


    public String buscarUrl(String codigoEncurtado) {
//        Url url = urlRepository.findByCodigoEncurtado(codigoEncurtado)
//                .orElseThrow(() -> new RuntimeException("URL não encontrado"));
//        if (LocalDateTime.now().isBefore(url.getDataUrlExpirado())){
//            return url.getUrl();
//        }else {
//            throw new RuntimeException("URL expirada");
//        }
        Url url = urlRepository.buscarAtivo(codigoEncurtado, LocalDateTime.now())
                .orElseThrow(() -> new RuntimeException("Codigo incorreto ou expirado"));
        return url.getUrl();
    }

    public Url save(UrlRequest request){

        Url url = new Url();
        url.setUrl(request.url());
        url.setCodigoEncurtado(encurtarUrl());
        url.setDataUrlExpirado(LocalDateTime.now().plusDays(1));
        return urlRepository.save(url);
    }




    public String encurtarUrl() {

        Random random = new SecureRandom();
        int tamanho = random.nextInt(5, 8);
        StringBuilder urlEncurtada = new StringBuilder(tamanho);
        for (int i = 0; i < tamanho; i++) {
            int indice = random.nextInt(CARACTERES.length());
            urlEncurtada.append(CARACTERES.charAt(indice));
        }
        return urlEncurtada.toString();
    }

}
