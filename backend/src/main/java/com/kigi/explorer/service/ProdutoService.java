package com.kigi.explorer.service;

import com.kigi.explorer.model.ProdutoDetalhe;
import com.kigi.explorer.model.ProdutoListagemResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ProdutoService {
    private final RestClient restClient;

    public ProdutoService(RestClient restClient) {
        this.restClient = restClient;
    }

    public ProdutoListagemResponse listarProdutos(Integer pagina) {
        return restClient.get()
                .uri("/api/produtos?pagina={pagina}", pagina)
                .retrieve()
                .body(ProdutoListagemResponse.class);
    }

    public ProdutoDetalhe buscarProdutoPorId(String id) {
        return restClient.get()
                .uri("/api/produtos/{id}", id)
                .retrieve()
                .body(ProdutoDetalhe.class);
    }

}
