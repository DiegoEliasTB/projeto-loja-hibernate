/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.diegoformentin.diego.loja.maven.service;

import com.diegoformentin.diego.loja.maven.model.dao.VendedorDAO;
import com.diegoformentin.diego.loja.maven.model.bo.Vendedor;

/**
 *
 * @author Diego
 */
public class VendedorService {
    public Vendedor buscarPorId(Long idVendedor) {
        VendedorDAO dao = new VendedorDAO();
        return dao.buscarPorId(idVendedor);
    }
}
