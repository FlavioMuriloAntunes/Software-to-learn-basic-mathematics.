import java.util.Scanner; // para leitura de dados do teclado
import java.util.Random; // para gerar números aleatórios

public class AdivinhaAdicao {
    public void iniciarAdicao() {
        Scanner scanner = new Scanner(System.in); // para ler os dados
        Random random = new Random(); // gerar os números

        System.out.print("Escolha o nivel ");
        System.out.print("1- iniciante");

        int nivel;
        do {
            nivel = scanner.nextInt();
        } while (nivel < 1 || nivel > 3);

        int MaxNumero = nivel == 1 ? 5 : (nivel == 2 ? 10 : 20); // estrutura condicional

        System.out.print("Vamos começar Digite -1 para parar");

        while (true) {
            int numero1 = random.nextInt(MaxNumero); // Agora funciona, porque MaxNumero >= 1
            int numero2 = random.nextInt(MaxNumero);

            int respostaCorreta = numero1 + numero2;

            System.out.printf("Quanto é %d + %d ?", numero1, numero2);

            int respostaUsuario = scanner.nextInt();

            if (respostaUsuario == -1) {
                System.out.print("Sair");
                break;
            }

            if (respostaUsuario == respostaCorreta) {
                System.out.print("Resposta correta");
            } else {
                System.out.print("Resposta errada");
                System.out.printf(" A resposta correta de %d + %d é: %d", numero1, numero2, respostaCorreta);
            }
        }
        new Screen();
    }
}
