package com.diegoformentin.diego.loja.maven.model.bo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "caracteristicaProduto")
public class CaracteristicaProduto implements Serializable {
    @Id
    @Column(name = "idCaracterisitcaProduto")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCaracteristicaProduto;
    
    //@Column(name = "produto_idproduto")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="produto_idproduto")//, referencedColumnName="caracteristicaProduto")
    private Produto produto;
    
    //@Column(name = "cor_idcor")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cor_idcor")
    private Cor cor;
    
    @Column(name = "tamanhoProduto")
    private String tamanho;
    
    @Column(name = "barraProduto")
    private String barra;
    
    @Column(name = "qtdEstoqueProduto")
    private Long quantidadeEstoque;

    public CaracteristicaProduto () {

    }

    public CaracteristicaProduto(Long idCaracteristicaProduto, Produto produto, Cor cor, String tamanho, String barra, Long quantidadeEstoque) {
        this.idCaracteristicaProduto = idCaracteristicaProduto;
        this.produto = produto;
        this.cor = cor;
        this.tamanho = tamanho;
        this.barra = barra;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Long getIdCaracteristicaProduto() {
        return idCaracteristicaProduto;
    }

    public void setIdCaracteristicaProduto(Long idCaracteristicaProduto) {
        this.idCaracteristicaProduto = idCaracteristicaProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getBarra() {
        return barra;
    }

    public void setBarra(String barra) {
        this.barra = barra;
    }

    public Long getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Long quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @Override
    public String toString() {
        return "CaracteristicaProduto{" +
                "idCaracteristicaProduto=" + idCaracteristicaProduto +
                ", produto=" + produto +
                ", cor=" + cor +
                ", tamanho='" + tamanho + '\'' +
                ", barra='" + barra + '\'' +
                ", quantidadeEstoque=" + quantidadeEstoque +
                '}'
        ;
    }
}