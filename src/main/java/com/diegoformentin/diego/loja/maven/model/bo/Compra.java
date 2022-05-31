package com.diegoformentin.diego.loja.maven.model.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "compra")
public class Compra implements Serializable {

    @Id
    @JoinColumn (name = "idcompra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompra;
    
    //@Column
    @OneToOne
    @JoinColumn (name = "fornecedor_idfornecedor")
    private Fornecedor fornecedor;
    
    //@Column
    @OneToOne
    @JoinColumn (name = "condicaoPagamento_idcondicaoPagamento")
    private CondicaoPagamento condicaoPagamento;
    
    @JoinColumn (name = "numNFCompra")
    private Long numeroNota;
    
    @JoinColumn (name = "serieNFCompra")
    private String serieNota;
    
    @JoinColumn (name = "dtHrCompra")
    private LocalDate dataCompra;
    
    @JoinColumn (name = "descontoCompra")
    private BigDecimal desconto;
    
    @JoinColumn (name = "valorTotalCompra")
    private BigDecimal total;

    public Compra() {

    }

    public Compra(Long idCompra, Fornecedor fornecedor, CondicaoPagamento condicaoPagamento, Long numeroNota, String serieNota, LocalDate dataCompra, BigDecimal desconto, BigDecimal total) {
        this.idCompra = idCompra;
        this.fornecedor = fornecedor;
        this.condicaoPagamento = condicaoPagamento;
        this.numeroNota = numeroNota;
        this.serieNota = serieNota;
        this.dataCompra = dataCompra;
        this.desconto = desconto;
        this.total = total;
    }

    public Long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public CondicaoPagamento getCondicaoPagamento() {
        return condicaoPagamento;
    }

    public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
        this.condicaoPagamento = condicaoPagamento;
    }

    public Long getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(Long numeroNota) {
        this.numeroNota = numeroNota;
    }

    public String getSerieNota() {
        return serieNota;
    }

    public void setSerieNota(String serieNota) {
        this.serieNota = serieNota;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "idCompra=" + idCompra +
                ", fornecedor=" + fornecedor +
                ", condicaoPagamento=" + condicaoPagamento +
                ", numeroNota=" + numeroNota +
                ", serieNota='" + serieNota + '\'' +
                ", dataCompra=" + dataCompra +
                ", desconto=" + desconto +
                ", total=" + total +
                '}'
        ;
    }
}