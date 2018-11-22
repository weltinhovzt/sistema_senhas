/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senha.control;

import senha.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author welti_000
 */
public class UsuarioDAO {

    public void inserirUsuario(Usuario usuario) {

        Connection con = ConexaoJDBC.criarConexao();

        String sql = "INSERT INTO usuario (id_usuario, nomeUsuario, senhaUsuario, setor, guiche)" + "VALUES (?, ?, ?, ?, ?) ";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, usuario.getId_usuario());
            stmt.setString(2, usuario.getNomeUsuario());
            stmt.setString(3, usuario.getSenhaUsuario());
            stmt.setString(3, usuario.getSetor());
            stmt.setInt(3, usuario.getGuiche());
            stmt.execute();
            stmt.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com Sucesso!");
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062) {
                JOptionPane.showMessageDialog(null, "Usuario ja cadastrado");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar dados!");
            }
        }

    }

    public List<Usuario> selectUsuarios() {
        //gravar na variavel a conexão com o banco
        Connection conexao = ConexaoJDBC.criarConexao();
        //criar o comando SQL
        String sql = "SELECT * FROM usuario";
        //PreparedStatement que vai passar os parametros para o meu SQL
        try {
            //passa os parametros
            PreparedStatement stmt = conexao.prepareStatement(sql);
            //coleta os resultados
            ResultSet rs = stmt.executeQuery();
            //criar a lista de usuarios vazia
            List<Usuario> data = new ArrayList<>();
            //LAÇO DE REPETIÇÃO
            while (rs.next()) {
                //ciar o objeto de usuario
                Usuario u = new Usuario();
                //popular o objeto
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNomeUsuario(rs.getString("nomeUsuario"));
                u.setSenhaUsuario(rs.getString("senhaUsuario"));
                u.setSetor(rs.getString("setor"));
                u.setGuiche(rs.getInt("guiche"));
                data.add(u);
            }
            conexao.close();
            stmt.close();
            return data;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO DE SQL: " + e);
        }
        return null;
    }

    public Usuario validarUsuarios(String nomeUsuario, String senhaUsuario) {
        //gravar na variavel a conexão com o banco
        Connection conexao = ConexaoJDBC.criarConexao();
        //criar o comando SQL
        String sql = "SELECT *FROM usuario WHERE nomeUsuario = ? AND senhaUsuario = ?";
        //PreparedStatement que vai passar os parametros para o meu SQL

        try {
            //passa os parametros
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nomeUsuario);
            stmt.setString(2, senhaUsuario);
            //coleta os resultados
            ResultSet rs = stmt.executeQuery();
            //criar a lista de usuarios vazia
            List<Usuario> data = new ArrayList<>();
            //LAÇO DE REPETIÇÃO
            while (rs.next()) {
                //ciar o objeto de usuario
                Usuario u = new Usuario();
                //popular o objeto
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNomeUsuario(rs.getString("nomeUsuario"));
                u.setSenhaUsuario(rs.getString("senhaUsuario"));
                data.add(u);
            }
            conexao.close();
            stmt.close();
            if (data.size() == 0) {
                return null;
            } else {
                return data.get(0);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO DE SQL: " + e);
        }
        return null;
    }

    public void updateUsuario(Usuario usuario) {
        //gravar na variável a conexão com o banco.
        Connection conexao = ConexaoJDBC.criarConexao();
        //Criar o comando SQL;
        String sql = "update usuario set senhaUsuario = ? where id_usuario = ?";

        //PreparedStatement que vai passar os parâmetros para o sql.
        try {

            PreparedStatement stmt = conexao.prepareStatement(sql);
            //Passar os parâmetros ao sql.
            stmt.setString(1, usuario.getSenhaUsuario());
            stmt.setInt(2, usuario.getId_usuario());
            //Executar o sql com parametros.
            stmt.execute();
            //fechar a conexão.
            stmt.close();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e);
        }
    }
}
