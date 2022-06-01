package com.diegoformentin.diego.loja.maven.model.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "venda")
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenda;
    
    @Column(name = "serieVenda")
    private String serie;
    
    @Column(name = "dtVenda")
    private LocalDate dataVenda;
    
    @Column(name = "hrVenda")
    private String hora;
    
    @Column(name = "valDescontoVenda")
    private BigDecimal desconto;
    
    @Column(name = "valTotalVenda")
    private BigDecimal total;
    
    //@Column
    @ManyToOne @JoinColumn(name = "cliente_idcliente")
    private Cliente cliente;
    
    //@Column
    @ManyToOne @JoinColumn(name = "condicaoPagamento_idcondicaoPAgamento")
    private CondicaoPagamento condicaoPagamento;
    
    @Column(name = "diaVencimentoParcela")
    private Long diaVencimentoParcela;
    
    //@Column
    @ManyToOne @JoinColumn(name = "vendedor_idvendedor")
    private Vendedor vendedor;

    public Venda() {

    }

    public Venda(Long idVenda, String serie, LocalDate dataVenda, String hora, BigDecimal desconto, BigDecimal total, Cliente cliente, CondicaoPagamento condicaoPagamento, Long diaVencimentoParcela, Vendedor vendedor) {
        this.idVenda = idVenda;
        this.serie = serie;
        this.dataVenda = dataVenda;
        this.hora = hora;
        this.desconto = desconto;
        this.total = total;
        this.cliente = cliente;
        this.condicaoPagamento = condicaoPagamento;
        this.diaVencimentoParcela = diaVencimentoParcela;
        this.vendedor = vendedor;
    }

    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public CondicaoPagamento getCondicaoPagamento() {
        return condicaoPagamento;
    }

    public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
        this.condicaoPagamento = condicaoPagamento;
    }

    public Long getDiaVencimentoParcela() {
        return diaVencimentoParcela;
    }

    public void setDiaVencimentoParcela(Long diaVencimentoParcela) {
        this.diaVencimentoParcela = diaVencimentoParcela;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "idVenda=" + idVenda +
                ", serie='" + serie + '\'' +
                ", dataVenda=" + dataVenda +
                ", hora='" + hora + '\'' +
                ", desconto=" + desconto +
                ", total=" + total +
                ", cliente=" + cliente +
                ", condicaoPagamento=" + condicaoPagamento +
                ", diaVencimentoParcela=" + diaVencimentoParcela +
                ", vendedor=" + vendedor +
                '}'
        ;
    }
}