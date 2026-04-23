package stockmanager_db;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexao {
    public static Connection conectar() throws Exception {
        Class.forName("org.postgresql.Driver");

        // Verifique se a sua senha do banco ainda é 1234 ou 123
        String url = "jdbc:postgresql://localhost:5432/banco_loja_rafael_tabbi";
        String user = "postgres";
        String password = "1234"; 

        return DriverManager.getConnection(url, user, password);
    }
}
