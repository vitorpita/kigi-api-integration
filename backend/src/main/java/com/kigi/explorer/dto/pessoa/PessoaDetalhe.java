package com.kigi.explorer.dto.pessoa;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.List;

public record PessoaDetalhe(
        Long id,
        @JsonProperty("tipos_pessoa") List<String> tiposPessoa,
        String status,
        String nome,
        @JsonProperty("cpf_cnpj") String cpfCnpj,
        List<String> telefones,
        List<String> emails,
        List<PessoaEndereco> enderecos,
        @JsonProperty("data_cadastro") OffsetDateTime dataCadastro,
        @JsonProperty("data_alteracao") OffsetDateTime dataAlteracao,
        List<String> tags,
        String genero,
        String naturalidade,
        @JsonProperty("tabela_preco") Referencia tabelaPreco,
        Referencia vendedor,
        List<Manequim> manequins
) {}