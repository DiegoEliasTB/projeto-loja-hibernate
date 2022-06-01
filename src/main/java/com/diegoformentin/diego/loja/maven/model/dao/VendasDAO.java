package com.diegoformentin.diego.loja.maven.model.dao;

import com.diegoformentin.diego.loja.maven.model.bo.Venda;
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
    }  
}
