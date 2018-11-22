/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senha.model;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JProgressBar;

/**
 *
 * @author GustavoSMC
 */
public class KeepDB {
    protected final Connection con;
    public static final String SEPARATOR = File.separator;
    
    public KeepDB(Connection con) throws SQLException{
        if(con != null){
            this.con = con;
        }else{
            throw new SQLException();
        }       
    }
    
    public boolean backupDB(String sqlDescription, String mysqldump, String user, String key) throws URISyntaxException, SQLException, IOException{
       String dir = getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath();  
            dir = dir.substring(1, dir.lastIndexOf('/') + 1);  
            System.out.println(dir);
            String data = LocalDate.now().toString().replace("-", "_");
            File file;
            file = new File(dir + "backup/" + data +"/");
            System.out.println(file.toString());
            if(!file.exists()) file.mkdir();           
            String milSec = String.valueOf(System.currentTimeMillis());
            String sqlName = file.toString() + "/" + sqlDescription + milSec + ".sql"; 
            System.out.println(sqlName);
            //TODO implementar independencia de Sistema Operacional 
            Process run = Runtime.getRuntime().exec("cmd " + mysqldump + " -u " + user + " -p" + key + " " + con.getCatalog() + " > " + sqlName);
            return(run != null);
    }
    
    
    
    public int truncateTables(final JProgressBar jPbar, String...tables){
       int tablesTrunc = 0;
       jPbar.setMaximum(tables.length);
       String sql = "TRUNCATE TABLE ";
       Statement stmt = null;
       if(tables.length > 0){
           for(String strTable : tables){
               try{
                  stmt = con.prepareStatement(sql + strTable + ";");
                  stmt.executeUpdate(sql + strTable + ";");
                  tablesTrunc++;
                  jPbar.setValue(tablesTrunc);
               }catch(SQLException e){
                   System.err.println("Não foi possivel truncar a tabela : " + strTable);
               }finally{
                   try {
                       if(stmt != null)  stmt.close();
                   } catch (SQLException ex) {
                       System.err.println("Statement não foi fechado!");
                   }
               }
           }
       }
       return tablesTrunc;
    }
    
    public void closeKeepCon(){
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("Não foi possivel fechar a conexão");
        }
    }
    

    
}
