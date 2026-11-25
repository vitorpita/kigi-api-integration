
package com.kigi.explorer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.List;

public record ProdutoItem(
        String cor,
        String tamanho,

        @JsonProperty("codigo_barras")
        String codigoBarras,

        @JsonProperty("codigos_barras")
        List<String> codigosBarras,

        @JsonProperty("unidade_medida")
        String unidadeMedida,

        @JsonProperty("quantidade_estoque")
        BigDecimal quantidadeEstoque
) {}
