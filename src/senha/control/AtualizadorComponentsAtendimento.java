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
import senha.model.SenhaAtendimento;
import senha.model.Util;
import senha.view.tv.TelaTvAtendimento;

/**
 *
 * @author gustavosmc
 */
public class AtualizadorComponentsAtendimento {
        private static int aguardando;
        private static final int TEMPO_AGUARDANDO = 200;

    public AtualizadorComponentsAtendimento() {
       
        

    }

    public static void atualizarCompents(final JLabel comp1,
            final JLabel comp2, final JLabel...labels) {
            Thread atualizaHora = new Thread(() -> {
            List<Senha> ultimasSenhas = new ArrayList<>();
            TvAtendimentoDAO dao = new TvAtendimentoDAO();
            aguardando = TEMPO_AGUARDANDO;
            while (true) {
                SenhaAtendimento senha;
                senha = dao.selectSenhaAtendimentoNormalTV();
                if (senha != null && aguardando<0) {
                    ultimasSenhas.add(0, senha);
                    AtualizarLabels.atualizarLabelsUltimasSenhas(ultimasSenhas, labels);
                    if(ultimasSenhas.size() > 3){
                        ultimasSenhas.remove(ultimasSenhas.size() - 1);
                    }
                    
                    
                    aguardando = TEMPO_AGUARDANDO;
                    dao.updateStatusSenhaAtendimentoTV(senha);
                    comp1.setText(senha.getSigla() + Util.formatarSenha(senha.getNumeroSenha()));
                    comp2.setText(Util.formatarGuiche(senha.getGuiche()));
                    
                }else{
                    aguardando--;
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TelaTvAtendimento.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                }
            }
        });
        atualizaHora.start();
    }
}
