package com.diegoformentin.diego.loja.maven.model.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;
    
    @Column(name = "descricaoProduto")
    private String descricao;
    
    @Column(name = "valProduto")
    private BigDecimal valor;
    
    //@Column(name = "marca_idmarca")
    //@OneToMany //@JoinColumn(name = "idmarca")
    //@JoinTable(name = "marca", joinColumns = {@JoinColumn(name = "idmarca")})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "marca_idmarca")
    private Marca marca;
    
    @Column(name = "tipoProduto_idtipoProduto")
    private TipoProduto tipoProduto;
    
    //@Column(name = "tamanho_idtamanho")
    //@OneToMany
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "tamanho_idtamanho")
    private Tamanho tamanho;

//    @OneToOne(mappedBy = "CaracteristicaProduto")
//    private CaracteristicaProduto caracteristicaProduto;
    
    public Produto () {

    }

    public Produto(Long idProduto, String descricao, BigDecimal valor, Marca marca, TipoProduto tipoProduto, Tamanho tamanho) {
        this.idProduto = idProduto;
        this.descricao = descricao;
        this.valor = valor;
        this.marca = marca;
        this.tipoProduto = tipoProduto;
        this.tamanho = tamanho;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "idProduto=" + idProduto +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", marca=" + marca +
                ", tipoProduto=" + tipoProduto +
                ", tamanho=" + tamanho +
                '}'
        ;
    }
}