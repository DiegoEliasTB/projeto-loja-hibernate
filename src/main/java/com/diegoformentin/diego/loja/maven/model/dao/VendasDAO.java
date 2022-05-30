package com.diegoformentin.diego.loja.maven.model.dao;

import java.util.List;
import com.diegoformentin.diego.loja.maven.model.bo.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VendasDAO {
    
    private static VendasDAO instance;
    protected EntityManager em;
    
    public static VendasDAO getInstance() {
        if(instance == null) {
            instance = new VendasDAO();
        }
        return instance;
    }
    
    public VendasDAO() {
        em = getEntityManager();
    }
    
    private EntityManager getEntityManager() {
        EntityManagerFactory factory =  Persistence.createEntityManagerFactory("bancoloja");
        if (em == null) {
            em = factory.createEntityManager();
        } 
        
        return em;
    }
    
    public void create(Venda objeto) {
        
        try {
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
        
        
        
        
        
//        //Abrindo conexão
//        Connection conexao = ConnectionFactory.getConnection();
//        String sqlExecutar = "INSERT INTO venda (serieVenda, dtVenda, hrVenda, valDescontoVenda, valTotalVenda, cliente_idcliente, condicaoPagamento_idcondicaoPagamento, diaVencimentoParcela, vendedor_idvendedor) VALUES(?,?,?,?,?,?,?,?,?)";
//        PreparedStatement pstm = null;
//        
//        try{
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setString(1, objeto.getSerie());
//            pstm.setString(2, String.valueOf(objeto.getDataVenda())); //verificar se funciona
//            pstm.setString(3, objeto.getHora());
//            pstm.setBigDecimal(4, objeto.getDesconto());
//            pstm.setBigDecimal(5, objeto.getTotal());
//            pstm.setInt(6, objeto.getCliente().getIdCliente());
//            pstm.setLong(7, objeto.getCondicaoPagamento().getIdCondicaoPagamento());
//            pstm.setLong(8, objeto.getDiaVencimentoParcela());
//            pstm.setLong(9, objeto.getVendedor().getIdVendedor());
//            
//            pstm.executeUpdate();
//        } catch(Exception ex){
//            ex.printStackTrace();
//        }
//        //fechar a conexão
//        ConnectionFactory.closeConnection(conexao, pstm);
    }  
}
