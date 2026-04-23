package stockmanager_;

import javax.swing.JOptionPane;
import stockmanager_.entity.Produto;
import stockmanager_db.ProdutoDAO;

public class App {
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();

        try {
            while (true) {
                String[] opcoes = {"Cadastrar", "Excluir", "Ver Estoque", "Sair"};
                int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Gerenciador de Estoque",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

                if (escolha == 0) { // Cadastrar
                    String nome = JOptionPane.showInputDialog("Nome do produto:");
                    if (nome == null) continue;
                    int qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantidade:"));
                    double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço:").replace(",", "."));
                    
                    dao.inserir(new Produto(nome, qtd, preco));
                    dao.listar();

                } else if (escolha == 1) { // Excluir
                    dao.listar(); 
                    String idStr = JOptionPane.showInputDialog("Digite o ID para excluir (veja no console):");
                    if (idStr != null) {
                        dao.deletar(Integer.parseInt(idStr));
                        dao.listar();
                    }

                } else if (escolha == 2) { // Ver Estoque
                    dao.listar();
                    JOptionPane.showMessageDialog(null, "Lista atualizada no console!");

                } else { // Sair
                    break;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }
}
