package com.diegoformentin.diego.loja.maven.model.bo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCor;
    
    @Column(name = "descricaoCor")
    private String descricao;

    public Cor() {

    }

    public Cor(int idCor, String descricao) {
        this.idCor = idCor;
        this.descricao = descricao;
    }

    public int getIdCor() {
        return idCor;
    }

    public void setIdCor(int idCor) {
        this.idCor = idCor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Cor{" +
                "idCor=" + idCor +
                ", descricao='" + descricao + '\'' +
                '}'
        ;
    }
}