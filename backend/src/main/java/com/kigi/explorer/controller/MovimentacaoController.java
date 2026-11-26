package com.kigi.explorer.controller;

import com.kigi.explorer.dto.movimentacao.MovimentacaoDetalhe;
import com.kigi.explorer.dto.movimentacao.MovimentacaoListagemResponse;
import com.kigi.explorer.service.MovimentacaoService;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movimentacoes")
@Validated
public class MovimentacaoController {

    private final MovimentacaoService movimentacaoService;

    public MovimentacaoController(MovimentacaoService movimentacaoService) {
        this.movimentacaoService = movimentacaoService;
    }

    @GetMapping
    public MovimentacaoListagemResponse listarMovimentacoes(
            @RequestParam(defaultValue = "1")
            @Min(value = 1, message = "O número da página deve ser maior ou igual a 1.")
            Integer pagina) {
        return movimentacaoService.listarMovimentacoes(pagina);
    }

    @GetMapping("/{id}")
    public MovimentacaoDetalhe buscarMovimentacaoPorId(
            @PathVariable
            @Min(value = 1, message = "O ID deve ser maior que zero.")
            Long id) {
        return movimentacaoService.buscarMovimentacaoPorId(id);
    }
}
