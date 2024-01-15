import Services.Boss;
import Services.Masmorra;
import Services.Menu;
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.criarJobs();
        Boss boss = new Boss("Glob", 200, 15);
        Masmorra masmorra = new Masmorra();
        masmorra.setBoss(boss);
        menu.iniciarSistema(masmorra);
    }
}