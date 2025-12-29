package com.santana.encurtador.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    private String codigoEncurtado;

    private LocalDateTime dataUrlExpirado;

    public String getCodigoEncurtado() {
        return codigoEncurtado;
    }

    public void setCodigoEncurtado(String codigoEncurtado) {
        this.codigoEncurtado = codigoEncurtado;
    }

    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getDataUrlExpirado() {
        return dataUrlExpirado;
    }

    public void setDataUrlExpirado(LocalDateTime dataUrlExpirado) {
        this.dataUrlExpirado = dataUrlExpirado;
    }
}
