package com.diegoformentin.diego.loja.maven.controller;

import com.diegoformentin.diego.loja.maven.model.bo.Cliente;
import com.diegoformentin.diego.loja.maven.model.bo.CondicaoPagamento;
import com.diegoformentin.diego.loja.maven.model.bo.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;
import javax.swing.table.DefaultTableModel;
import com.diegoformentin.diego.loja.maven.model.bo.Venda;
import com.diegoformentin.diego.loja.maven.model.bo.Vendedor;
import com.diegoformentin.diego.loja.maven.service.CaracteristicaProdutoService;
import com.diegoformentin.diego.loja.maven.service.ClienteService;
import com.diegoformentin.diego.loja.maven.service.CondicaoPagamentoService;
import com.diegoformentin.diego.loja.maven.service.ProdutoService;
import com.diegoformentin.diego.loja.maven.service.VendasService;
import com.diegoformentin.diego.loja.maven.service.VendedorService;
import com.diegoformentin.diego.loja.maven.view.TelaVendas;

public class ControllerVendas implements ActionListener {
    
    TelaVendas telaVendas;
    ProdutoService service = new ProdutoService();
    ClienteService clienteService = new ClienteService();
    CondicaoPagamentoService condicaoPagamentoService = new CondicaoPagamentoService();
    VendedorService vendedorService = new VendedorService();
            
    Random random = new Random();
    
    Long idProduto = 0L;
    String nomeProduto = "";
    Long qtdItens = 0L;
    BigDecimal valorProduto = new BigDecimal(0L);
    BigDecimal subTotal = new BigDecimal(0L);
    Long itens = 0L;
    BigDecimal totalVenda = new BigDecimal(0L);
    
    public ControllerVendas(TelaVendas telaVendas) {
        this.telaVendas = telaVendas;
        this.telaVendas.getjButtonBuscaAluno().addActionListener(this);
        this.telaVendas.getjButtonBuscaProduto().addActionListener(this);
        this.telaVendas.getjTextFieldBarraProduto().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    //
                } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
                    
                    //Variáveis para grid
//                    Long idProduto = 0L;
//                    String nomeProduto = "";
//                    Long qtdItens = 0L;
//                    BigDecimal valorProduto = new BigDecimal(0L);
//                    BigDecimal subTotal = new BigDecimal(0L);
                    
                    itens++;
                                   
                    String campo = telaVendas.getjTextFieldBarraProduto().getText();
                    
                    String codigoBarras = campo.substring(2,15);
                    
                    Produto produto = service.buscarPorCodigoBarras(codigoBarras);
                    
                    idProduto = produto.getIdProduto();
                    
                    nomeProduto = produto.getDescricao();
                    
                    qtdItens = Long.valueOf(campo.substring(0,1));
                    
                    valorProduto = produto.getValor();

                    subTotal = valorProduto.multiply(BigDecimal.valueOf(qtdItens));
                        
                    totalVenda = totalVenda.add(subTotal);
                    
                    DefaultTableModel tabela = (DefaultTableModel) telaVendas.getjTableItens().getModel();
                    tabela.addRow(new Object[]{
                        itens,
                        idProduto,
                        nomeProduto,
                        qtdItens,
                        valorProduto,
                        subTotal
                    });
                    
                    telaVendas.getjLabelTotal().setText("R$ " + String.valueOf(totalVenda));
                    
                } else if (evt.getKeyCode() == KeyEvent.VK_F2) {
                    
                    System.out.println("cliente: " + telaVendas.getjFTFidAluno().getText());
                    
                    VendasService vendasService = new VendasService();
                    
                    Venda venda = new Venda();
                    
                    int serieAleatoria = random.nextInt(10000) + 1;
                    venda.setSerie(String.valueOf(serieAleatoria));
                    venda.setDataVenda(LocalDate.now());
                    venda.setTotal(totalVenda);
                    
                    
                    System.out.println("cliente: " + Integer.valueOf(telaVendas.getjFTFidAluno().getText()) );
                    
                    Cliente cliente = clienteService.buscar(Integer.valueOf(telaVendas.getjFTFidAluno().getText()));
                    venda.setCliente(cliente);
                    
                    CondicaoPagamento condicaoPagamento = condicaoPagamentoService.buscarPorId(1L);
                    venda.setCondicaoPagamento(condicaoPagamento);
                    
                    Vendedor vendedor = vendedorService.buscarPorId(1L);
                    venda.setVendedor(vendedor);
                    
                    venda.setDiaVencimentoParcela(vendedor.getIdVendedor());
                    
                    vendasService.salvar(venda);
                } else if (evt.getKeyCode() == KeyEvent.VK_F3) {

                } else if (evt.getKeyCode() == KeyEvent.VK_F4) {

                } else if (evt.getKeyCode() == KeyEvent.VK_F5) {
                    
                }
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
    } 
}
