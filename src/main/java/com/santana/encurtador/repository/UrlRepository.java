package com.santana.encurtador.repository;

import com.santana.encurtador.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {
    Optional<Url> findByCodigoEncurtado(String urlEncurtada);

    //Optional<Url> findByCodigoEncurtadoAndDataUrlExpiradoAfter(String urlEncurtada, LocalDateTime data);

    @Query("""
        select u from Url u
        where u.codigoEncurtado = :codigo
            and  u.dataUrlExpirado > :agora
    """)
    Optional<Url> buscarAtivo(
            @Param("codigo") String codigoEncurtado,
            @Param("agora") LocalDateTime data
    );

//    @Query("select u.url from Url u where u.codigoEncurtado = :codigo")
//    String urlOriginal(
//            @Param("codigo") String codigo
//    );

}
