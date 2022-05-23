package com.diegoformentin.diego.loja.maven.service;

import com.diegoformentin.diego.loja.maven.service.InterfaceService;
import java.util.List;
import com.diegoformentin.diego.loja.maven.model.dao.CidadeDAO;
import com.diegoformentin.diego.loja.maven.model.bo.Cidade;

public class CidadeService implements InterfaceService<Cidade> {

    
    @Override
    public  void salvar(Cidade objeto) {
        CidadeDAO.getInstance().create(objeto);
    }

    @Override
    public List<Cidade> buscar() {
        return CidadeDAO.getInstance().retrieve();
    }
    
//    @Override
//    public  void salvar(Cidade objeto) {
//        CidadeDAO cidadeDAO = new CidadeDAO();
//        cidadeDAO.create(objeto);
//    }

//    @Override
//    public List<Cidade> buscar() {
//        CidadeDAO cidadeDAO = new CidadeDAO();
//        return cidadeDAO.retrieve();
//    }

    @Override
    public Cidade buscar(int codigo) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.retrieve(codigo);
    }

    @Override
    public Cidade buscar(String descricao) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.retrieve(descricao);
    }

    @Override
    public void atualizar(Cidade objeto) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.update(objeto);
    }

    @Override
    public void apagar(Cidade objeto) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.delete(objeto);
    }

}
