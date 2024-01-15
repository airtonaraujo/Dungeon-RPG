package Services;

public class Job {
    private String nomeJob;
    private String armaBase;
    private int atributoModificador;

    public Job(String nomeJob, String armaBase, int atributoModificador) {
        this.nomeJob = nomeJob;
        this.armaBase = armaBase;
        this.atributoModificador = atributoModificador;
    }

    public String getNomeJob() {
        return nomeJob;
    }

    public String getArmaBase() {
        return armaBase;
    }

    public int getAtributoModificador() {
        return atributoModificador;
    }

    @Override
    public String toString() {
        return "Classe: " + nomeJob + " - " + "Arma: " +  armaBase + "\n";
    }
}