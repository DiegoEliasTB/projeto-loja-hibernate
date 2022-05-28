package com.diegoformentin.diego.loja.maven.model.bo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCep;
    
    @Column
    private String cepCep;
    
    @Column
    private String logradouroCep;
    
    @OneToOne
    private Bairro bairro;
    
    @OneToOne
    private Cidade cidade;

    public Endereco() {
    }

    public Endereco(int idCep, String cepCep, String logradouroCep, Bairro bairro, Cidade cidade) {
        this.idCep = idCep;
        this.cepCep = cepCep;
        this.logradouroCep = logradouroCep;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public int getIdCep() {
        return idCep;
    }

    public void setIdCep(int idCep) {
        this.idCep = idCep;
    }

    public String getCepCep() {
        return cepCep;
    }

    public void setCepCep(String cepCep) {
        this.cepCep = cepCep;
    }

    public String getLogradouroCep() {
        return logradouroCep;
    }

    public void setLogradouroCep(String logradouroCep) {
        this.logradouroCep = logradouroCep;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return  this.getIdCep() + ","+
                this.getLogradouroCep()+ ","+
                this.getCepCep()+ ","+
                this.getCidade().getDescricaoCidade()+ ","+
                this.getBairro().getDescricaoBairro() + ",";
    }
  
  
  
}
