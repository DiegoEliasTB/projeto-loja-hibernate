package com.diegoformentin.diego.loja.maven.model.bo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "condicaopagamento")
public class CondicaoPagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCondicaoPagamento;
    
    @Column
    private String descricao;
    
    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate diasAtePrimeiraParcela;
    
    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate diasEntreParcelas;

    public CondicaoPagamento () {

    }

    public CondicaoPagamento(Long idCondicaoPagamento, String descricao, LocalDate diasAtePrimeiraParcela, LocalDate diasEntreParcelas) {
        this.idCondicaoPagamento = idCondicaoPagamento;
        this.descricao = descricao;
        this.diasAtePrimeiraParcela = diasAtePrimeiraParcela;
        this.diasEntreParcelas = diasEntreParcelas;
    }

    public Long getIdCondicaoPagamento() {
        return idCondicaoPagamento;
    }

    public void setIdCondicaoPagamento(Long idCondicaoPagamento) {
        this.idCondicaoPagamento = idCondicaoPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDiasAtePrimeiraParcela() {
        return diasAtePrimeiraParcela;
    }

    public void setDiasAtePrimeiraParcela(Date diasAtePrimeiraParcela) {
        this.diasAtePrimeiraParcela = LocalDate.parse(diasAtePrimeiraParcela.toString());
    }

    public LocalDate getDiasEntreParcelas() {
        return diasEntreParcelas;
    }

    public void setDiasEntreParcelas(Date diasEntreParcelas) {
        this.diasEntreParcelas = LocalDate.parse(diasEntreParcelas.toString());
    }

    @Override
    public String toString() {
        return "CondicaoPagamento{" +
                "idCondicaoPagamento=" + idCondicaoPagamento +
                ", descricao='" + descricao + '\'' +
                ", diasAtePrimeiraParcela=" + diasAtePrimeiraParcela +
                ", diasEntreParcelas=" + diasEntreParcelas +
                '}'
        ;
    }
}