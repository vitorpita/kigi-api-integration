package com.kigi.explorer.dto.movimentacao;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record MovimentacaoItem(
        @JsonProperty("codigo_produto") String codigoProduto,
        @JsonProperty("codigo_item") String codigoItem,
        @JsonProperty("codigo_referencia") String codigoReferencia,
        @JsonProperty("nome_produto") String nomeProduto,
        @JsonProperty("tipo_produto") String tipoProduto,
        String modelo,
        String marca,
        String linha,
        String colecao,
        String cor,
        String tamanho,
        BigDecimal quantidade,
        @JsonProperty("valor_bruto") BigDecimal valorBruto,
        @JsonProperty("valor_desconto") BigDecimal valorDesconto,
        @JsonProperty("valor_acrescimo") BigDecimal valorAcrescimo,
        @JsonProperty("valor_liquido") BigDecimal valorLiquido,
        @JsonProperty("valor_custo") BigDecimal valorCusto
) {}
