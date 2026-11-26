package com.kigi.explorer.dto.movimentacao;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.List;

public record MovimentacaoDetalhe(
        @JsonProperty("codigo_venda") Long codigoVenda,
        @JsonProperty("codigo_sequencial") String codigoSequencial,
        @JsonProperty("data_hora_venda") OffsetDateTime dataHoraVenda,
        @JsonProperty("data_alteracao") OffsetDateTime dataAlteracao,
        @JsonProperty("tipo_operacao") String tipoOperacao,
        @JsonProperty("tipo_venda") String tipoVenda,
        @JsonProperty("usuario_cadastrou") String usuarioCadastrou,
        @JsonProperty("codigo_cliente") Long codigoCliente,
        @JsonProperty("nome_cliente") String nomeCliente,
        @JsonProperty("codigo_vendedor") Long codigoVendedor,
        @JsonProperty("nome_vendedor") String nomeVendedor,
        List<MovimentacaoItem> itens
) {}
