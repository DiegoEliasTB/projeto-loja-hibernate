package com.diegoformentin.diego.loja.maven.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import com.diegoformentin.diego.loja.maven.model.bo.Bairro;
import com.diegoformentin.diego.loja.maven.model.bo.Cor;
import com.diegoformentin.diego.loja.maven.service.BairroService;
import com.diegoformentin.diego.loja.maven.service.CorService;
import com.diegoformentin.diego.loja.maven.view.TelaBusBairro;
import com.diegoformentin.diego.loja.maven.view.TelaBusCor;

public class ControllerBusCor implements ActionListener {

    TelaBusCor form;
    
    public ControllerBusCor(TelaBusCor tela) {
        this.form = tela;
        
        form.getjButtonCarregar().addActionListener(this);
        form.getjButtonSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.form.getjTable1().getModel();
        
        CorService service = new CorService();        
        for (Cor it : service.buscar()) {
            tabela.addRow(new Object[]
            { it.getIdCor(), 
              it.getDescricao()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("hmmmmmmm: " + (int)this.form.getjTable1().getValueAt(this.form.getjTable1().getSelectedRow(), 0));
        if(e.getSource() == this.form.getjButtonCarregar()){
         ControllerCadCor.codigo =
         (int)this.form.getjTable1().getValueAt(this.form.getjTable1().getSelectedRow(), 0);
         this.form.dispose();
        }else if(e.getSource() == this.form.getjButtonSair()){
            this.form.dispose();
        }
    }
    
}
