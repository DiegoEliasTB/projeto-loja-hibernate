package com.diegoformentin.diego.loja.maven.model.bo;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;
    
    
    //@Temporal(TemporalType.DATE)
    @Column
    private LocalDate dtNasc;
    
    @Column
    private String cpfCliente;
    
    @Column
    private String rgCliente;
    
    @Column
    private String foneCliente;
    
    @Column
    private String fone2Cliente;

    public Cliente() {
    }

    public Cliente(int idClinete,LocalDate dtNasc, String cpfCliente, String rgCliente, String foneCliente, String fone2Cliente, String nome, String email, String compleEndereco, Endereco endereco) {
        super(nome, email, compleEndereco, endereco);
        this.idCliente = idClinete;
        this.dtNasc = dtNasc;
        this.cpfCliente = cpfCliente;
        this.rgCliente = rgCliente;
        this.foneCliente = foneCliente;
        this.fone2Cliente = fone2Cliente;
    }

      public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }  
    
    public LocalDate getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(LocalDate dtNasc) {
        this.dtNasc = dtNasc;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getRgCliente() {
        return rgCliente;
    }

    public void setRgCliente(String rgCliente) {
        this.rgCliente = rgCliente;
    }

    public String getFoneCliente() {
        return foneCliente;
    }

    public void setFoneCliente(String foneCliente) {
        this.foneCliente = foneCliente;
    }

    public String getFone2Cliente() {
        return fone2Cliente;
    }

    public void setFone2Cliente(String fone2Cliente) {
        this.fone2Cliente = fone2Cliente;
    }

    @Override
    public String toString() {
        return  this.getIdCliente() + ","+
                super.toString() + ","+
                this.getCpfCliente() + ","+
                this.getRgCliente() + ","+
                this.getDtNasc() + ","+
                this.getFoneCliente() + ","+
                this.getFone2Cliente();
    }


    
    
    
}
