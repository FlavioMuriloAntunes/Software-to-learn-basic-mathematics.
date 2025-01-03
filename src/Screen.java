import javax.swing.*; // Importa a biblioteca Swing para criar componentes gráficos como botões e janelas.
import java.awt.*; // Importa a biblioteca AWT para trabalhar com gráficos e layouts.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; // Importa a interface ActionListener, usada para escutar ações de um botão.

public class Screen { // Define a classe Screen, que é responsável pela interface gráfica.

    public Screen() { // Construtor da classe Screen, que será chamado quando criarmos uma instância dela.
        JFrame jFrame = new JFrame(); // Cria uma janela principal (JFrame).
        jFrame.setVisible(true); // Torna a janela visível ao usuário.
        jFrame.setSize(400, 400); // Define o tamanho da janela (400px de largura por 400px de altura).
        jFrame.setTitle("JOGO DA TABUADA"); // Define o título da janela.
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa quando a janela for fechada.
        jFrame.setResizable(false); // Impede que o usuário redimensione a janela.
        jFrame.setLocationRelativeTo(null); // Centraliza a janela na tela.
        jFrame.setLayout(null); // Define o layout da janela como nulo, permitindo o posicionamento manual dos componentes.

        // Cria os botões que serão adicionados à janela.
        JButton botao2 = new JButton("Adicao"); // Botão para iniciar a funcionalidade de "Adição".
        JButton botao = new JButton("Tabuada"); // Botão para iniciar a funcionalidade de "Tabuada".

        // Adiciona os botões à janela para que sejam exibidos.
        jFrame.add(botao2);
        jFrame.add(botao);

        // Define a posição e o tamanho dos botões.
        botao.setBounds(150, 100, 100, 30); // Define a posição (x=150, y=100) e o tamanho (largura=100, altura=30).
        botao2.setBounds(150, 200, 100, 30); // Define a posição (x=150, y=200) e o tamanho (largura=100, altura=30).

        // Adiciona um listener ao botão "Tabuada" para executar uma ação quando ele for clicado.
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // Define a ação a ser executada ao clicar no botão.
                iniciar(); // Chama o método iniciar() para começar a funcionalidade de "Tabuada".
            }
        });

        // Adiciona um listener ao botão "Adicao" para executar uma ação quando ele for clicado.
        botao2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // Define a ação a ser executada ao clicar no botão.
                iniciarAdicao(); // Chama o método iniciarAdicao() para começar a funcionalidade de "Adicao".
            }
        });
    }

    // Método que inicia a funcionalidade de "Adicao".
    public static void iniciarAdicao() {
        AdivinhaAdicao adivinhaAdicao = new AdivinhaAdicao(); // Cria uma instância da classe AdivinhaAdicao.
        adivinhaAdicao.iniciarAdicao(); // Chama o método iniciarAdicao() da classe AdivinhaAdicao.
    }

    // Método que inicia a funcionalidade de "Tabuada".
    public static void iniciar() {
        AdivinhaTabuada adivinhaTabuada = new AdivinhaTabuada(); // Cria uma instância da classe AdivinhaTabuada.
        adivinhaTabuada.iniciar(); // Chama o método iniciar() da classe AdivinhaTabuada.
    }

    // Método principal, ponto de entrada do programa.
    public static void main(String[] args) {
        new Screen(); // Cria uma instância da classe Screen, que inicializa a interface gráfica.
    }
}

