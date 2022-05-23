/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.diegoformentin.diego.loja.maven.service;

import com.diegoformentin.diego.loja.maven.model.dao.CaracteristicaProdutoDAO;
import com.diegoformentin.diego.loja.maven.model.bo.CaracteristicaProduto;

/**
 *
 * @author Diego
 */
public class CaracteristicaProdutoService {
    public CaracteristicaProduto buscarPorId(Long idCaracteristicaProduto) {
        CaracteristicaProdutoDAO dao = new CaracteristicaProdutoDAO();
        return dao.buscarPorId(idCaracteristicaProduto);
    }
}
