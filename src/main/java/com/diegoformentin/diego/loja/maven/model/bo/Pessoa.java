package com.diegoformentin.diego.loja.maven.model.bo;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
public abstract class Pessoa {
    
    @Column
    private String nome;
    
    @Column
    private String email;
    
    @Column
    private String compleEndereco;
    
    @OneToOne @JoinColumn(name="endereco")
    private Endereco endereco;

    public Pessoa() {
    }

    public Pessoa(String nome, String email, String compleEndereco, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.compleEndereco = compleEndereco;
        this.endereco = endereco;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompleEndereco() {
        return compleEndereco;
    }

    public void setCompleEndereco(String compleEndereco) {
        this.compleEndereco = compleEndereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return  this.getNome() + ","+
                this.getEmail() + ","+
                this.getEndereco().getCepCep() + ","+
                this.getEndereco().getBairro()+ ","+
                this.getEndereco().getCidade()+ ","+
                this.getEndereco().getLogradouroCep()+ ","+
                this.getCompleEndereco() ;
    }
    
    
    
}
