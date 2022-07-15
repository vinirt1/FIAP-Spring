package br.com.fiap.spring.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.fiap.spring.model.entity.Compra;

public class CompraDTO {
    private Long id;
    private Long numeroCartao;
    private String bandeiraCartao;
    private String estabelecimento;
    private BigDecimal valor;
    private LocalDateTime dataHora;
    private Integer status;

    public CompraDTO() {
    }

    public CompraDTO(Compra compra) {
        this.id = compra.getId();
        this.numeroCartao = compra.getNumeroCartao();
        this.bandeiraCartao = compra.getBandeiraCartao();
        this.estabelecimento = compra.getEstabelecimento();
        this.valor = compra.getValor();
        this.dataHora = compra.getDataHora();
        this.status = compra.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(Long numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getBandeiraCartao() {
        return bandeiraCartao;
    }

    public void setBandeiraCartao(String bandeiraCartao) {
        this.bandeiraCartao = bandeiraCartao;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(String estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
