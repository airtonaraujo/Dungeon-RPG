package Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Masmorra {
    private List<Inimigo> inimigos;
    private Inimigo boss;

    public Masmorra() {
        inimigos = new ArrayList<>();
        gerarInimigos();
        gerarBoss();
    }

    private void gerarInimigos() {
        Random random = new Random();
        int numInimigos = 1;
        for (int i = 0; i < numInimigos; i++) {
            String inimigoNome = "Goblin " + (i + 1);
            int inimigoHp = 30;
            int inimigoDano = random.nextInt(10);
            inimigos.add(new Inimigo(inimigoNome, inimigoHp, inimigoDano));
        }
    }

    private void gerarBoss() {
        boss = new Inimigo("Goblin Chefe", 60, 10);
    }

    public void iniciarMasmorra(Personagem personagem) {
        System.out.println("Bem-vindo à dungeon, " + personagem.getNome() + "!");
        System.out.println("Prepare-se para enfrentar uma série de inimigos.");

        salaUm(personagem);
    }

    public void salaUm(Personagem personagem) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Você percebe um inimigo à frente");
        int opcao;
        do{
            System.out.println("""
                O que deseja fazer?
                
                1- Atacar
                2- Fugir
                """);
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    personagem.atacar(inimigos.get(0));
                    personagem.receberDano(inimigos.get(0).getDano());
                    if (inimigos.get(0).getPontosDeVida() <= 0) {
                        salaDois(personagem);
                    }
                }
                case 2 -> personagem.fugir();
                default -> System.out.println("Opção inválida");
            }

        } while(inimigos.get(0).getPontosDeVida() > 0);
    }

    public void salaDois(Personagem personagem) {
        System.out.println("voce chegou na proxima sala");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Você percebe que o chefe da masmorra está logo a sua frente");
        int opcao;
        do{
            System.out.println("""
                O que deseja fazer?
                
                1- Atacar
                2- Fugir
                """);
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    personagem.atacar(boss);
                    personagem.receberDano(boss.getDano());
                    if (boss.getPontosDeVida() <= 0) {
                        System.out.println("Você conseguiu derrotar o chefe, aproveite seu tesouro.");
                        System.exit(0);
                    }
                }
                case 2 -> personagem.fugir();
                default -> System.out.println("Opção inválida");
            }

        } while(boss.getPontosDeVida() > 0);
    }
}