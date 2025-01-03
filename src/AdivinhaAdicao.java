import javax.swing.*; // para criar interface gráfica
import java.awt.*; // para layouts e componentes
import java.util.Random; // para gerar números aleatórios

public class AdivinhaAdicao {
    private int numero1;
    private int numero2;
    private int nivel;
    private Random random = new Random(); // Gerar números

    public void iniciarAdicao() {
        // Configuração da janela
        JFrame frame = new JFrame("Aprender adição");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // fechar janela
        frame.setSize(400, 300); // definir o tamanho da janela
        frame.setLayout(new GridLayout(5, 1)); // layout de 5 linhas e 1 coluna
        frame.setLocationRelativeTo(null);

        // Componentes da interface
        JLabel nivelLabel = new JLabel("Escolha o nível"); // texto para instruir o usuário sobre os níveis
        JTextField nivelFild = new JTextField(); // campo de texto para o usuário inserir o nível
        JLabel perguntaLababel = new JLabel(""); // texto para exibir a pergunta
        JTextField respostaField = new JTextField(); // campo para a resposta
        JButton confirmarButton = new JButton("Confirmar"); // botão para confirmar a resposta

        // Adiciona os componentes na interface
        frame.add(nivelLabel);
        frame.add(nivelFild);
        frame.add(perguntaLababel);
        frame.add(respostaField);
        frame.add(confirmarButton);

        // Torna a janela visível
        frame.setVisible(true);

        // Lógica do jogo
        confirmarButton.addActionListener(e -> {
            try {
                // Obtém o nível inserido pelo usuário
                nivel = Integer.parseInt(nivelFild.getText());
                if (nivel < 1 || nivel > 3) {
                    JOptionPane.showMessageDialog(frame, "Por favor, escolha um nível entre 1 e 3.");
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Por favor, insira um número válido para o nível.");
                return;
            }

            // Define o nível e gera a primeira pergunta
            gerarPergunta();

            // Exibe a primeira pergunta
            perguntaLababel.setText("Quanto é " + numero1 + " + " + numero2 + "?");

            // Adiciona a lógica para validar a resposta
            confirmarButton.addActionListener(ev -> {
                try {
                    int respostaUsuario = Integer.parseInt(respostaField.getText());
                    if (respostaUsuario == numero1 + numero2) {
                        JOptionPane.showMessageDialog(frame, "Resposta correta!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Resposta errada! O correto é " + (numero1 + numero2) + ".");
                    }

                    // Gerar nova pergunta
                    gerarPergunta();
                    perguntaLababel.setText("Quanto é " + numero1 + " + " + numero2 + "?");
                    respostaField.setText(""); // limpa o campo de resposta
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira um número válido.");
                }
            });
        });
    }

    // Método para gerar os números da pergunta
    private void gerarPergunta() {
        int maxNumero = nivel == 1 ? 5 : (nivel == 2 ? 10 : 20); // define o intervalo dos números
        numero1 = random.nextInt(maxNumero + 1); // gerar números de 0 até maxNumero
        numero2 = random.nextInt(maxNumero + 1);
    }

    public static void main(String[] args) {
        new AdivinhaAdicao().iniciarAdicao();
    }
}
