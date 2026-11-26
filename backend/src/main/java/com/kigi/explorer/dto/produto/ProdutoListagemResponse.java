
package com.kigi.explorer.dto.produto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ProdutoListagemResponse(
        Integer total,
        Integer pagina,

        @JsonProperty("por_pagina")
        Integer porPagina,

        List<ProdutoResumo> itens
) {}
