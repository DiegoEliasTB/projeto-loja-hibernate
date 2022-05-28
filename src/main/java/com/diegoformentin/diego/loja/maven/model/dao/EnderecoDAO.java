package com.diegoformentin.diego.loja.maven.model.dao;

import java.util.List;
import com.diegoformentin.diego.loja.maven.model.bo.Endereco;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

public class EnderecoDAO implements InterfaceDAO<Endereco> {

    private static EnderecoDAO instance;
    protected EntityManager em;
    
    public static EnderecoDAO getInstance() {
        if (instance == null) {
            instance = new EnderecoDAO();
        }
        return instance;
    }
    
    public EnderecoDAO() {
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
    public void create(Endereco objeto) {
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
    public List<Endereco> retrieve() {
        List<Endereco> enderecos;
        CriteriaQuery<Endereco> criteria = em.getCriteriaBuilder().createQuery(Endereco.class);
        
        criteria.select(criteria.from(Endereco.class));
        enderecos = em.createQuery(criteria).getResultList();
        return enderecos;
    }

    @Override
    public Endereco retrieve(int codigo) {
        return em.find(Endereco.class, codigo);
    }

    @Override
    public Endereco retrieve(String descricao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Endereco objeto) {
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
    public void delete(Endereco objeto) {
        try {
            em.getTransaction().begin();
            
            objeto = em.find(Endereco.class, objeto.getIdCep());
            
            em.remove(this);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}
