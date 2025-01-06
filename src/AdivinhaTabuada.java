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
        JLabel perguntaLabel  = new JLabel(""); // Texto para exibir a pergunta
        JTextField respostaFild = new JTextField();
        JButton confirmarButton = new JButton("Confirmar"); // Confirmar resposta

        // Definir o tamanho e a posição dos componentes manualmente
        nivelLabel.setBounds(100, 20, 200, 30); // Posição e tamanho do label
        nivelFild.setBounds(100, 50, 150, 30); // Posição e tamanho do campo de texto
        perguntaLabel.setBounds(100, 90, 200, 30); // Posição e tamanho da pergunta
        respostaFild.setBounds(100, 120, 150, 30); // Posição e tamanho do campo de resposta
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







    }

    public static void main(String[] args) {
        new AdivinhaTabuada().iniciar();
    }
}
