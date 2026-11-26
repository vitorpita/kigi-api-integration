package com.kigi.explorer.dto.pessoa;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Manequim(
        @JsonProperty("tipo_produto") String tipoProduto,
        String tamanho
) {}