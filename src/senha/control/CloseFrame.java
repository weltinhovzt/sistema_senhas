/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senha.control;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import senha.view.tv.TelaTvCaixa;

/**
 *
 * @author welti_000
 */
public class CloseFrame {

    public static void closerFrame(final JFrame frame, double seconds) {
        Thread threadCloser = new Thread(new Runnable() {
            int miliSeconds = (int) Math.round(seconds * 1000);

            @Override
            public void run() {
                try {
                    Thread.sleep(miliSeconds);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TelaTvCaixa.class.getName()).log(Level.SEVERE, null, ex);

                }
                frame.dispose();
            }

        });
        threadCloser.start();

    }
}
