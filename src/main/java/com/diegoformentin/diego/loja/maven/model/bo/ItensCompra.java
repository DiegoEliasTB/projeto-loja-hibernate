package com.diegoformentin.diego.loja.maven.model.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class ItensCompra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItemCompra;
    
    @Column
    @OneToMany
    private Compra compra;
    
    @Column
    @OneToOne
    private CaracteristicaProduto caracteristicaProduto;
    
    @Column
    private BigDecimal quantidade;
    
    @Column
    private BigDecimal valorUnitario;

    public ItensCompra() {

    }

    public ItensCompra(Long idItemCompra, Compra compra, CaracteristicaProduto caracteristicaProduto, BigDecimal quantidade, BigDecimal valorUnitario) {
        this.idItemCompra = idItemCompra;
        this.compra = compra;
        this.caracteristicaProduto = caracteristicaProduto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public Long getIdItemCompra() {
        return idItemCompra;
    }

    public void setIdItemCompra(Long idItemCompra) {
        this.idItemCompra = idItemCompra;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public CaracteristicaProduto getCaracteristicaProduto() {
        return caracteristicaProduto;
    }

    public void setCaracteristicaProduto(CaracteristicaProduto caracteristicaProduto) {
        this.caracteristicaProduto = caracteristicaProduto;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public String toString() {
        return "ItensCompra{" +
                "idItemCompra=" + idItemCompra +
                ", compra=" + compra +
                ", caracteristicaProduto=" + caracteristicaProduto +
                ", quantidade=" + quantidade +
                ", valorUnitario=" + valorUnitario +
                '}'
        ;
    }
}