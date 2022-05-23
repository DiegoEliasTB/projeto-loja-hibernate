package com.diegoformentin.diego.loja.maven.model.dao;

import java.util.List;
import com.diegoformentin.diego.loja.maven.model.bo.Cidade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

public class CidadeDAO implements InterfaceDAO<Cidade>{
    
    private static CidadeDAO instance;
    protected EntityManager entityManager;
    
    public static CidadeDAO getInstance() {
        if(instance == null) {
            instance = new CidadeDAO();
        }
        return instance;
    }
    
    public CidadeDAO() {
        entityManager = getEntityManager();
    }
    
    private EntityManager getEntityManager() {
        EntityManagerFactory factory =  Persistence.createEntityManagerFactory("bancoloja");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        } 
        
        return entityManager;
    }
    
    @Override
    public void create(Cidade objeto) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(objeto);
            entityManager.getTransaction().commit();
            
        } catch (Exception ex) {
            
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    @Override
    public List<Cidade> retrieve() {
        List<Cidade> cidadesLista;
        CriteriaQuery<Cidade> criteria = entityManager.getCriteriaBuilder().createQuery(Cidade.class);

        criteria.select(criteria.from(Cidade.class));
        cidadesLista = entityManager.createQuery(criteria).getResultList();
        return cidadesLista;
    }
    
    @Override
    public Cidade retrieve(int codigo) {
        return entityManager.find(Cidade.class, codigo);
    }
    
    @Override
    public void update(Cidade objeto) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(objeto);
            entityManager.getTransaction().commit();
            
        } catch (Exception ex) {
            
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    @Override
    public void delete(Cidade objeto) {
        try {
            entityManager.getTransaction().begin();
            
            objeto = entityManager.find(Cidade.class, objeto.getIdCidade());
            
            entityManager.remove(this);
            entityManager.getTransaction().commit();
            
        } catch (Exception ex) {
            
            ex.printStackTrace();
        }
    }

    @Override
    public Cidade retrieve(String descricao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
