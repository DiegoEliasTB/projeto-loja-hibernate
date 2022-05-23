package com.diegoformentin.diego.loja.maven.model.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class ItensVenda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItensVenda;
    
    @Column
    @ManyToOne
    private Venda venda;
    
    @Column
    @OneToOne
    private CaracteristicaProduto caracteristicaProduto;
    
    @Column
    private BigDecimal valorUnitario;
    
    @Column
    private BigDecimal quantidadeProduto;

    public ItensVenda() {

    }

    public ItensVenda(Long idItensVenda, Venda venda, CaracteristicaProduto caracteristicaProduto, BigDecimal valorUnitario, BigDecimal quantidadeProduto) {
        this.idItensVenda = idItensVenda;
        this.venda = venda;
        this.caracteristicaProduto = caracteristicaProduto;
        this.valorUnitario = valorUnitario;
        this.quantidadeProduto = quantidadeProduto;
    }

    public Long getIdItensVenda() {
        return idItensVenda;
    }

    public void setIdItensVenda(Long idItensVenda) {
        this.idItensVenda = idItensVenda;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public CaracteristicaProduto getCaracteristicaProduto() {
        return caracteristicaProduto;
    }

    public void setCaracteristicaProduto(CaracteristicaProduto caracteristicaProduto) {
        this.caracteristicaProduto = caracteristicaProduto;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(BigDecimal quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    @Override
    public String toString() {
        return "ItensVenda{" +
                "idItensVenda=" + idItensVenda +
                ", venda=" + venda +
                ", caracteristicaProduto=" + caracteristicaProduto +
                ", valorUnitario=" + valorUnitario +
                ", quantidadeProduto=" + quantidadeProduto +
                '}'
        ;
    }
}