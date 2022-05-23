package com.diegoformentin.diego.loja.maven.service;

import com.diegoformentin.diego.loja.maven.service.InterfaceService;
import java.util.List;
import com.diegoformentin.diego.loja.maven.model.dao.EnderecoDAO;
import com.diegoformentin.diego.loja.maven.model.bo.Endereco;

public class EnderecoService implements InterfaceService<Endereco> {

    @Override
    public void salvar(Endereco endereco) {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.create(endereco);
    }

    @Override
    public List<Endereco> buscar() {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        return enderecoDAO.retrieve();
    }

    @Override
    public Endereco buscar(int codigo) {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        return enderecoDAO.retrieve(codigo);
    }

    @Override
    public Endereco buscar(String descricao) {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        return enderecoDAO.retrieve(descricao);
    }

    @Override
    public void atualizar(Endereco objeto) {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.update(objeto);
    }

    @Override
    public void apagar(Endereco objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    
    
}
