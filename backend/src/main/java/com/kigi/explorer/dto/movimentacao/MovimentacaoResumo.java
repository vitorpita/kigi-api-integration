package com.kigi.explorer.dto.movimentacao;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

public record MovimentacaoResumo(
        Long id,
        String nome,
        @JsonProperty("data_cadastro") OffsetDateTime dataCadastro
) {}
