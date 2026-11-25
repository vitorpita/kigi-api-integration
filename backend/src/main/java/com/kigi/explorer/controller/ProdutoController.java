package com.kigi.explorer.controller;

import com.kigi.explorer.model.ProdutoDetalhe;
import com.kigi.explorer.model.ProdutoListagemResponse;
import com.kigi.explorer.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ProdutoListagemResponse listarProdutos(
            @RequestParam(defaultValue ="1") Integer pagina){
        return produtoService.listarProdutos(pagina);
    }

    @GetMapping("/{id}")
    public ProdutoDetalhe buscarProdutoPorId(@PathVariable String id) {
        return produtoService.buscarProdutoPorId(id);
    }

}
