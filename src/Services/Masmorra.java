package Services;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Masmorra {
    private List<Inimigo> inimigos;
    private List<Salas> salas;
    Boss boss;

    public Masmorra() {
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }
    private void gerarInimigos() {
        Random random = new Random();
        int numInimigos = random.nextInt(2) + 3;
        for (int i = 0; i < numInimigos; i++) {
            String inimigoNome = "Goblin " + (i + 1);
            int inimigoHp = 30;
            int inimigoDano = random.nextInt(10);
            inimigos.add(new Inimigo(inimigoNome, inimigoHp, inimigoDano));
        }
    }

    private void gerarSalas() {
        Random random = new Random();
        int numSalas = random.nextInt(1) + 2;
        for (int i = 0; i < numSalas; i++) {
            String numeroSala = "Sala " + (i+1);
            salas.add(new Salas(numeroSala));
        }
    }
    public void iniciarMasmorra(Personagem personagem) {
        System.out.println("Bem-vindo à dungeon, " + personagem.getNome() + "!");
        System.out.println("Prepare-se para enfrentar uma série de inimigos.");
        salas(personagem);
    }

    public void salas(Personagem personagem) {
        Scanner scanner = new Scanner(System.in);
        salas = new ArrayList<>();
        gerarSalas();
        for (int i = 0; i < salas.size();) {
            System.out.println("Você chegou à sala de numero " + salas.get(i));
            inimigos = new ArrayList<>();
            gerarInimigos();
            System.out.println("Você percebe " + inimigos.size() + " inimigos à frente");
            for (int y = 0; y < inimigos.size();) {
                int opcao;
                do {
                    System.out.println("O " + inimigos.get(y) + " está na sua frente");
                    System.out.println("""
                        O que deseja fazer?
                                        
                        1- Atacar
                        2- Fugir
                        """);
                    opcao = scanner.nextInt();

                    switch (opcao) {
                        case 1 -> {
                            personagem.atacar(inimigos.get(y));
                            if (inimigos.get(y).getPontosDeVida() <= 0) {
                                System.out.println("Você derrotou um inimigo");
                                y++;
                            }else {
                                personagem.receberDano(inimigos.get(y).getDano());
                            }
                        }
                        case 2 -> personagem.fugir();
                        default -> System.out.println("Opção inválida");
                    }

                } while (y < inimigos.size());
            }
            i++;
        }
        salaDoBoss(personagem);
    }

    public void salaDoBoss(Personagem personagem) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("voce chegou na proxima sala");
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
                    if (boss.getPontosDeVida() <= 0) {
                        System.out.println("Você conseguiu derrotar o chefe, aproveite seu tesouro.");
                        System.exit(0);
                    }else {
                        personagem.receberDano(boss.getDano());
                    }
                }
                case 2 -> personagem.fugir();
                default -> System.out.println("Opção inválida");
            }

        } while(boss.getPontosDeVida() > 0);
    }
}