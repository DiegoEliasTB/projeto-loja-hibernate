package com.diegoformentin.diego.loja.maven.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import com.diegoformentin.diego.loja.maven.model.bo.Bairro;
import com.diegoformentin.diego.loja.maven.model.bo.Cor;
import com.diegoformentin.diego.loja.maven.service.BairroService;
import com.diegoformentin.diego.loja.maven.service.CorService;
import com.diegoformentin.diego.loja.maven.view.TelaBusBairro;
import com.diegoformentin.diego.loja.maven.view.TelaBusCor;
import com.diegoformentin.diego.loja.maven.view.TelaCadBairro;
import com.diegoformentin.diego.loja.maven.view.TelaCadCor;

public class ControllerCadCor implements ActionListener {
    
    TelaCadCor form;
    public static int codigo;
    
    public ControllerCadCor(TelaCadCor telaCadCor) {
        this.form = telaCadCor;

        form.getjButtonBuscar().addActionListener(this);
        form.getjButtonNovo().addActionListener(this);
        form.getjButtonCancelar().addActionListener(this);
        form.getjButtonGravar().addActionListener(this);
        form.getjButtonSair().addActionListener(this);

        ativa(true);
        ligaDesliga(false);

    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == form.getjButtonNovo()) {
            ativa(false);
            ligaDesliga(true);
            this.form.getjTFIdCor().setEnabled(false);
        } else if (acao.getSource() == form.getjButtonCancelar()) {
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == form.getjButtonGravar()) {
            
            //montar um objeto do tipo bairro
            Cor cor = new Cor();
            cor.setDescricao(this.form.getjTFNomeCor().getText());
            
            
            //acionar o service do bairro passando o objeto como parametro
            CorService service = new CorService();

            if (this.form.getjTFIdCor().getText().trim().equalsIgnoreCase("")) {
                service.salvar(cor);
            } else {
                cor.setIdCor(Integer.valueOf(this.form.getjTFIdCor().getText()));
                service.atualizar(cor);
            }
            //Setar o estado do formulário
            ativa(true);
            ligaDesliga(false);
        } else if (acao.getSource() == form.getjButtonBuscar()) {
            codigo = 0;
            //chamada da tela da busca
            TelaBusCor telaBusCor = new TelaBusCor(null, true);
            ControllerBusCor controllerBusCor = new ControllerBusCor(telaBusCor);
            telaBusCor.setVisible(true);

            //codigo = 4;
            if (codigo != 0) {
                
                System.out.println("How uaooo");
                Cor cor;
                CorService service = new CorService();
                cor = service.buscar(codigo);

                ativa(false);
                ligaDesliga(true);

                this.form.getjTFIdCor().setText(cor.getIdCor() + "");
                this.form.getjTFNomeCor().setText(cor.getDescricao());

                this.form.getjTFIdCor().setEnabled(false);
            }
            
        } else if (acao.getSource() == form.getjButtonSair()) {
            this.form.dispose();
        }
    }
    
    //Método para habilitar/desabilitar botões(controle de estados)
    public void ativa(boolean estado) {
        form.getjButtonNovo().setEnabled(estado);
        form.getjButtonCancelar().setEnabled(!estado);
        form.getjButtonGravar().setEnabled(!estado);
        form.getjButtonBuscar().setEnabled(estado);
        form.getjButtonSair().setEnabled(estado);
    }

    //Método para Ativação/Desativação/Limpeza ds 
    //Componentes do jPanelDados
    public void ligaDesliga(boolean estado) {
        Component[] componentes = this.form.getjPanelDados().getComponents();
        for (Component componenteAtual : componentes) {
            if (componenteAtual instanceof JTextField) {
                ((JTextField) componenteAtual).setText("");
                componenteAtual.setEnabled(estado);
            } else if (componenteAtual instanceof JFormattedTextField) {
                ((JFormattedTextField) componenteAtual).setText("");
                componenteAtual.setEnabled(estado);
            } else if (componenteAtual instanceof JComboBox) {
                ((JComboBox) componenteAtual).setSelectedIndex(0);
                componenteAtual.setEnabled(estado);
            }
        }
    }
    
}
