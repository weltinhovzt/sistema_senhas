/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senha.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import senha.model.SenhaCaixa;

/**
 *
 * @author wellingtonh3181_00
 */
public class TotemDAO {
    
    public SenhaCaixa listSenha() {
        //gravar na variavel a conexão com o banco
        Connection conexao = ConexaoJDBC.criarConexao();
        //criar o comando SQL
        String sql = "select *from senhacaixa limit 1";
        //PreparedStatement que vai passar os parametros para o meu SQL
        PreparedStatement stmt = null;
        try {
            //passa os parametros
            stmt = conexao.prepareStatement(sql);
           
            //coleta os resultados
            ResultSet rs = stmt.executeQuery();
            rs.first();
            
            //criar a lista de usuarios vazia
            SenhaCaixa senha = new SenhaCaixa();
            senha.setDataSenha(rs.getString("dataSenha"));
                  
            stmt.close();
            conexao.close();
            return senha;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(TvCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        return null;
    }
  
}
