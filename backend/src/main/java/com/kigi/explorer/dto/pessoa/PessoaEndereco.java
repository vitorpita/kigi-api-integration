package com.kigi.explorer.dto.pessoa;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PessoaEndereco(
        String cep,
        String logradouro,
        @JsonProperty("tipo_logradouro") String tipoLogradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String pais,
        Boolean principal
) {}