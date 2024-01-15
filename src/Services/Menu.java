package Services;
import java.util.ArrayList;
import java.util.Scanner;
public class Menu {
    public void iniciarSistema(Masmorra masmorra){
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
                    case 1 -> iniciarJogo(masmorra);
                    case 2 -> System.exit(0);
                    default -> System.out.println("Opção inválida");
                }

            } while(true);
        }
    public void iniciarJogo(Masmorra masmorra){
        ArrayList<Job> jobs = Job.popularListaDeJobs();
        Scanner scanner = new Scanner(System.in);
        String nomePersonagem;
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
                """);

            for (int i=0; i < jobs.size(); i++) {
                System.out.println(i + 1 + " - " + jobs.get(i));
            }
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    Personagem jogador = new Personagem(nomePersonagem, 100, 15 + jobs.get(0).getAtributoModificador(), 15,15, jobs.get(0));
                    jogador.setDano(jogador.getForca());
                    masmorra.iniciarMasmorra(jogador);
                }
                case 2 -> {
                    Personagem jogador = new Personagem(nomePersonagem, 100, 15, 15,15 + jobs.get(1).getAtributoModificador(), jobs.get(1));
                    jogador.setDano(jogador.getInteligencia());
                    masmorra.iniciarMasmorra(jogador);
                }
                case 3 -> {
                    Personagem jogador = new Personagem(nomePersonagem, 100, 15, 15 + jobs.get(2).getAtributoModificador(),15, jobs.get(2));
                    jogador.setDano(jogador.getDestreza());
                    masmorra.iniciarMasmorra(jogador);
                }
                default -> System.out.println("Opção inválida");
            }

        } while(true);
    }
}