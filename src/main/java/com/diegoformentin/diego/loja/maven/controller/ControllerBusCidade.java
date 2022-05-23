package com.diegoformentin.diego.loja.maven.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import com.diegoformentin.diego.loja.maven.model.bo.Cidade;
import com.diegoformentin.diego.loja.maven.service.CidadeService;
import com.diegoformentin.diego.loja.maven.view.TelaBusCidade;
public class ControllerBusCidade implements ActionListener{
    
    TelaBusCidade telaBusCidade;

    public ControllerBusCidade(TelaBusCidade telaBusCidade) {
        
        this.telaBusCidade = telaBusCidade;
        
        telaBusCidade.getjButtonCarregar().addActionListener(this);
        telaBusCidade.getjButtonSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.telaBusCidade.getjTable1().getModel();
        
        CidadeService cidadeService = new CidadeService();        
        for (Cidade cidadeAtualDaLista : cidadeService.buscar()) {
            tabela.addRow(new Object[]{ cidadeAtualDaLista.getIdCidade(), 
                                        cidadeAtualDaLista.getDescricaoCidade(),
                                        cidadeAtualDaLista.getUfCidade() });
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaBusCidade.getjButtonCarregar()){
         ControllerCadCidade.codigo = 
         (int)this.telaBusCidade.getjTable1().getValueAt(this.telaBusCidade.getjTable1().getSelectedRow(), 0);
         this.telaBusCidade.dispose();
        }else if(e.getSource() == this.telaBusCidade.getjButtonSair()){
            this.telaBusCidade.dispose();
        }
    }
}