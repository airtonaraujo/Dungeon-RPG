package Services;
import java.util.ArrayList;
public class Job {
    private String nomeJob;
    private String armaBase;
    private int atributoModificador;

    public static ArrayList<Job> popularListaDeJobs() {
        ArrayList<Job> jobs;
        jobs = new ArrayList<>();
        jobs.add(new Job("Guerreiro", "Espada", 10));
        jobs.add(new Job("Mago", "Cajado", 10));
        jobs.add(new Job("Ladino", "Adaga", 10));
        return jobs;
    }
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