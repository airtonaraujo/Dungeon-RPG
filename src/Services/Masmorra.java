package Services;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Masmorra {
    private List<Inimigo> inimigos;
    Boss boss;

    public void setBoss(Boss boss) {
        this.boss = boss;
    }

    private void gerarInimigos() {
        Random random = new Random();
        int numInimigos = random.nextInt(5) + 3;
        for (int i = 0; i < numInimigos; i++) {
            String inimigoNome = "Goblin " + (i + 1);
            int inimigoHp = 30;
            int inimigoDano = random.nextInt(10);
            inimigos.add(new Inimigo(inimigoNome, inimigoHp, inimigoDano));
        }
    }

    public void iniciarMasmorra(Personagem personagem) {
        System.out.println("Bem-vindo à dungeon, " + personagem.getNome() + "!");
        System.out.println("Prepare-se para enfrentar uma série de inimigos.");
        salaUm(personagem);
    }

    public void salaUm(Personagem personagem) {
        inimigos = new ArrayList<>();
        gerarInimigos();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Você percebe " + inimigos.size() + " inimigos à frente");
        for (int i = 0; i < inimigos.size(); ) {
            int opcao;
            do {
                System.out.println("O " + inimigos.get(i) + " está na sua frente");
                System.out.println("""
                        O que deseja fazer?
                                        
                        1- Atacar
                        2- Fugir
                        """);
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1 -> {
                        personagem.atacar(inimigos.get(i));
                        personagem.receberDano(inimigos.get(i).getDano());
                        if (inimigos.get(i).getPontosDeVida() <= 0) {
                            System.out.println("Você derrotou um inimigo");
                            i++;
                        }
                    }
                    case 2 -> personagem.fugir();
                    default -> System.out.println("Opção inválida");
                }

            } while (i < inimigos.size());
        }
        salaDois(personagem);
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