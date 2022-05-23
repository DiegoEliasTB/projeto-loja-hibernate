/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.diegoformentin.diego.loja.maven.service;

import com.diegoformentin.diego.loja.maven.model.dao.ProdutoDAO;
import com.diegoformentin.diego.loja.maven.model.bo.Produto;

/**
 *
 * @author Diego
 */
public class ProdutoService {
    
    public Produto buscarPorId(Long idProduto) {
        ProdutoDAO dao = new ProdutoDAO();
        return dao.buscarPorId(idProduto);
    }
    
    public Produto buscarPorCodigoBarras(String codBarras) {
        ProdutoDAO dao = new ProdutoDAO();
        return dao.buscarPorCodigoBarras(codBarras);
    }
}
