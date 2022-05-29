package com.diegoformentin.diego.loja.maven.model.dao;

import com.diegoformentin.diego.loja.maven.model.bo.Cor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

public class CorDAO implements InterfaceDAO<Cor>{
    
    private static CorDAO instance;
    protected EntityManager em;
    
    public static CorDAO getInstance() {
        if (instance == null) {
            instance = new CorDAO();
        }
        return instance;
    }
    
    public CorDAO() {
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
    public void create(Cor objeto) {
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
    public List<Cor> retrieve() {
        List<Cor> cores;
        CriteriaQuery<Cor> criteria = em.getCriteriaBuilder().createQuery(Cor.class);
        
        criteria.select(criteria.from(Cor.class));
        cores = em.createQuery(criteria).getResultList();
        return cores;
    }
    
    @Override
    public Cor retrieve(int codigo) {
        return em.find(Cor.class, codigo);
    }

    @Override
    public Cor retrieve(String descricao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Cor objeto) {
        try {
            Cor cor = em.find(objeto.getClass(), objeto.getIdCor());
            em.getTransaction().begin();
            cor.setDescricao(objeto.getDescricao());
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Cor objeto) {
        try {
            em.getTransaction().begin();
            
            objeto = em.find(Cor.class, objeto.getIdCor());
            
            em.remove(this);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
