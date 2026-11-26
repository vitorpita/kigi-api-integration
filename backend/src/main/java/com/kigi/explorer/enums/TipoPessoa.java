
package com.kigi.explorer.enums;

public enum TipoPessoa {

    CLIENTE("cliente"),
    FORNECEDOR("fornecedor"),
    GUIA("guia");

    private final String valor;

    TipoPessoa(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
