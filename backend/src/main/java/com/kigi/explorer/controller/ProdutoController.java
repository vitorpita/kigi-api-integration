package com.kigi.explorer.controller;

import com.kigi.explorer.dto.produto.ProdutoDetalhe;
import com.kigi.explorer.dto.produto.ProdutoListagemResponse;
import com.kigi.explorer.service.ProdutoService;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/produtos")
@Validated
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ProdutoListagemResponse listarProdutos(
            @RequestParam(defaultValue ="1")
            @Min(value = 1, message = "O número da página deve ser maior ou igual a 1.")
            Integer pagina){
        return produtoService.listarProdutos(pagina);
    }

    @GetMapping("/{id}")
    public ProdutoDetalhe buscarProdutoPorId(@PathVariable String id) {
        return produtoService.buscarProdutoPorId(id);
    }

}
