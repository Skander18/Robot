
public class RobotPollueurToutDroit extends Robot {
	
	public RobotPollueurToutDroit(int x, int y)
	{
		super(x,y);

	}
	
	public void parcourir() {
	    for (int i = 0; i < 10; i++) {
	        try {
	            // Vérifier si la prochaine position est valide avant de déplacer le robot
	            int nextPosX = getPosX() + 1;
	            int nextPosY = getPosY();
	            if (nextPosX < m.getNbc()) { // Vérifier les limites en X
	                deplacer(nextPosX, nextPosY); // Déplacer le robot vers l'avant (vers la droite)
	                System.out.println("Position du robot : (" + getPosX() + ", " + getPosY() + ")");
	            } else {
	                System.out.println("Le robot est arrivé à la fin du monde.");
	                break; // Sortir de la boucle si le robot atteint la fin du monde
	            }
	        } catch (MettrePapierException e) {
	            System.out.println("Erreur lors du déplacement : " + e.getMessage());
	        }
	    }
	}


	
    public static void main(String[] args) {
        // Créer une instance de Monde pour que le robot puisse y évoluer
        Monde monde = new Monde();
        
        // Créer une instance de RobotPollueurToutDroit
        RobotPollueurToutDroit robot = new RobotPollueurToutDroit(0, 0);
        
        // Définir le monde dans lequel le robot va évoluer
        robot.setM(monde);
        
        // Afficher la position initiale du robot
        System.out.println("Position initiale du robot : (" + robot.getPosX() + ", " + robot.getPosY() + ")");
        
        // Faire parcourir au robot son parcours tout droit
        robot.parcourir();
        
        // Afficher la position finale du robot
        System.out.println("Position finale du robot : (" + robot.getPosX() + ", " + robot.getPosY() + ")");
    }

}
