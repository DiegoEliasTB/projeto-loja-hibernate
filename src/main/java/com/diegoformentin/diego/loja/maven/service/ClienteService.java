package com.diegoformentin.diego.loja.maven.service;

import com.diegoformentin.diego.loja.maven.service.InterfaceService;
import java.util.List;
import com.diegoformentin.diego.loja.maven.model.dao.ClienteDAO;
import com.diegoformentin.diego.loja.maven.model.bo.Cliente;

public class ClienteService implements InterfaceService<Cliente> {

    @Override
    public void salvar(Cliente objeto) {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.create(objeto);
    }
    
    public int buscaTotal() {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.buscaTotal();
    }

    @Override
    public List<Cliente> buscar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Cliente buscar(int codigo) {
        ClienteDAO dao = new ClienteDAO();
        return dao.retrieve(codigo);
    }

    @Override
    public Cliente buscar(String descricao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void atualizar(Cliente objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void apagar(Cliente objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
