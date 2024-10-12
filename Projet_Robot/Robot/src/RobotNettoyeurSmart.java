import java.util.ArrayList;

public class RobotNettoyeurSmart extends Robot {

    private ArrayList<Chemin> chemin;

    public RobotNettoyeurSmart(int x, int y) {
        super(x, y);
        chemin = new ArrayList<>(); // Initialisez l'ArrayList dans le constructeur
    }

    public void parcourir() {
        chemin.clear(); // Nettoyez l'ArrayList avant de l'utiliser
        for (int j = 0; j < this.getM().getNbl(); j++) {
            for (int i = 0; i < this.getM().getNbc(); i++) {
                if (this.getM().getMatVal(i, j)) {
                    Chemin c = new Chemin(i, j);
                    chemin.add(c); // Utilisez l'ArrayList chemin pour ajouter les chemins
                    System.out.println("Sonic i:" + i + " j:" + j);
                }
            }
        }
    }

    public ArrayList<Chemin> getChemin() {
        return chemin; // Retournez l'ArrayList chemin
    }

    public void setMat() {
        try {
            this.getM().PrendrePapier(this.getPosX(), this.getPosY());
        } catch (MettrePapierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Monde monde = new Monde();
        RobotNettoyeurSmart robot = new RobotNettoyeurSmart(0, 0);
        robot.setM(monde);
        System.out.println("Monde avant nettoyage :");
        monde.affiche();
        robot.parcourir();
        System.out.println("Monde après nettoyage :");
        monde.affiche();
    }
}
