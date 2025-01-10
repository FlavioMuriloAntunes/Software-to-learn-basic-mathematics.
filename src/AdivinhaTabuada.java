import javax.swing.*; // interface grafica
import java.awt.*; // componentes
import java.util.Random;

public class AdivinhaTabuada {
    private int numero1;
    private int numero2;
    private int nivel;
    private Random random = new Random();

    public void iniciar() {
        // Configuração da janela
        JFrame frame = new JFrame("Aprender tabuada");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fechar janela
        frame.setSize(400, 300); // Definir o tamanho da janela
        frame.setLocationRelativeTo(null); // Centralizar a janela
        frame.setLayout(null); // Usar layout null para controle manual dos componentes

        // Componentes da interface
        JLabel nivelLabel = new JLabel("Escolha o nivel da tabuada");
        JTextField nivelFild = new JTextField();
        JLabel perguntaLabel = new JLabel(""); // Texto para exibir a pergunta
        JTextField respostaFild = new JTextField();
        JButton confirmarButton = new JButton("Confirmar"); // Confirmar resposta

        // Definir o tamanho e a posição dos componentes manualmente
        nivelLabel.setBounds(100, 20, 200, 30); // Posição e tamanho do label
        nivelFild.setBounds(100, 50, 30, 30); // Posição e tamanho do campo de texto
        perguntaLabel.setBounds(100, 90, 200, 30); // Posição e tamanho da pergunta
        respostaFild.setBounds(100, 120, 30, 30); // Posição e tamanho do campo de resposta
        confirmarButton.setBounds(150, 200, 100, 30); // Posição e tamanho do botão

        // Adicionar os componentes ao frame
        frame.add(nivelLabel);
        frame.add(nivelFild);
        frame.add(perguntaLabel);
        frame.add(respostaFild);
        frame.add(confirmarButton);

        // estilos

        frame.getContentPane().setBackground(new Color(214, 186, 6)); // Definindo a cor azul clara
        nivelLabel.setForeground(new Color(0x330B0B));

        // Tornar a janela visível
        frame.setVisible(true);

        // logica para tabuada

        confirmarButton.addActionListener(e -> {
            try {
                nivel = Integer.parseInt(nivelFild.getText());
                if (nivel < 1 || nivel > 2) {
                    JOptionPane.showMessageDialog(frame, "Insira um nível válido:\n1 - Tabuada até 5\n2 - Tabuada até 10\n3 - Tabuada até 15");
                    return;
                }

                // escolha de niveis

                int limite = switch (nivel) {
                    case 1 -> 5;
                    case 2 -> 10;
                    default -> 0;
                };

                numero1 = random.nextInt(limite) + 1;
                numero2 = random.nextInt(limite) + 1;

                int respostaCerta = numero1 * numero2;

                perguntaLabel.setText("Quanto é " + numero1 + " x " + numero2 + "?");

                confirmarButton.setText("Responder"); // Mudar o texto do botão

                confirmarButton.addActionListener(ev -> {
                    try {
                        int resposta = Integer.parseInt(respostaFild.getText());
                        if (resposta == respostaCerta) {
                            JOptionPane.showMessageDialog(frame, "Resposta certa!");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Resposta errada. A resposta certa é: " + respostaCerta);
                        }

                        // limpar dados para a proxima jogada
                        respostaFild.setText("");
                        perguntaLabel.setText("");
                        confirmarButton.setText("Confirmar");

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Por favor, insira um número válido para a resposta.");
                    }
                });

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Por favor, insira um nível válido.");
            }
        });
    }

    public static void main(String[] args) {
        new AdivinhaTabuada().iniciar();
    }
}
