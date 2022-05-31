package com.diegoformentin.diego.loja.maven.model.dao;

import com.diegoformentin.diego.loja.maven.model.bo.Vendedor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VendedorDAO {
    
    private static VendedorDAO instance;
    protected EntityManager em;
    
    public static VendedorDAO getInstance() {
        if (instance == null) {
            instance = new VendedorDAO();
        }
        return instance;
    }
    
    public VendedorDAO() {
        em = getEntityManager();
    }
    
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("bancoloja");
        if (em == null) {
            em = factory.createEntityManager();
        }
        
        return em;
    }
    
    public Vendedor buscarPorId(Long id) {
        return em.find(Vendedor.class, id);
    }
}
