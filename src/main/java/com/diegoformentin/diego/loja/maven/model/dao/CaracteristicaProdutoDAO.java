package com.diegoformentin.diego.loja.maven.model.dao;

import com.diegoformentin.diego.loja.maven.model.bo.CaracteristicaProduto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CaracteristicaProdutoDAO {
 
    private static CaracteristicaProdutoDAO instance;
    protected EntityManager em;
    
    public static CaracteristicaProdutoDAO getInstance() {
        if(instance == null) {
            instance = new CaracteristicaProdutoDAO();
        }
        return instance;
    }
    
    public CaracteristicaProdutoDAO() {
        em = getEntityManager();
    }
    
    private EntityManager getEntityManager() {
        EntityManagerFactory factory =  Persistence.createEntityManagerFactory("bancoloja");
        if (em == null) {
            em = factory.createEntityManager();
        } 
        
        return em;
    }
    
    public CaracteristicaProduto buscarPorId(Long id) {
        return em.find(CaracteristicaProduto.class, id);
    }
    
    public CaracteristicaProduto buscarPorCodigoBarras(String codBarras) {
        
        System.out.println("CodBarras: " + codBarras);
        
        String query = " SELECT * "
                //+ " p.idproduto,"
                //+ " p.descricao, "
                //+ " p.valor, "
                //+ " p.marca, "
                //+ " p.tipoProduto, "
                //+ " p.tamanho "
                + " FROM CaracteristicaProduto;";
                //+ " LEFT JOIN Produto p "
                //+ " on p.idProduto = c.produto "
                //+ " WHERE c.barra = :codigoBarrasParam;";
        
        CaracteristicaProduto cp = em.createQuery("SELECT c FROM CaracteristicaProduto c WHERE c.barra = :codigoBarrasParam", CaracteristicaProduto.class)
                .setParameter("codigoBarrasParam", codBarras)
                .getSingleResult();
        
        return cp;
    }
}
