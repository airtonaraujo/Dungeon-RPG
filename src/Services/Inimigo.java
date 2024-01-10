package Services;

public class Inimigo {
    private String nome;
    private int pontosDeVida;
    private int dano;

    public Inimigo(String nome, int pontosDeVida, int dano) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.dano = dano;
    }

    public String getNome() {
        return nome;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public int getDano() {
        return dano;
    }

    @Override
    public String toString() {
        return nome;
    }
}
