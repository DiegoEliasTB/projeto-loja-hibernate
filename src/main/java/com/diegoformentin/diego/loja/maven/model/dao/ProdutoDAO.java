package com.diegoformentin.diego.loja.maven.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.diegoformentin.diego.loja.maven.model.bo.Produto;
import com.diegoformentin.diego.loja.maven.service.MarcaService;
import com.diegoformentin.diego.loja.maven.service.TamanhoService;
import com.diegoformentin.diego.loja.maven.service.TipoProdutoService;

/**
 *
 * @author Diego
 */
public class ProdutoDAO {
 
 
    public Produto buscarPorId(Long idProduto) {
        String sqlExecutar     =   " SELECT idproduto, "
                                 + " descricaoProduto, "
                                 + " valProduto, "
                                 + " marca_idmarca, "
                                 + " tipoProduto_idtipoProduto, "
                                 + " tamanho_idtamanho "
                                 + " FROM produto "
                                 + " WHERE produto.idproduto = ?";
        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, idProduto.intValue());
            rst = pstm.executeQuery();  
            Produto produto = new Produto();
            
            MarcaService marcaService  = new MarcaService();
            TipoProdutoService tipoProdutoService = new TipoProdutoService();
            TamanhoService tamanhoService = new TamanhoService();
            
            while(rst.next()){
                produto.setIdProduto(rst.getLong("idproduto"));
                produto.setDescricao(rst.getString("descricaoProduto"));
                produto.setValor(rst.getBigDecimal("valProduto"));
                
                final Long marcaId = rst.getLong("marca_idmarca");
                produto.setMarca(marcaService.buscarPorId(marcaId));
                
                final Long tipoProdutoId = rst.getLong("tipoProduto_idtipoProduto");
                produto.setTipoProduto(tipoProdutoService.buscarPorId(tipoProdutoId));
                
                final Long tamanhoId = rst.getLong("tamanho_idtamanho");
                produto.setTamanho(tamanhoService.buscarPorId(tamanhoId));
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return produto; 
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }
    
    public Produto buscarPorCodigoBarras(String codBarras) {
        String sqlExecutar     =   " SELECT idproduto, "
                                 + " descricaoProduto, "
                                 + " valProduto, "
                                 + " marca_idmarca, "
                                 + " tipoProduto_idtipoProduto, "
                                 + " tamanho_idtamanho "
                                 + " FROM produto p "
                                 + " LEFT JOIN caracteristicaproduto c "
                                 + " on p.idproduto = c.produto_idproduto "
                                 + " WHERE c.barraProduto = ?";
        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, codBarras.toString());
            rst = pstm.executeQuery();  
            Produto produto = new Produto();
            
            MarcaService marcaService  = new MarcaService();
            TipoProdutoService tipoProdutoService = new TipoProdutoService();
            TamanhoService tamanhoService = new TamanhoService();
            
            while(rst.next()){
                produto.setIdProduto(rst.getLong("idproduto"));
                produto.setDescricao(rst.getString("descricaoProduto"));
                produto.setValor(rst.getBigDecimal("valProduto"));
                
                final Long marcaId = rst.getLong("marca_idmarca");
                produto.setMarca(marcaService.buscarPorId(marcaId));
                
                final Long tipoProdutoId = rst.getLong("tipoProduto_idtipoProduto");
                produto.setTipoProduto(tipoProdutoService.buscarPorId(tipoProdutoId));
                
                final Long tamanhoId = rst.getLong("tamanho_idtamanho");
                produto.setTamanho(tamanhoService.buscarPorId(tamanhoId));
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return produto; 
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }
}
