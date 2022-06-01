package com.diegoformentin.diego.loja.maven.model.dao;

import com.diegoformentin.diego.loja.maven.model.bo.Produto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProdutoDAO {
 
    private static ProdutoDAO instance;
    protected EntityManager em;
    
    public static ProdutoDAO getInstance() {
        if(instance == null) {
            instance = new ProdutoDAO();
        }
        return instance;
    }
    
    public ProdutoDAO() {
        em = getEntityManager();
    }
    
    private EntityManager getEntityManager() {
        EntityManagerFactory factory =  Persistence.createEntityManagerFactory("bancoloja");
        if (em == null) {
            em = factory.createEntityManager();
        } 
        
        return em;
    }
    
    public Produto buscarPorId(Long idProduto) {
        return em.find(Produto.class, idProduto);
    }
    
    public Produto buscarPorCodigoBarras(String codBarras) {
        
        System.out.println("CodBarras: " + codBarras);
        
        String query = " SELECT p "
                + " FROM Produto p "
                + " LEFT JOIN CaracteristicaProduto c "
                + " on p.idProduto = c.produto "
                + " WHERE c.barra = :codigoBarrasParam";
        
        Produto produto = em.createQuery(query, Produto.class)
                .setParameter("codigoBarrasParam", codBarras)
                .getSingleResult();
        
        return produto;
    }
}
