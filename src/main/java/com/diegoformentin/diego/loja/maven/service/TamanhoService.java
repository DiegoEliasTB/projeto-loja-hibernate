/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.diegoformentin.diego.loja.maven.service;

import com.diegoformentin.diego.loja.maven.model.dao.TamanhoDAO;
import com.diegoformentin.diego.loja.maven.model.bo.Tamanho;

/**
 *
 * @author Diego
 */
public class TamanhoService {
    
    public Tamanho buscarPorId(Long idTamanho) {
        TamanhoDAO tamanhoDAO = new TamanhoDAO();
        return tamanhoDAO.buscarPorId(idTamanho);
    }
}
