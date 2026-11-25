package com.kigi.explorer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.List;

public record PessoaResumo(
        Long id,
        String nome,
        @JsonProperty("data_cadastro") OffsetDateTime dataCadastro,
        @JsonProperty("tipos_pessoa") List<String> tiposPessoa
) {}

