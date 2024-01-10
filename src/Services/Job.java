package Services;

public class Job {
    private String nomeJob;
    private String armaBase;

    public Job(String nomeJob, String armaBase) {
        this.nomeJob = nomeJob;
        this.armaBase = armaBase;
    }

    public String getNomeJob() {
        return nomeJob;
    }

    public String getArmaBase() {
        return armaBase;
    }
}