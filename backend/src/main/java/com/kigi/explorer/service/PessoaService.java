
package com.kigi.explorer.service;

import com.kigi.explorer.dto.pessoa.PessoaDetalhe;
import com.kigi.explorer.dto.pessoa.PessoaListagemResponse;
import com.kigi.explorer.enums.TipoPessoa;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class PessoaService {

    private final RestClient restClient;

    public PessoaService(RestClient restClient) {
        this.restClient = restClient;
    }


    public PessoaListagemResponse listarPessoas(Integer pagina, TipoPessoa tipo) {

        return restClient.get()
                .uri(uriBuilder -> {
                    var builder = uriBuilder
                            .path("/api/pessoas")
                            .queryParam("pagina", pagina);

                    if (tipo != null) {
                        builder.queryParam("tipo", tipo.getValor());
                    }

                    return builder.build();
                })
                .retrieve()
                .body(PessoaListagemResponse.class);
    }


    public PessoaDetalhe buscarPessoaPorId(Long id) {
        return restClient.get()
                .uri("/api/pessoas/{id}", id)
                .retrieve()
                .body(PessoaDetalhe.class);
    }
}
