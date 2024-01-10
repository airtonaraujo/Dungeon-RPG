package Services;

public class Salas {
    private String numeroDaSala;

    public Salas(String numeroDaSala) {
        this.numeroDaSala = numeroDaSala;
    }

    @Override
    public String toString() {
        return numeroDaSala;
    }
}
