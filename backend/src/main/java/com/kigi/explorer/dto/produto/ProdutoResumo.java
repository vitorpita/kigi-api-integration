
package com.kigi.explorer.dto.produto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

public record ProdutoResumo(
        String id,

        @JsonProperty("codigo_referencia")
        String codigoReferencia,

        String nome,

        @JsonProperty("data_cadastro")
        OffsetDateTime dataCadastro
) {}
