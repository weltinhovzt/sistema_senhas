/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senha.control;

import senha.model.SenhaCaixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author welti_000
 */
public class SenhaCaixaDAO {

    public void inserirSenhaCaixa(SenhaCaixa senhaCaixa) {

        Connection con = ConexaoJDBC.criarConexao();

        String sql = "INSERT INTO senhacaixa (numeroSenha, setor, tipoAtendimento, sigla, dataSenha, horaSenha, statusSenha)" + "VALUES (?, ?, ?, ?, ?, ?, ?) ";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, senhaCaixa.getNumeroSenha());
            stmt.setString(2, senhaCaixa.getSetor());
            stmt.setString(3, senhaCaixa.getTipoAtendimento());
            stmt.setString(4, senhaCaixa.getSigla());
            stmt.setString(5, senhaCaixa.getDataSenha());
            stmt.setString(6, senhaCaixa.getHoraSenha());
            stmt.setString(7, senhaCaixa.getStatusSenha());

            stmt.execute();
            stmt.close();
            con.close();
            System.out.println("Senha retirada com Sucesso!");
        } catch (SQLException ex) {
            try {
                con.close();
            } catch (SQLException ex1) {
                Logger.getLogger(SenhaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            System.out.println("Não foi possivel cadastrar dados!");
        }
    }

    public List<SenhaCaixa> selectSenhaCaixaNormal() {
        //gravar na variavel a conexão com o banco
        Connection conexao = ConexaoJDBC.criarConexao();
        //criar o comando SQL
        String sql = "SELECT numeroSenha FROM senhacaixa where tipoAtendimento = 'CONVENCIONAL' order by numeroSenha asc";
        //PreparedStatement que vai passar os parametros para o meu SQL
        try {
            //passa os parametros
            PreparedStatement stmt = conexao.prepareStatement(sql);
            //coleta os resultados
            ResultSet rs = stmt.executeQuery();
            //criar a lista de usuarios vazia
            List<SenhaCaixa> data = new ArrayList<>();
            //LAÇO DE REPETIÇÃO
            while (rs.next()) {
                //ciar o objeto de usuario
                SenhaCaixa senha = new SenhaCaixa();
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
                Logger.getLogger(SenhaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "ERRO DE SQL: " + e);
        }
        return null;
    }

    public List<SenhaCaixa> selectSenhaCaixaPreferencial() {
        //gravar na variavel a conexão com o banco
        Connection conexao = ConexaoJDBC.criarConexao();
        //criar o comando SQL
        String sql = "SELECT numeroSenha FROM senhacaixa where tipoAtendimento = 'PREFERENCIAL' order by numeroSenha asc";
        //PreparedStatement que vai passar os parametros para o meu SQL
        try {
            //passa os parametros
            PreparedStatement stmt = conexao.prepareStatement(sql);
            //coleta os resultados
            ResultSet rs = stmt.executeQuery();
            //criar a lista de usuarios vazia
            List<SenhaCaixa> data = new ArrayList<>();
            //LAÇO DE REPETIÇÃO
            while (rs.next()) {
                //ciar o objeto de usuario
                SenhaCaixa senha = new SenhaCaixa();
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
                Logger.getLogger(SenhaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "ERRO DE SQL: " + e);
        }
        return null;
    }

    public SenhaCaixa menorSenhaCaixaNormal() {
        //gravar na variavel a conexão com o banco
        Connection conexao = ConexaoJDBC.criarConexao();
        //criar o comando SQL
        String sql = "SELECT id_senhaCaixa, numeroSenha FROM senhacaixa where tipoAtendimento = 'CONVENCIONAL' AND statusSenha = 'AGUARDANDO' order by numeroSenha asc";
        //PreparedStatement que vai passar os parametros para o meu SQL
        try {
            //passa os parametros
            PreparedStatement stmt = conexao.prepareStatement(sql);
            //coleta os resultados
            ResultSet rs = stmt.executeQuery();
            //LAÇO DE REPETIÇÃO
            rs.first();

            //ciar o objeto de usuario
            SenhaCaixa senha = new SenhaCaixa();
            //popular o objeto
            senha.setNumeroSenha(rs.getInt("numeroSenha"));
            senha.setId_senhaCaixa(rs.getInt("id_senhaCaixa"));
            conexao.close();
             stmt.close();
            return senha;
        } catch (SQLException e) {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(SenhaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }

    public SenhaCaixa menorSenhaCaixaPreferencial() {
        //gravar na variavel a conexão com o banco
        Connection conexao = ConexaoJDBC.criarConexao();
        //criar o comando SQL
        String sql = "SELECT id_senhaCaixa, numeroSenha FROM senhacaixa where tipoAtendimento = 'PREFERENCIAL' AND statusSenha = 'AGUARDANDO' order by numeroSenha asc";
        //PreparedStatement que vai passar os parametros para o meu SQL
        try {
            //passa os parametros
            PreparedStatement stmt = conexao.prepareStatement(sql);
            //coleta os resultados
            ResultSet rs = stmt.executeQuery();
            //LAÇO DE REPETIÇÃO
            rs.first();

            //ciar o objeto de usuario
            SenhaCaixa senha = new SenhaCaixa();
            //popular o objeto
            senha.setNumeroSenha(rs.getInt("numeroSenha"));
            senha.setId_senhaCaixa(rs.getInt("id_senhaCaixa"));
            conexao.close();
            stmt.close();
            return senha;
        } catch (SQLException e) {
            return null;
        }

    }

    public void updateStatusSenhaCaixa(SenhaCaixa senhaCaixa) {

        Connection conexao = ConexaoJDBC.criarConexao();
        String sql = "UPDATE senhacaixa SET statusSenha = ?, guiche = ? WHERE id_senhaCaixa = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, senhaCaixa.getStatusSenha());
            stmt.setInt(2, senhaCaixa.getGuiche());
            stmt.setInt(3, senhaCaixa.getId_senhaCaixa());
            stmt.execute();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(SenhaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "ERRO DE SQL: " + e);
        }
    }
    
    public void truncate(){
        //gravar na variavel a conexão com o banco
        Connection conexao = ConexaoJDBC.criarConexao();
        //criar o comando SQL
        String sql = "truncate senhacaixa";

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
