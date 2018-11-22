/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senha.control;

import java.util.List;
import javax.swing.JLabel;
import senha.model.Senha;
import senha.model.Util;

/**
 *
 * @author gustavosmc
 */
public class AtualizarLabels {
    
    
    public static void atualizarLabelsUltimasSenhas(List<Senha> uS, final JLabel...labels){
        int i = 0;
        for(Senha senha : uS){
            labels[i].setText(senha.getSigla() + Util.formatarSenha(senha.getNumeroSenha()));
            labels[i + 1].setText("Guichê " + Util.formatarGuiche(senha.getGuiche()));
            i+=2;
        }
    }
}
