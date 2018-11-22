/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senha.control;

import senha.model.SenhaAtendimento;
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
public class SenhaAtendimentoDAO {

    public void inserirSenhaAtendimento(SenhaAtendimento senhaAtendimento) {

        Connection con = ConexaoJDBC.criarConexao();

        String sql = "INSERT INTO senhaatendimento (numeroSenha, setor, tipoAtendimento, sigla, dataSenha, horaSenha, statusSenha)" + "VALUES (?, ?, ?, ?, ?, ?, ?) ";

        try {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, senhaAtendimento.getNumeroSenha());
                stmt.setString(2, senhaAtendimento.getSetor());
                stmt.setString(3, senhaAtendimento.getTipoAtendimento());
                stmt.setString(4, senhaAtendimento.getSigla());
                stmt.setString(5, senhaAtendimento.getDataSenha());
                stmt.setString(6, senhaAtendimento.getHoraSenha());
                stmt.setString(7, senhaAtendimento.getStatusSenha());
                stmt.execute();
            }
            System.out.println("Senha retirada com Sucesso!");
        } catch (SQLException ex) {

            System.out.println("Não foi possivel cadastrar dados!");
        }
    }
    
    public List<SenhaAtendimento> selectSenhaAtendimentoNormal() {
        //gravar na variavel a conexão com o banco
        Connection conexao = ConexaoJDBC.criarConexao();
        //criar o comando SQL
        String sql = "SELECT numeroSenha FROM senhaatendimento where tipoAtendimento = 'CONVENCIONAL' order by numeroSenha asc";
        //PreparedStatement que vai passar os parametros para o meu SQL
        try {
            List<SenhaAtendimento> data;
            //coleta os resultados
            try ( //passa os parametros
                    PreparedStatement stmt = conexao.prepareStatement(sql)) {
                //coleta os resultados
                ResultSet rs = stmt.executeQuery();
                //criar a lista de usuarios vazia
                data = new ArrayList<>();
                //LAÇO DE REPETIÇÃO
                rs.first();
                while (rs.next()) {
                    //ciar o objeto de usuario
                    SenhaAtendimento senha = new SenhaAtendimento();
                    //popular o objeto
                    senha.setNumeroSenha(rs.getInt("numeroSenha"));
                    data.add(senha);
            }   conexao.close();
            }
            return data;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO DE SQL: " + e);
        }
        return null;
    }
    
    public List<SenhaAtendimento> selectSenhaAtendimentoPreferencial() {
        //gravar na variavel a conexão com o banco
        Connection conexao = ConexaoJDBC.criarConexao();
        //criar o comando SQL
        String sql = "SELECT numeroSenha FROM senhaatendimento where tipoAtendimento = 'PREFERENCIAL' order by numeroSenha asc";
        //PreparedStatement que vai passar os parametros para o meu SQL
        try {
            List<SenhaAtendimento> data;
            //coleta os resultados
            try ( //passa os parametros
                    PreparedStatement stmt = conexao.prepareStatement(sql)) {
                //coleta os resultados
                ResultSet rs = stmt.executeQuery();
                //criar a lista de usuarios vazia
                data = new ArrayList<>();
                //LAÇO DE REPETIÇÃO
                rs.first();
                while (rs.next()) {
                    //ciar o objeto de usuario
                    SenhaAtendimento senha = new SenhaAtendimento();
                    //popular o objeto
                    senha.setNumeroSenha(rs.getInt("numeroSenha"));
                    data.add(senha);
            }   conexao.close();
            }
            return data;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO DE SQL: " + e);
        }
        return null;
    }
    
    public SenhaAtendimento menorSenhaAtendimentoNormal() {
        //gravar na variavel a conexão com o banco
        Connection conexao = ConexaoJDBC.criarConexao();
        //criar o comando SQL
        String sql = "SELECT id_senhaAtendimento, numeroSenha FROM senhaatendimento where tipoAtendimento = 'CONVENCIONAL' AND statusSenha = 'AGUARDANDO' order by numeroSenha asc";
        //PreparedStatement que vai passar os parametros para o meu SQL
        try {
            SenhaAtendimento senha;
            //coleta os resultados
            try ( //passa os parametros
                    PreparedStatement stmt = conexao.prepareStatement(sql)) {
                //coleta os resultados
                ResultSet rs = stmt.executeQuery();
                //LAÇO DE REPETIÇÃO
                rs.first();
                //ciar o objeto de usuario
                senha = new SenhaAtendimento();
                //popular o objeto
                senha.setNumeroSenha(rs.getInt("numeroSenha"));
                senha.setId_senhaAtendimento(rs.getInt("id_senhaAtendimento"));
                conexao.close();
            }
            return senha;
        } catch (SQLException e) {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(SenhaAtendimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }

    public SenhaAtendimento menorSenhaAtendimentoPreferencial() {
        //gravar na variavel a conexão com o banco
        Connection conexao = ConexaoJDBC.criarConexao();
        //criar o comando SQL
        String sql = "SELECT id_senhaAtendimento, numeroSenha FROM senhaatendimento where tipoAtendimento = 'PREFERENCIAL' AND statusSenha = 'AGUARDANDO' order by numeroSenha asc";
        //PreparedStatement que vai passar os parametros para o meu SQL
        try {
            //passa os parametros
            PreparedStatement stmt = conexao.prepareStatement(sql);
            //coleta os resultados
            ResultSet rs = stmt.executeQuery();
            //LAÇO DE REPETIÇÃO
            rs.first();

            //ciar o objeto de usuario
            SenhaAtendimento senha = new SenhaAtendimento();
            //popular o objeto
            senha.setNumeroSenha(rs.getInt("numeroSenha"));
            senha.setId_senhaAtendimento(rs.getInt("id_senhaAtendimento"));
            conexao.close();
            stmt.close();
            return senha;
        } catch (SQLException e) {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(SenhaAtendimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return null;
        }

    }

    public void updateStatusSenhaAtendimento(SenhaAtendimento senhaAtendimento) {

        Connection conexao = ConexaoJDBC.criarConexao();
        String sql = "UPDATE senhaatendimento SET statusSenha = ?, guiche = ? WHERE id_senhaAtendimento = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, StatusSenha.CHAMADO);
            stmt.setInt(2, senhaAtendimento.getGuiche());
            stmt.setInt(3, senhaAtendimento.getId_senhaAtendimento());
            stmt.execute();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO DE SQL: " + e);
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(SenhaAtendimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
     public void truncate(){
        //gravar na variavel a conexão com o banco
        Connection conexao = ConexaoJDBC.criarConexao();
        //criar o comando SQL
        String sql = "truncate senhaatendimento";

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
