package com.diegoformentin.diego.loja.maven.model.dao;

import java.util.List;
import com.diegoformentin.diego.loja.maven.model.bo.Bairro;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

public class BairroDAO implements InterfaceDAO<Bairro>{
    
    private static BairroDAO instance;
    protected EntityManager em;
    
    public static BairroDAO getInstance() {
        if (instance == null) {
            instance = new BairroDAO();
        }
        return instance;
    }
    
    public BairroDAO() {
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
    public void create(Bairro objeto) {
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
    public List<Bairro> retrieve() {
        List<Bairro> bairros;
        CriteriaQuery<Bairro> criteria = em.getCriteriaBuilder().createQuery(Bairro.class);
        
        criteria.select(criteria.from(Bairro.class));
        bairros = em.createQuery(criteria).getResultList();
        return bairros;
    }
    
    @Override
    public Bairro retrieve(int codigo) {
        return em.find(Bairro.class, codigo);
    }

    @Override
    public Bairro retrieve(String descricao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Bairro objeto) {
        try {
            Bairro bairro = em.find(objeto.getClass(), objeto.getIdBairro());
            em.getTransaction().begin();
            bairro.setDescricaoBairro(objeto.getDescricaoBairro());
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Bairro objeto) {
        try {
            em.getTransaction().begin();
            
            objeto = em.find(Bairro.class, objeto.getIdBairro());
            
            em.remove(this);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
}
