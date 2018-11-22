/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senha.Testes;

import java.sql.Connection;
import senha.control.ConexaoJDBC;

/**
 *
 * @author gustavosmc
 */
public class TesteConexao {
    public static void main(String...args){
        Connection con = ConexaoJDBC.criarConexao();
        if(con == null){
            System.out.println("Não foi possivel conectar ao banco!");
        }else{
            System.out.println("Conexão com o banco bem sucedida!");
        }
        
    }
}
