package com.diegoformentin.diego.loja.maven.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import com.diegoformentin.diego.loja.maven.model.bo.Endereco;
import com.diegoformentin.diego.loja.maven.service.EnderecoService;
import com.diegoformentin.diego.loja.maven.view.TelaBusEndereco;

public class ControllerBusEndereco implements ActionListener {

    TelaBusEndereco telaBusEndereco;
    
    public ControllerBusEndereco(TelaBusEndereco telaBusEndereco) {
        this.telaBusEndereco = telaBusEndereco;
        
        telaBusEndereco.getjButtonCarregar().addActionListener(this);
        telaBusEndereco.getjButtonSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.telaBusEndereco.getjTable1().getModel();
        
        EnderecoService enderecoService = new EnderecoService();        
        for (Endereco dado : enderecoService.buscar()) {
            tabela.addRow(new Object[]{ 
                dado.getIdCep(),
                dado.getCepCep(),
                dado.getLogradouroCep(),
                dado.getCidade().getDescricaoCidade(),
                dado.getBairro().getDescricaoBairro()
            });
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaBusEndereco.getjButtonCarregar()){
         ControllerCadEndereco.codigo = 
         (int)this.telaBusEndereco.getjTable1().getValueAt(this.telaBusEndereco.getjTable1().getSelectedRow(), 0);
         this.telaBusEndereco.dispose();
        }else if(e.getSource() == this.telaBusEndereco.getjButtonSair()){
            this.telaBusEndereco.dispose();
        }
    }
    
}
