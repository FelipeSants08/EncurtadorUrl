package com.santana.encurtador.model;

import jakarta.validation.constraints.NotBlank;

public record UrlRequest(
        @NotBlank(message = "Campo obrigatório")
        String url) {
}
