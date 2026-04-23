package stockmanager_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import stockmanager_.entity.Produto;

public class ProdutoDAO {

    public void inserir(Produto produto) throws Exception {
        String sql = "INSERT INTO produto (nome_produto, quantidade, preco) VALUES (?, ?, ?)";
        Connection conn = conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, produto.getNome());
        stmt.setInt(2, produto.getQuantidade());
        stmt.setDouble(3, produto.getPreco());
        stmt.execute();
        conn.close();
    }

    public void deletar(int id) throws Exception {
        String sql = "DELETE FROM produto WHERE id_produto = ?";
        Connection conn = conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        
        int linhas = stmt.executeUpdate();
        if (linhas > 0) {
            JOptionPane.showMessageDialog(null, "Item " + id + " removido!");
        } else {
            JOptionPane.showMessageDialog(null, "ID não encontrado!");
        }
        conn.close();
    }

    public void listar() throws Exception {
        String sql = "SELECT * FROM produto ORDER BY id_produto ASC";
        Connection conn = conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        System.out.println("\n--- ESTOQUE ATUAL ---");
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id_produto") + 
                               " | Nome: " + rs.getString("nome_produto") + 
                               " | Qtd: " + rs.getInt("quantidade") + 
                               " | Preço: R$ " + rs.getDouble("preco"));
        }
        conn.close();
    }
}
