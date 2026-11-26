
package com.kigi.explorer.controller;

import com.kigi.explorer.dto.pessoa.PessoaDetalhe;
import com.kigi.explorer.dto.pessoa.PessoaListagemResponse;
import com.kigi.explorer.enums.TipoPessoa;
import com.kigi.explorer.service.PessoaService;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoas")
@Validated
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }


    @GetMapping
    public PessoaListagemResponse listarPessoas(
            @RequestParam(defaultValue = "1")
            @Min(value = 1, message = "O número da página deve ser maior ou igual a 1.")
            Integer pagina,

            @RequestParam(required = false)
            @Pattern(
                    regexp = "cliente|fornecedor|guia",
                    message = "O tipo deve ser cliente, fornecedor ou guia."
            )
            String tipo) {

        TipoPessoa tipoPessoa = tipo == null
                ? null
                : TipoPessoa.valueOf(tipo.toUpperCase());

        return pessoaService.listarPessoas(pagina, tipoPessoa);
    }


    @GetMapping("/{id}")
    public PessoaDetalhe buscarPessoaPorId(
            @PathVariable
            @Min(value = 1, message = "O ID deve ser maior que zero.")Long id) {
        return pessoaService.buscarPessoaPorId(id);
    }


}
