package com.diegoformentin.diego.loja.maven.model.bo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fornecedor")
public class Fornecedor extends Pessoa implements Serializable {

    @Id
    @Column(name = "idfornecedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFornecedor;
    
    @Column(name = "razaoSocialFornecedor")
    private String razaoSocialFornecedor;
    
    @Column(name = "cnpjFornecedor")
    private String cnpjFornecedor;
    
    @Column(name = "inscEstadualFornecedor")
    private String inscEstadualFornecedor;

    public Fornecedor() {
    }

    public Fornecedor(int idFornecedor, String razaoSocialFornecedor, String cnpjFornecedor, String inscEstadualFornecedor, String nome, String email, String compleEndereco, Endereco endereco) {
        super(nome, email, compleEndereco, endereco);
        this.idFornecedor = idFornecedor;
        this.razaoSocialFornecedor = razaoSocialFornecedor;
        this.cnpjFornecedor = cnpjFornecedor;
        this.inscEstadualFornecedor = inscEstadualFornecedor;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getRazaoSocialFornecedor() {
        return razaoSocialFornecedor;
    }

    public void setRazaoSocialFornecedor(String razaoSocialFornecedor) {
        this.razaoSocialFornecedor = razaoSocialFornecedor;
    }

    public String getCnpjFornecedor() {
        return cnpjFornecedor;
    }

    public void setCnpjFornecedor(String cnpjFornecedor) {
        this.cnpjFornecedor = cnpjFornecedor;
    }

    public String getInscEstadualFornecedor() {
        return inscEstadualFornecedor;
    }

    public void setInscEstadualFornecedor(String inscEstadualFornecedor) {
        this.inscEstadualFornecedor = inscEstadualFornecedor;
    }

    
    @Override
    public String toString() {
        return  this.getIdFornecedor()+ "," +
                this.getNome()+ "," +
                this.getRazaoSocialFornecedor()+ "," +
                this.getCnpjFornecedor()+ "," +
                this.getInscEstadualFornecedor()+ "," +
                this.getEmail()+ "," +
                this.getEndereco().getCidade()+ "," +
                this.getEndereco().getBairro()+ "," +
                this.getEndereco().getCepCep()+ "," +
                this.getEndereco().getLogradouroCep()+
                this.getCompleEndereco();
     
}

}
