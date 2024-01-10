package Services;
import Services.Menu;
import java.util.Scanner;

public class Personagem{
    private String nome;
    private int pontosDeVida;
    private int forca;
    private int destreza;
    private int inteligencia;
    private Job job;

    public Personagem(String nome, int pontosDeVida, int forca, int destreza, int inteligencia, Job job) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.job = job;
    }

    public String getNome() {
        return nome;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public int getForca() {
        return forca;
    }

    public int getDestreza() {
        return destreza;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public Job getJob() {
        return job;
    }

    public void atacar(Inimigo inimigo){
        inimigo.setPontosDeVida(inimigo.getPontosDeVida() - getForca());
        System.out.println(nome + " ataca " + inimigo.getNome() + " com " + job.getArmaBase() + " e causa " + getForca() + " pontos de dano.");
        System.out.println("Vida do " + inimigo + " restante: " + inimigo.getPontosDeVida());

    }

    public void receberDano(int dano){
        Scanner scanner = new Scanner(System.in);
        pontosDeVida -= dano;
        if(pontosDeVida <= 0) {
            System.out.println(nome + " foi derrotado!");
            System.exit(0);
        }else {
            System.out.println(nome + " recebeu " + dano + " pontos de dano. Vida restante: " + pontosDeVida);
        }
    }
    public void fugir(){
        System.out.println(nome + " foge da batalha!");
        System.exit(0);
    }
}