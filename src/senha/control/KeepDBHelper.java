/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senha.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import senha.model.KeepDB;

/**
 *
 * @author GustavoSMC
 */
public class KeepDBHelper extends KeepDB{

    public KeepDBHelper(Connection con) throws SQLException {
        super(con);
    }
    
  
    
    public void truncateTablesInProgress(final JProgressBar jPbar, String...tables){
        Thread thread;

        thread = new Thread(() -> {
             try {
                Thread.sleep(1000); 
                this.truncateTables(jPbar, tables);          
                Thread.sleep(1000);                
            } catch (InterruptedException ex) {
                Logger.getLogger(KeepDBHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
             this.closeKeepCon();
        });
        
        thread.start();
    }
   
}
