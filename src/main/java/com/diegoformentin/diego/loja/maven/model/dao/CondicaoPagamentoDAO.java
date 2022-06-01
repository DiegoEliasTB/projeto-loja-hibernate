package com.diegoformentin.diego.loja.maven.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.diegoformentin.diego.loja.maven.model.bo.CondicaoPagamento;

public class CondicaoPagamentoDAO {
    public CondicaoPagamento buscarPorId(Long idCondicaoPagamento) {
        String sqlExecutar     =   " SELECT idcondicaoPagamento, "
                                 + " descricaoCondicaoPagamento, "
                                 + " numDiasAtePrimeiraParcela, "
                                 + " numDiasEntreParcelas "
                                 + " FROM condicaopagamento "
                                 + " WHERE condicaopagamento.idcondicaoPagamento = ?";
        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, idCondicaoPagamento.intValue());
            rst = pstm.executeQuery();  
            CondicaoPagamento condicaoPagamento = new CondicaoPagamento();
            while(rst.next()){
                condicaoPagamento.setIdCondicaoPagamento(rst.getLong("idcondicaoPagamento"));
                condicaoPagamento.setDescricao(rst.getString("descricaoCondicaoPagamento"));
                condicaoPagamento.setDiasAtePrimeiraParcela(rst.getDate("numDiasAtePrimeiraParcela"));
                condicaoPagamento.setDiasEntreParcelas(rst.getDate("numDiasEntreParcelas"));
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return condicaoPagamento; 
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }
}
