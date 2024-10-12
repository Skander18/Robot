
public class RobotNettoyeurToutDroit extends Robot {
	
	public RobotNettoyeurToutDroit(int x, int y)
	{
		super(x,y);

	}
	
	public static void main(String[] args) {
	    // Créer une instance de Monde pour que le robot puisse y évoluer
	    Monde monde = new Monde();

	    // Créer une instance de RobotNettoyeurToutDroit
	    RobotNettoyeurToutDroit robot = new RobotNettoyeurToutDroit(0, 0);

	    // Définir le monde dans lequel le robot va évoluer
	    robot.setM(monde);

	    // Afficher la position initiale du robot
	    System.out.println("Position initiale du robot : (" + robot.getPosX() + ", " + robot.getPosY() + ")");

	    // Déplacer le robot vers une nouvelle position
	    int nouvellePosX = 3;
	    int nouvellePosY = 5;
	    try {
	        robot.deplacer(nouvellePosX, nouvellePosY);
	        System.out.println("Le robot s'est déplacé avec succès vers la position : (" + robot.getPosX() + ", " + robot.getPosY() + ")");
	    } catch (MettrePapierException e) {
	        System.out.println("Erreur lors du déplacement du robot : " + e.getMessage());
	    }
	}


}
