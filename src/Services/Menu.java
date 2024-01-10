package Services;

import java.util.Scanner;
public class Menu {
    public void iniciarSistema(){
        Scanner scanner = new Scanner(System.in);
            int opcao;
            do{
                System.out.println("""
                Bem-vindo(a) ao Dungeons & Só
                
                1- Iniciar Jogo
                2- Sair
                """);
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1 -> iniciarJogo();
                    case 2 -> System.exit(0);
                    default -> System.out.println("Opção inválida");
                }

            } while(true);
        }
    public void iniciarJogo(){
        Scanner scanner = new Scanner(System.in);
        String nomePersonagem;
        Job job;
            System.out.println("""
                Todo início de jornada começa com um protagonista.
                                    
                Digite o nome do seu personagem: 
                    """);
        nomePersonagem = scanner.nextLine();

        int opcao;
        do{
            System.out.println("""
                Agora vamos decidir a classe do nosso herói
                
                Você pode escolher dentre as seguintes classes:
                
                1- Guerreiro
                """);
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    job = new Job("Guerreiro", "Espada");
                    Personagem jogador = new Personagem(nomePersonagem, 100, 15, 15,15, job);
                    Masmorra masmorra = new Masmorra();
                    masmorra.iniciarMasmorra(jogador);
                }
                default -> System.out.println("Opção inválida");
            }

        } while(true);
    }
}