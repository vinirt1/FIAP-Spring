package br.com.fiap.spring.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.fiap.spring.model.dto.CompraCreateDTO;

@Entity
@Table(name = "TB_COMPRA")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NUMERO_CARTAO")
    private Long numeroCartao;

    @Column(name = "BANDEIRA_CARTAO")
    private String bandeiraCartao;

    @Column(name = "ESTABELECIMENTO")
    private String estabelecimento;

    @Column(name = "VALOR")
    private BigDecimal valor;

    @Column(name = "DATA_HORA")
    private LocalDateTime dataHora;

    @Column(name = "STATUS")
    private Integer status = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    public Compra() {
    }

    public Compra(CompraCreateDTO compraCreateDTO) {
        this.numeroCartao = compraCreateDTO.getNumeroCartao();
        this.bandeiraCartao = compraCreateDTO.getBandeiraCartao();
        this.estabelecimento = compraCreateDTO.getEstabelecimento();
        this.valor = compraCreateDTO.getValor();
        this.dataHora = compraCreateDTO.getDataHora();
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

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
