
public abstract class Robot{
    int posx;
    int posy;
    Monde m;
    
    
    public Robot(int x, int y) 
    {
        posx = x;
        posy = y;
        //m = m1;
    }
    public Robot(Monde m1) throws MettrePapierException{
        posx = (int)(Math.random()*10);
        posy = (int)(Math.random()*10);
        m = m1;
    }
    public void deplacer(int x, int y)
        throws MettrePapierException
        {
            if(x > m.nbL || y > m.nbC )
                throw new MettrePapierException();
            else
            {
                posx = x;
                posy = y;
                m.MetPapier(posx, posy); // On se d�place de la position posx et posy, et on rajoute un papier gras
            }
        }
    //public abstract void parcourir() throws MettrePapierException;
    
    public void affiche(){
    	for(int i=0; i<m.nbL; i++){
    		for(int j=0; j<m.nbC; j++)
    			System.out.print(m.Mat[i][j] + " ");
    				System.out.print("\n");
    	}
    		
    			
    }
    
    public Monde getM() {
		return this.m;
	}
    
    public int getPosX() {
		return this.posx;
	}

	public int getPosY() {
		return this.posy;
	}
    
	public void setPosx(int posx, int MAX) {
		if(posx >= 0 && posx < MAX)
			this.posx = posx;
	}

	public void setPosy(int posy, int MAX) {
		if(posy >= 0 && posy < MAX)
			this.posy = posy;
	}

	public void setM(Monde m) {
		this.m = m;
	}

	public class Chemin {
		private int i;
		private int j;
		
		public Chemin() {}
		public Chemin (int i, int j){
			this.i = i;
			this.j = j;
		}
		
		public void setI(int i) { this.i = i; }
		public void setJ(int j) { this.j = j; }
		public int getI() { return this.i; }
		public int getJ() { return this.j; }
		
	}
	
	public static void main(String[] args) {
	    Monde monde = new Monde();
	    System.out.println("Test de la classe Monde uniquement...");
	    monde.affiche();
	}


}
