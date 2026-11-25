
package com.kigi.explorer.controller;

import com.kigi.explorer.model.PessoaListagemResponse;
import com.kigi.explorer.service.PessoaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public PessoaListagemResponse listarPessoas(
            @RequestParam(defaultValue = "1") Integer pagina,
            @RequestParam(required = false) String tipo) {

        return pessoaService.listarPessoas(pagina, tipo);
    }
}
