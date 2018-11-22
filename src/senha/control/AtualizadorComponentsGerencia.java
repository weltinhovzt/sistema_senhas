/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senha.control;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import senha.model.Senha;
import senha.model.SenhaGerencia;
import senha.model.Util;
import senha.view.tv.TelaTvGerencia;

/**
 *
 * @author gustavosmc
 */
public class AtualizadorComponentsGerencia {
    private static int aguardando;
    private static final int TEMPO_AGUARDANDO = 200;
   

    public AtualizadorComponentsGerencia() {

    }

    public static void atualizarCompents(final JLabel comp1,
            final JLabel comp2, final JLabel...labels) {
        Thread atualizaHora = new Thread(() -> {
            TvGerenciaDAO dao = new TvGerenciaDAO();
            List<Senha> ultimasSenhas = new ArrayList<>();
            aguardando = TEMPO_AGUARDANDO;
            while (true) {
                SenhaGerencia senha = new SenhaGerencia();
                senha = dao.selectSenhaGerenciaNormalTV();
                if (senha != null && aguardando<0) {
                    ultimasSenhas.add(0, senha);
                    AtualizarLabels.atualizarLabelsUltimasSenhas(ultimasSenhas, labels);
                    if(ultimasSenhas.size() > 3){
                        ultimasSenhas.remove(ultimasSenhas.size() - 1);
                    }
                    aguardando = TEMPO_AGUARDANDO;
                    dao.updateStatusSenhaGerenciaTV(senha);
                    comp1.setText(senha.getSigla() + Util.formatarSenha(senha.getNumeroSenha()));
                    comp2.setText(Util.formatarGuiche(senha.getGuiche()));
                    
                }else{
                    aguardando--;
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TelaTvGerencia.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                    
                }
            }
        });
        atualizaHora.start();
    }
}
