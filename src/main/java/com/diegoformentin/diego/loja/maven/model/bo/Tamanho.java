package com.diegoformentin.diego.loja.maven.model.bo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tamanho")
public class Tamanho implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTamanho;
    
    @Column(name = "descricaoTamanho")
    private String descricao;

    public Tamanho () {

    }

    public Tamanho(Long idTamanho, String descricao) {
        this.idTamanho = idTamanho;
        this.descricao = descricao;
    }

    public Long getIdTamanho() {
        return idTamanho;
    }

    public void setIdTamanho(Long idTamanho) {
        this.idTamanho = idTamanho;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Tamanho{" +
                "idTamanho=" + idTamanho +
                ", descricao='" + descricao + '\'' +
                '}'
        ;
    }
}