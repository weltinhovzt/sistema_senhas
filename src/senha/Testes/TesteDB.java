/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senha.Testes;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import senha.control.ConexaoJDBC;
import senha.model.KeepDB;

/**
 *
 * @author GustavoSMC
 */
public class TesteDB {
    public static void main(String args[]){
        KeepDB kdb = null;
        try {
             kdb = new KeepDB(ConexaoJDBC.criarConexao());
        } catch (SQLException ex) {
            System.out.println("Erro ao estabelecer conexão");
        }
        if(kdb != null){
            String tabelas[] = new String[]{"senhaatendimento", "senhacaixa", "senhagerencia"};
           // System.out.println(kdb.truncateTables(tabelas));
            kdb.closeKeepCon();
        }
    }
}
