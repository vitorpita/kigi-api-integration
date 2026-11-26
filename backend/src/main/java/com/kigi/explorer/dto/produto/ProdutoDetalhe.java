
package com.kigi.explorer.dto.produto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ProdutoDetalhe(
        String id,
        String status,

        @JsonProperty("codigo_referencia")
        String codigoReferencia,

        String nome,

        @JsonProperty("tipo_produto")
        String tipoProduto,

        String genero,
        String marca,
        String linha,
        String colecao,
        String modelo,

        @JsonProperty("referencia_fornecedor")
        String referenciaFornecedor,

        List<String> imagens,

        List<ProdutoItem> itens
) {}
