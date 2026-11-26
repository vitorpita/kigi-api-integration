package com.kigi.explorer.service;

import com.kigi.explorer.dto.movimentacao.MovimentacaoDetalhe;
import com.kigi.explorer.dto.movimentacao.MovimentacaoListagemResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class MovimentacaoService {

    private final RestClient restClient;

    public MovimentacaoService(RestClient restClient) {
        this.restClient = restClient;
    }

    public MovimentacaoListagemResponse listarMovimentacoes(Integer pagina) {
        return restClient.get()
                .uri("/api/movimentacoes?pagina={pagina}", pagina)
                .retrieve()
                .body(MovimentacaoListagemResponse.class);
    }

    public MovimentacaoDetalhe buscarMovimentacaoPorId(Long id) {
        return restClient.get()
                .uri("/api/movimentacoes/{id}", id)
                .retrieve()
                .body(MovimentacaoDetalhe.class);
    }
}
