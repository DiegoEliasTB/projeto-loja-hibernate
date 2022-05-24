package com.diegoformentin.diego.loja.maven.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;
import com.diegoformentin.diego.loja.maven.model.bo.Cliente;
import com.diegoformentin.diego.loja.maven.model.bo.Endereco;
import com.diegoformentin.diego.loja.maven.service.EnderecoService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

public class ClienteDAO implements InterfaceDAO<Cliente> {

    private static ClienteDAO instance;
    protected EntityManager em;
    
    public static ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }
    
    public ClienteDAO() {
        em = getEntityManager();
    }
    
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("bancoloja");
        if (em == null) {
            em = factory.createEntityManager();
        }
        
        return em;
    }
    
    @Override
    public void create(Cliente objeto) {
       try {
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
    
    public int buscaTotal() {
         //Abrindo conexão
        
        String sqlExecutar = " SELECT COUNT(*) AS total from cliente ";

        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        int total = 0;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();     
            
            while(rst.next()){
                total = rst.getInt("total");
            }
            
            
            
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return total;       
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return 0;
        }
    }

    @Override
    public List<Cliente> retrieve() {
        List<Cliente> clientes;
        CriteriaQuery<Cliente> criteria = em.getCriteriaBuilder().createQuery(Cliente.class);
        
        criteria.select(criteria.from(Cliente.class));
        clientes = em.createQuery(criteria).getResultList();
        return clientes;
    }

    @Override
    public Cliente retrieve(int codigo) {
        return em.find(Cliente.class, codigo);
    }

    @Override
    public Cliente retrieve(String descricao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Cliente objeto) {
        try {
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Cliente objeto) {
        try {
            em.getTransaction().begin();
            
            objeto = em.find(Cliente.class, objeto.getIdCliente());
            
            em.refresh(this);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
