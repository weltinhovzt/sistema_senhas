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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import senha.model.StatusSenha;

/**
 *
 * @author welti_000
 */
public class SenhaGerenciaDAO {
    
    public void inserirSenhaGerencia(SenhaGerencia senhaGerencia) {

        Connection con = ConexaoJDBC.criarConexao();

        String sql = "INSERT INTO senhagerencia (numeroSenha, setor, tipoAtendimento, sigla, dataSenha, horaSenha, statusSenha)" + "VALUES (?, ?, ?, ?, ?, ?, ?) ";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, senhaGerencia.getNumeroSenha());
            stmt.setString(2, senhaGerencia.getSetor());
            stmt.setString(3, senhaGerencia.getTipoAtendimento());
            stmt.setString(4, senhaGerencia.getSigla());
            stmt.setString(5, senhaGerencia.getDataSenha());
            stmt.setString(6, senhaGerencia.getHoraSenha());
            stmt.setString(7, senhaGerencia.getStatusSenha());
            
            stmt.execute();
            stmt.close();
            con.close();
            System.out.println("Senha retirada com Sucesso!");
        } catch (SQLException ex) {
            try {
                con.close();
            } catch (SQLException ex1) {
                Logger.getLogger(SenhaGerenciaDAO.class.getName()).log(Level.SEVERE, null, ex1);
           
            }
            System.out.println("Não foi possivel cadastrar dados!");
        }
    }
    
    public List<SenhaGerencia> selectSenhaGerenciaNormal() {
        //gravar na variavel a conexão com o banco
        Connection conexao = ConexaoJDBC.criarConexao();
        //criar o comando SQL
        String sql = "SELECT numeroSenha FROM senhagerencia where tipoAtendimento = 'CONVENCIONAL' order by numeroSenha asc";
        //PreparedStatement que vai passar os parametros para o meu SQL
        try {
            //passa os parametros
            PreparedStatement stmt = conexao.prepareStatement(sql);
            //coleta os resultados
            ResultSet rs = stmt.executeQuery();
            //criar a lista de usuarios vazia
            List<SenhaGerencia> data = new ArrayList<>();
            //LAÇO DE REPETIÇÃO
            while (rs.next()) {
                //ciar o objeto de usuario
                SenhaGerencia senha = new SenhaGerencia();
                //popular o objeto
                senha.setNumeroSenha(rs.getInt("numeroSenha"));
                data.add(senha);
            }
            conexao.close();
            stmt.close();
            return data;
        } catch (SQLException e) {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(SenhaGerenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            JOptionPane.showMessageDialog(null, "ERRO DE SQL: " + e);
        }
        return null;
    }
    
    public List<SenhaGerencia> selectSenhaGerenciaPreferencial() {
        //gravar na variavel a conexão com o banco
        Connection conexao = ConexaoJDBC.criarConexao();
        //criar o comando SQL
        String sql = "SELECT numeroSenha FROM senhagerencia where tipoAtendimento = 'PREFERENCIAL' order by numeroSenha asc";
        //PreparedStatement que vai passar os parametros para o meu SQL
        try {
            //passa os parametros
            PreparedStatement stmt = conexao.prepareStatement(sql);
            //coleta os resultados
            ResultSet rs = stmt.executeQuery();
            //criar a lista de usuarios vazia
            List<SenhaGerencia> data = new ArrayList<>();
            //LAÇO DE REPETIÇÃO
            while (rs.next()) {
                //ciar o objeto de usuario
                SenhaGerencia senha = new SenhaGerencia();
                //popular o objeto
                senha.setNumeroSenha(rs.getInt("numeroSenha"));
                data.add(senha);
            }
            conexao.close();
            stmt.close();
            return data;
        } catch (SQLException e) {
            try {
                conexao.close();
            } catch (SQLException ex) {
               return null;
            }
            JOptionPane.showMessageDialog(null, "ERRO DE SQL: " + e);
        }
        return null;
    }
    
    public SenhaGerencia menorSenhaGerenciaNormal() {
        //gravar na variavel a conexão com o banco
        Connection conexao = ConexaoJDBC.criarConexao();
        //criar o comando SQL
        String sql = "SELECT id_senhaGerencia, numeroSenha FROM senhagerencia where tipoAtendimento = 'CONVENCIONAL' AND statusSenha = 'AGUARDANDO' order by numeroSenha asc";
        //PreparedStatement que vai passar os parametros para o meu SQL
        try {
            //passa os parametros
            PreparedStatement stmt = conexao.prepareStatement(sql);
            //coleta os resultados
            ResultSet rs = stmt.executeQuery();
            //LAÇO DE REPETIÇÃO
            rs.first();

            //ciar o objeto de usuario
            SenhaGerencia senha = new SenhaGerencia();
            //popular o objeto
            senha.setNumeroSenha(rs.getInt("numeroSenha"));
            senha.setId_senhaGerencia(rs.getInt("id_senhaGerencia"));
            conexao.close();
            stmt.close();
            return senha;
        } catch (SQLException e) {
            try {
                conexao.close();
            } catch (SQLException ex) {
                return null;
            }
            return null;
        }
    }

    public SenhaGerencia menorSenhaGerenciaPreferencial() {
        //gravar na variavel a conexão com o banco
        Connection conexao = ConexaoJDBC.criarConexao();
        //criar o comando SQL
        String sql = "SELECT id_senhaGerencia, numeroSenha FROM senhagerencia where tipoAtendimento = 'PREFERENCIAL' AND statusSenha = 'AGUARDANDO' order by numeroSenha asc";
        //PreparedStatement que vai passar os parametros para o meu SQL
        try {
            //passa os parametros
            PreparedStatement stmt = conexao.prepareStatement(sql);
            //coleta os resultados
            ResultSet rs = stmt.executeQuery();
            //LAÇO DE REPETIÇÃO
            rs.first();

            //ciar o objeto de usuario
            SenhaGerencia senha = new SenhaGerencia();
            //popular o objeto
            senha.setNumeroSenha(rs.getInt("numeroSenha"));
            senha.setId_senhaGerencia(rs.getInt("id_senhaGerencia"));
            conexao.close();
            stmt.close();
            return senha;
        } catch (SQLException e) {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(SenhaGerenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            return null;
        }

    }

    public void updateStatusSenhaGerencia(SenhaGerencia senhaGerencia) {

        Connection conexao = ConexaoJDBC.criarConexao();
        String sql = "UPDATE senhagerencia SET statusSenha = ?, guiche = ? WHERE id_senhaGerencia = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, StatusSenha.CHAMADO);
            stmt.setInt(2, senhaGerencia.getGuiche());
            stmt.setInt(3, senhaGerencia.getId_senhaGerencia());
            stmt.execute();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(SenhaGerenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "ERRO DE SQL: " + e);
        }
    }
    
     public void truncate(){
        //gravar na variavel a conexão com o banco
        Connection conexao = ConexaoJDBC.criarConexao();
        //criar o comando SQL
        String sql = "truncate senhagerencia";

        //PreparedStatement que vai passar os parametros para o meu SQL
        PreparedStatement stmt = null;
        try {
            //passa os parametros
            stmt = conexao.prepareStatement(sql);
            stmt.executeUpdate();
   
            stmt.close();
            conexao.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(TvCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
     
    }
    
}
