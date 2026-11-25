package com.kigi.explorer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record PessoaListagemResponse (
    Integer total,
    Integer pagina,
    @JsonProperty("por_pagina") Integer porPagina,
    List<PessoaResumo> itens
){}
