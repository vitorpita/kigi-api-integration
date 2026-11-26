package com.kigi.explorer.dto.movimentacao;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record MovimentacaoListagemResponse(
        Integer total,
        Integer pagina,
        @JsonProperty("por_pagina") Integer porPagina,
        List<MovimentacaoResumo> itens
) {}
