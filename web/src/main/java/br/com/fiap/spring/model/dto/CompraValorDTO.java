package br.com.fiap.spring.model.dto;

import java.math.BigDecimal;

public class CompraValorDTO {
    private BigDecimal valor;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}
