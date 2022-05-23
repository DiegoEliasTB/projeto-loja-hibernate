package com.diegoformentin.diego.loja.maven.model.bo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cidade")
public class Cidade implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  idCidade;
    
    @Column
    private String descricaoCidade;
    
    @Column
    private String ufCidade;
    
    @OneToMany(mappedBy = "cidade")
    private List<Endereco> enderecos;

    public Cidade() {
    }

    public Cidade(int idCidade, String descricaoCidade, String ufCidade) {
        this.idCidade = idCidade;
        this.descricaoCidade = descricaoCidade;
        this.ufCidade = ufCidade;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getDescricaoCidade() {
        return descricaoCidade;
    }

    public void setDescricaoCidade(String descricaoCidade) {
        this.descricaoCidade = descricaoCidade;
    }

    public String getUfCidade() {
        return ufCidade;
    }

    public void setUfCidade(String ufCidade) {
        this.ufCidade = ufCidade;
    }

    @Override
    public String toString() {
        return this.getIdCidade() + "," + this.getDescricaoCidade() + ","+this.getUfCidade();
    }
    
    
    
}
