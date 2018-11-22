/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senha.control;

import java.util.logging.Level;
import java.util.logging.Logger;
import senha.model.Bool;

/**
 *
 * @author gustavosmc
 */
public class TimeBool {
    
    public static void notBooleanInTime(final Bool bool, float seconds){
        Thread threadNot = new Thread(new Runnable() {
            int milSeconds = Math.round(seconds * 1000);
            @Override
            public void run() {
                try {
                    Thread.sleep(milSeconds);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TimeBool.class.getName()).log(Level.SEVERE, null, ex);
                }
                bool.notBool();
            }
        });
        threadNot.start();
    }
}
