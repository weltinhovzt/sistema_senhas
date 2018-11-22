package senha.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Matheus
 */
public class ConexaoJDBC {

    //retornar conexao
    public static Connection criarConexao() {

        //registrar conexao
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //mostrar mensagem de erro
        } catch (Exception e) {
            
        }

        try {
            //gerenciar conexao
            return DriverManager.getConnection("jdbc:mysql://172.19.99.41/teste", "root", "Psw@1706");
        } catch (SQLException ex) {
            //mostrar mensagem de erro
        }
        return null;
    }
}
