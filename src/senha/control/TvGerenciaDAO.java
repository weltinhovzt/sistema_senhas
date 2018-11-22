/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senha.control;

import senha.model.SenhaGerencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import senha.model.StatusSenha;

/**
 *
 * @author welti_000
 */
public class TvGerenciaDAO {

   
    
    public SenhaGerencia selectSenhaGerenciaNormalTV() {
        //gravar na variavel a conexão com o banco
        Connection conexao = ConexaoJDBC.criarConexao();
        //criar o comando SQL
        String sql = "SELECT id_senhaGerencia, numeroSenha, guiche, sigla, setor FROM senhagerencia where statusSenha = 'CHAMADO' order by numeroSenha asc";
        //PreparedStatement que vai passar os parametros para o meu SQL
        PreparedStatement stmt = null;
        try {
            //passa os parametros
            stmt = conexao.prepareStatement(sql);
           
            //coleta os resultados
            ResultSet rs = stmt.executeQuery();
            rs.first();
            //criar a lista de usuarios vazia
            SenhaGerencia senha = new SenhaGerencia();
            senha.setId_senhaGerencia(rs.getInt("id_senhaGerencia"));
            senha.setNumeroSenha(rs.getInt("numeroSenha"));
            senha.setGuiche(rs.getInt("guiche"));
            senha.setSigla(rs.getString("sigla"));
            senha.setSetor(rs.getString("setor"));
            stmt.close();
            conexao.close();
            return senha;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(TvGerenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return null;
    }

    public void updateStatusSenhaGerenciaTV(SenhaGerencia senhaGerencia) {

        Connection conexao = ConexaoJDBC.criarConexao();
        String sql = "UPDATE senhagerencia SET statusSenha = ? WHERE id_senhaGerencia = ?";
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, StatusSenha.EMATENDIMENTO);
            stmt.setInt(2, senhaGerencia.getId_senhaGerencia());
            stmt.execute();
           

        } catch (Exception e) {
            e.printStackTrace();

        }finally{
            try {
                stmt.close();
                 conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(TvGerenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
               
            return;
        }
        
    }
    
   
}
