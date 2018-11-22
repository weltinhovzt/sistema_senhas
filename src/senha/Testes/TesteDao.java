/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senha.Testes;

import java.io.IOException;
import java.sql.ClientInfoStatus;
import java.sql.Connection;
import java.sql.SQLException;
import senha.control.ConexaoJDBC;
import senha.control.SenhaAtendimentoDAO;
import senha.control.SenhaGerenciaDAO;
import senha.model.SenhaAtendimento;
import senha.model.SenhaGerencia;

/**
 *
 * @author gustavosmc
 */
public class TesteDao {
    public static void main(String...args) throws SQLException, IOException{
        
       Connection con = ConexaoJDBC.criarConexao();
        System.out.println("Nome banco : " + con.getCatalog());
        System.out.println(con.getMetaData().getURL());
        System.out.println(con.getMetaData().getDatabaseProductName());
        System.out.println(con.getMetaData().getTypeInfo());
        con.close();
    }
}
