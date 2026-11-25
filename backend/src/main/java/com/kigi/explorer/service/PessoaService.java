
package com.kigi.explorer.service;

import com.kigi.explorer.model.PessoaListagemResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class PessoaService {

    private final RestClient restClient;

    public PessoaService(RestClient restClient) {
        this.restClient = restClient;
    }

    public PessoaListagemResponse listarPessoas(Integer pagina, String tipo) {

        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/pessoas")
                        .queryParam("pagina", pagina)
                        .queryParam("tipo", tipo)
                        .build())
                .retrieve()
                .body(PessoaListagemResponse.class);
    }
}
