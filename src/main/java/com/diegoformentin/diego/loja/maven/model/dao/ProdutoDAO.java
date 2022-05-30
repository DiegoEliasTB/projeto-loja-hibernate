package com.diegoformentin.diego.loja.maven.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.diegoformentin.diego.loja.maven.model.bo.Produto;
import com.diegoformentin.diego.loja.maven.service.MarcaService;
import com.diegoformentin.diego.loja.maven.service.TamanhoService;
import com.diegoformentin.diego.loja.maven.service.TipoProdutoService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Diego
 */
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
//                + " p.idproduto,"
//                + " p.descricaoProduto, "
//                + " p.valProduto, "
//                + " p.marca_idmarca, "
//                + " p.tipoProduto_idtipoProduto, "
//                + " p.tamanho_idtamanho "
                + " FROM produto p "
                + " LEFT JOIN caracteristicaProduto c "
                + " on p.idProduto = c.produto "
                + " WHERE c.barra = :codigoBarrasParam";
        
        Produto produto = em.createQuery(query, Produto.class)
                .setParameter("codigoBarrasParam", codBarras)
                .getSingleResult();
        
        return produto;
    }
}
