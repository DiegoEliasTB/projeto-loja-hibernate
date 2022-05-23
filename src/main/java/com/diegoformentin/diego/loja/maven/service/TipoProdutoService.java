/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.diegoformentin.diego.loja.maven.service;

import com.diegoformentin.diego.loja.maven.model.dao.TipoProdutoDAO;
import com.diegoformentin.diego.loja.maven.model.bo.TipoProduto;

/**
 *
 * @author Diego
 */
public class TipoProdutoService {
    
    public TipoProduto buscarPorId(Long idTipoProduto) {
        TipoProdutoDAO tipoProdutoDAO = new TipoProdutoDAO();
        return tipoProdutoDAO.buscarPorId(idTipoProduto);
    }
}
