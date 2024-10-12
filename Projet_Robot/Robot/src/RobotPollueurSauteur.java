
import java.util.ArrayList;

public class RobotPollueurSauteur extends Robot {
	private ArrayList<Chemin> chemin;

	public RobotPollueurSauteur(int x, int y) {
		super(x,y);
		chemin = new ArrayList<>(); 
	}

//				

	
	public void parcourir() {
		// TODO Auto-generated method stub
		chemin.clear();
		this.setChemin(new ArrayList<Chemin>());
		
		int startX=this.getPosX(), endX, pasX;
		int startY=this.getPosY(), endY, pasY;
		
		if(startX==this.getM().getNbc()-1) {
			endX = -1;
			pasX = -1;
		}
		else {
			endX = this.getM().getNbc();
			pasX = 1;
		}
		
		
		if(startY==this.getM().getNbl()-1) {
			endY = -1;
			pasY = -1;
		}
		else {
			endY = this.getM().getNbl();
			pasY = 1;		
		}
		for(int j=startY; j!=endY; j+=pasY) {
			for(int i=startX; i!=endX; i+=pasX) {
				if(probabilite_pourcent_true(30)){
					Chemin c = new Chemin(i,j);
					this.getChemin().add(c);
					//System.out.println("i:"+i+" j:"+j);
				}
			}
			pasX = pasX * (-1);
			if(pasX==-1) {
				startX=this.getM().getNbc()-1;
				endX=-1;
			}
			else {
				startX=0;
				endX=this.getM().getNbc();
			}
		}
		chemin.add(new Chemin(0, 0));
	}
	
	private ArrayList<Chemin> getChemin() {
		// TODO Auto-generated method stub
		return chemin;
	}

	private void setChemin(ArrayList<Chemin> arrayList) {
		// TODO Auto-generated method stub
		
	}

	private boolean probabilite_pourcent_true(int n) {
		if((int)(Math.random()*100)<n)
			return true;
		else
			return false;
	}


	public void setMat() {
		try {
			this.getM().PrendrePapier(this.getPosX(), this.getPosY());
		} catch (MettrePapierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public static void main(String[] args) {
        Monde monde = new Monde();
        RobotPollueurSauteur robot = new RobotPollueurSauteur(0, 0);
        robot.setM(monde);

        // Afficher la position initiale du robot
        System.out.println("Position initiale du robot : (" + robot.getPosX() + ", " + robot.getPosY() + ")");

        // Faire parcourir au robot son parcours de saut
        robot.parcourir();

        // Afficher le chemin parcouru par le robot
        System.out.println("Chemin parcouru par le robot :");
        ArrayList<Robot.Chemin> chemin = robot.getChemin();
        for (Robot.Chemin c : chemin) {
            System.out.println("Position : (" + c.getI() + ", " + c.getJ() + ")");
        }
    }


}
