public class Monde {
	int nbL;                 //nombre de lignes
    int nbC;                 //nombre de colonnes
    boolean Mat[][];         //Matrice boolean
	
    //Constructeur qui cree un monde
    public Monde(){
        nbL = 10;
        nbC = 10;
        Mat = new boolean[nbL][nbC];
    }
    
    //Mettre un papier gras dans la case(monde)
    
    public void MetPapier(int nL, int nC)
            throws MettrePapierException
            {
                if(nL > nbL || nC > nbC)
                    throw new MettrePapierException();
                else
                    Mat[nL][nC] = true;
            }
    
  //Prendre un papier gras dans la case(monde)
    
    public void PrendrePapier(int nL, int nC)
            throws MettrePapierException
            {
                if(nL > nbL || nC > nbC)
                    throw new MettrePapierException();
                else
                {
                    if(Mat[nL][nC] == true)
                        System.out.println(Mat[nL][nC]);
                    else
                        System.out.println("Cette case n'a pas de papier gras !!!");
                }
                    
            }
    //Tester si la case (monde) � un papier gras 
    public boolean testPapierGras(int nL, int nC)
            throws MettrePapierException
            {
                if(nL > nbL || nC > nbC)
                    throw new MettrePapierException();
                else
                {
                    if(Mat[nL][nC] == true)
                        return true;
                    else
                        return false;
                }
            }
    //Compter le nombre de papiers gras dans le monde
	public int getNumberPapierGrs()
	{
		int nbr = 0;
		for(int i = 0; i < Mat.length; i++) 
		{
			for(int j = 0; j < Mat[i].length; j++) 
			{
				if(Mat[i][j] == true)
					nbr++;
			}
		}
		return nbr; 
	}
    
	//Afficher la martice (le monde)
	public void affiche()
	{
	    for(int i=0; i < Mat.length; i++) {
	        for(int j = 0; j< Mat[i].length; j++) {
	            System.out.print(Mat[i][j] + "  ");
	        }
	        System.out.print("\n");
	    }
	}
	
	public int getNbl() {
		return nbL;
	}

	public int getNbc() {
		return nbC;
	}

	public boolean getMatVal(int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String[] args) {
		Monde monde = new Monde();
		try {
		    monde.MetPapier(2, 3); // Met un papier gras dans la case (2, 3)
		} catch (MettrePapierException e) {
		    System.out.println("Impossible de mettre le papier gras dans cette case.");
		}
		
		try {
		    monde.PrendrePapier(2, 3); // Prend un papier gras dans la case (2, 3)
		} catch (MettrePapierException e) {
		    System.out.println("Impossible de prendre le papier gras dans cette case.");
		}
		
		try {
		    boolean aPapierGras = monde.testPapierGras(2, 3); // Teste si la case (2, 3) a un papier gras
		    System.out.println("La case (2, 3) a un papier gras : " + aPapierGras);
		} catch (MettrePapierException e) {
		    System.out.println("Impossible de tester le papier gras dans cette case.");
		}
		
		int nombrePapierGras = monde.getNumberPapierGrs();
		System.out.println("Nombre de papiers gras dans le monde : " + nombrePapierGras);
		
		System.out.println("Affichage de la matrice (le monde) :");
		monde.affiche();
	}

}