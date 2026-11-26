package com.kigi.explorer.exception;

import com.kigi.explorer.dto.ErroResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ErroResponse> tratarErroKigi(HttpClientErrorException ex) {
        int status = ex.getStatusCode().value();

        if (status == 404) {
            return responder(HttpStatus.NOT_FOUND, "Registro não encontrado.");
        }
        if (status == 429) {
            return responder(HttpStatus.TOO_MANY_REQUESTS,
                    "Limite de requisições atingido. Tente novamente em instantes.");
        }
        // 401/403 são problema da nossa integração, não de quem chamou
        log.error("Erro na API Kigi: {}", status, ex);
        return responder(HttpStatus.BAD_GATEWAY, "Falha ao consultar a API Kigi.");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErroResponse> tratarValidacao(ConstraintViolationException ex) {
        String mensagem = ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining("; "));

        return responder(HttpStatus.BAD_REQUEST, mensagem);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResponse> tratarErroGenerico(Exception ex) {
        log.error("Erro inesperado", ex);
        return responder(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu um erro interno.");
    }

    private ResponseEntity<ErroResponse> responder(HttpStatus status, String mensagem) {
        return ResponseEntity.status(status).body(new ErroResponse(mensagem));
    }
}