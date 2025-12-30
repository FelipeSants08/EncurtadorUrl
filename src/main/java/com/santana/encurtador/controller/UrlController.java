package com.santana.encurtador.controller;

import com.santana.encurtador.model.Url;
import com.santana.encurtador.model.UrlRequest;
import com.santana.encurtador.model.UrlResponse;
import com.santana.encurtador.service.UrlService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/url")
public class UrlController {

    private final UrlService service;

    public UrlController(UrlService service) {
        this.service = service;
    }

    @Operation(summary = "Encurtador de URL", description = "Encurta a URL que for passada no corpo da requisição")
    @PostMapping("/encurtar")
    public ResponseEntity<UrlResponse> encurtar(@Valid @RequestBody UrlRequest request) {
        Url url = service.save(request);
        UrlResponse urlResponse = new UrlResponse(url.getCodigoEncurtado());
        return ResponseEntity.ok(urlResponse);
    }


    @Operation(summary = "Redirecionar a partir do link", description = "Te redireciona para URL original a partir da URL simplificada")
    @GetMapping("/{urlEncurtada}")
    public ResponseEntity<Void> buscar(@PathVariable String urlEncurtada) {
        String urlOriginal = service.buscarUrl(urlEncurtada);
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(urlOriginal))
                .build();
    }

}
