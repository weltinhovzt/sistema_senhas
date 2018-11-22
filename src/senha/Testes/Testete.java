/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senha.Testes;


import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import senha.control.ConexaoJDBC;
import senha.model.KeepDB;
import senha.model.FrameModelo;

/**
 *
 * @author gustavosmc
 */
public class Testete {
    public static void main(String...args) throws SQLException, URISyntaxException, IOException{
       KeepDB kdb = new KeepDB(ConexaoJDBC.criarConexao());
       kdb.backupDB("tabelas", "mysqldump", "root", "123");
       kdb.closeKeepCon();
       
    }
}
