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
        JFrame frame = new JFrame("Aprender tabuada");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fechar janela
        frame.setSize(400, 300); // Definir o tamanho da janela
        frame.setLocationRelativeTo(null); // Centralizar a janela
        frame.setLayout(null); // Usar layout null para controle manual dos componentes






        // Componentes da interface
        JLabel nivelLabel = new JLabel("Escolha o nível"); // texto para instruir o usuário sobre os níveis
        JTextField nivelFild = new JTextField(); // campo de texto para o usuário inserir o nível
        JLabel perguntaLabel = new JLabel(""); // texto para exibir a pergunta
        JTextField respostaField = new JTextField(); // campo para a resposta
        JButton confirmarButton = new JButton("Confirmar"); // botão para confirmar a resposta

        nivelLabel.setBounds(100, 20, 200, 30); // Posição e tamanho do label
        nivelFild.setBounds(100, 50, 150, 30); // Posição e tamanho do campo de texto
        perguntaLabel.setBounds(100, 90, 200, 30); // Posição e tamanho da pergunta
        respostaField.setBounds(100, 120, 150, 30); // Posição e tamanho do campo de resposta
        confirmarButton.setBounds(150, 200, 100, 30); // Posição e tamanho do botão


        // Adiciona os componentes na interface
        frame.add(nivelLabel);
        frame.add(nivelFild);
        frame.add(perguntaLabel);
        frame.add(respostaField);
        frame.add(confirmarButton);



        // estilos

        frame.getContentPane().setBackground(new Color(214, 186, 6)); // Definindo a cor azul clara
        nivelLabel.setForeground(new Color(0x330B0B));

        // Torna a janela visível
        frame.setVisible(true);

        // Lógica do jogo
        confirmarButton.addActionListener(e -> {
            try {
                // Obtém o nível inserido pelo usuário
                nivel = Integer.parseInt(nivelFild.getText()); // para usuario colocar o nivel
                if (nivel < 1 || nivel > 3) {
                    JOptionPane.showMessageDialog(frame, "Por favor, escolha um nível entre 1 e 3."); // caixa de menssagem para dialogo
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Por favor, insira um número válido para o nível.");
                return;
            }

            // Define o nível e gera a primeira pergunta
            gerarPergunta();

            // Exibe a primeira pergunta
            perguntaLabel.setText("Quanto é " + numero1 + " + " + numero2 + "?");

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
                    perguntaLabel.setText("Quanto é " + numero1 + " + " + numero2 + "?");
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
