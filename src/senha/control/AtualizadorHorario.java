/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senha.control;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author welti_000
 */
public class AtualizadorHorario {

    public String dataSistema() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static void horaSistema(final JLabel jLHora) {
        Thread atualizaHora;
        atualizaHora = new Thread(() -> {
            try {
                while (true) {
                    Date date = new Date();
                    StringBuilder data = new StringBuilder();
                    
                    SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss"); // Para Atualizar a DATA so mudar para o formato dd/MM/yyyy
                    jLHora.setText(data.toString() + formatoHora.format(date));
                    Thread.sleep(1000);
                    jLHora.revalidate();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        atualizaHora.start();
    }

    public String horaAtualSistema() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date hora = new Date();
        return dateFormat.format(hora);
    }
}
