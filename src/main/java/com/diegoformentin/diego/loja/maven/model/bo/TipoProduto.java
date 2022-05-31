package com.diegoformentin.diego.loja.maven.model.bo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipoProduto")
public class TipoProduto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoProduto;
    
    @Column(name = "descricaoTipoProduto")
    private String descricao;

    public  TipoProduto () {

    }

    public TipoProduto(Long idTipoProduto, String descricao) {
        this.idTipoProduto = idTipoProduto;
        this.descricao = descricao;
    }

    public Long getIdTipoProduto() {
        return idTipoProduto;
    }

    public void setIdTipoProduto(Long idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "TipoProduto{" +
                "idTipoProduto=" + idTipoProduto +
                ", descricao='" + descricao + '\'' +
                '}'
        ;
    }
}