
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Fenetre extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel nbrPapierGras = new JLabel();
	private Monde m;
	JLabel matriceLabel[][];
	  
	JButton Nettoyer = new JButton("Nettoyer");
	JButton Polluer = new JButton("Pollueur Droit");
	JButton Reinitialiser = new JButton("RAZ");
	JButton Quitter = new JButton("Quitter");
	//Ajouter un laber
	  
	JButton PolluerDroit = new JButton("POLLUER droit");
	JButton PolluerSauteurs = new JButton("POLLUER Sauteurs");
	JButton RobotsLibres = new JButton("ROBOTS LIBRES");
	JButton QuitterG = new JButton("Quitter");
	
	JButton RobotsDroit = new JButton("ROBOTS DROITS");
	JButton NettoyerD = new JButton("Nettoyer");
	JButton SmartRoboticCleaner = new JButton("Smart Robotic Cleaner");
	JButton QuitterD = new JButton("Quitter");
	
	//*************************************************** Bouton fleche ******************************************************
	

	JButton HautP = new JButton();
	JButton BasP = new JButton();
	JButton GaucheP = new JButton();
	JButton DroitP = new JButton();
		
	JButton HautN = new JButton();
	JButton BasN = new JButton();
	JButton GaucheN = new JButton();
	JButton DroitN = new JButton();

	JLabel ArrowP = new JLabel();
	JLabel ArrowN = new JLabel();
	
	//***************************************************** Bouton Panel **************************************************


    JPanel Menubis = new JPanel();
    
    JPanel Menu = new JPanel();
   
    
    JPanel Pollueur = new JPanel();

    JPanel Nettoyeur = new JPanel();

    JPanel Matrice = new JPanel();
    
    
    //*********************************************************************Les robots******************************************************
    
    Robot PollueurToutDroit = new RobotPollueurToutDroit(0,0);
    Robot NettoyeurToutDroit = new RobotNettoyeurToutDroit(0,0);
    Robot RobotSauteur = new RobotPollueurSauteur(0,0);
    Robot RobotSmart = new RobotNettoyeurSmart(0,0);
    
    
    //***********************************************************************************************************************************

    public Fenetre(){
        //On initialise la JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setSize(900, 500);
    		
        //On initialise l'horloge
         this.m = new Monde();
        
        //blueORANGE 
         Menu.setBackground(Color.green);
         Pollueur.setBackground(Color.pink);
         Nettoyeur.setBackground(Color.yellow);
         Menubis.setBackground(Color.green);
         Matrice.setBackground(Color.lightGray);
         
         PolluerDroit.setBackground(Color.pink);
         PolluerSauteurs.setBackground(Color.pink);
         RobotsLibres.setBackground(Color.pink);
         QuitterG.setBackground(Color.pink);
         
         
         RobotsDroit.setBackground(Color.yellow);
         NettoyerD.setBackground(Color.yellow);
         SmartRoboticCleaner.setBackground(Color.yellow);
         QuitterD.setBackground(Color.yellow);

         

    		
        //On initialise le JLabel
        Font police = new Font("DS-digital", Font.CENTER_BASELINE, 22);
        this.nbrPapierGras.setFont(police);
        this.nbrPapierGras.setHorizontalAlignment(JLabel.CENTER);
        this.nbrPapierGras.setText("Nombre de papiers gras : ");
        //On ajoute le JLabel � la JFrame
        
        
        
        

        

        
        this.Menubis.setLayout(new GridLayout(1, 4));
        this.Menubis.add(Nettoyer);
        this.Menubis.add(Polluer);
        this.Menubis.add(Reinitialiser);
        this.Menubis.add(Quitter);
        
        //On ajoute l'�couteur � notre composant
        
        
        this.Menu.setLayout(new GridLayout(2, 1));
        this.Menu.add(Menubis, BorderLayout.NORTH);
        this.Menu.add(nbrPapierGras, BorderLayout.SOUTH);
        
        this.Pollueur.setLayout(new GridLayout(5, 1));
        this.Pollueur.add(PolluerDroit);
        this.Pollueur.add(PolluerSauteurs);
        
        this.ArrowP.setLayout(new BorderLayout());
        ArrowP.add(HautP, BorderLayout.NORTH);
        ArrowP.add(BasP, BorderLayout.SOUTH);
        ArrowP.add(GaucheP, BorderLayout.WEST);
        ArrowP.add(DroitP, BorderLayout.EAST);
        
        this.Pollueur.add(ArrowP);
        this.Pollueur.add(RobotsLibres);
        this.Pollueur.add(QuitterG);
        
        this.Nettoyeur.setLayout(new GridLayout(5, 1));
        this.Nettoyeur.add(RobotsDroit);
        this.Nettoyeur.add(NettoyerD);
        
        this.ArrowN.setLayout(new BorderLayout());
        ArrowN.add(HautN, BorderLayout.NORTH);
        ArrowN.add(BasN, BorderLayout.SOUTH);
        ArrowN.add(GaucheN, BorderLayout.WEST);
        ArrowN.add(DroitN, BorderLayout.EAST);
        
        this.Nettoyeur.add(ArrowN);
        this.Nettoyeur.add(SmartRoboticCleaner);
        this.Nettoyeur.add(QuitterD);
        
        // *********************************La matrice ***********************************************
        
        this.Matrice.setLayout(new GridLayout(10, 10));
        this.matriceLabel = new JLabel[10][10];
        
        for (int i = 0; i < m.Mat.length; i++)
        {
            for (int j = 0; j < m.Mat[i].length; j++ )
            {
            	JLabel box = new JLabel();
            	box.setOpaque(true);
            	box.setBackground(Color.CYAN);
    			box.setBorder(BorderFactory.createLineBorder(Color.BLUE));
    			this.matriceLabel[i][j] = box;
            	this.Matrice.add(box);
            }
        }
        

        // Ajout de chaque JPanel 
        
        this.getContentPane().add(this.Menu, BorderLayout.NORTH);		
        this.getContentPane().add(this.Pollueur, BorderLayout.WEST);	
        this.getContentPane().add(this.Nettoyeur, BorderLayout.EAST);		
        this.getContentPane().add(this.Matrice, BorderLayout.CENTER);		

        this.setTitle("Monde des ROBOTS");
        
        
    	try {
    	    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
    	        if ("Metal".equals(info.getName())) {
    	            UIManager.setLookAndFeel(info.getClassName());
    	            break;
    	        }
    	    }
    	} catch (Exception e) {
    	    // If Nimbus is not available, you can set the GUI to another look and feel.
    	}
    	
    	   UIManager.LookAndFeelInfo[] info = UIManager.getInstalledLookAndFeels(); 
    	   for(int i=0; i<info.length;i++){ 
    	      System.out.println(info[i].getName() + " : " + info[i].getClassName());
    	   } 
    	   
    	   
        try {
    		Image haut = ImageIO.read(getClass().getResource("/images/haut.png"));
    		Image bas = ImageIO.read(getClass().getResource("/images/bas.png"));
    		Image droit = ImageIO.read(getClass().getResource("/images/droit.png"));
    		Image gauche = ImageIO.read(getClass().getResource("/images/gauche.png"));

    		HautP.setIcon(new ImageIcon(haut));
    		BasP.setIcon(new ImageIcon(bas));
    		GaucheP.setIcon(new ImageIcon(gauche));
    		DroitP.setIcon(new ImageIcon(droit));
    		
    		HautN.setIcon(new ImageIcon(haut));
    		BasN.setIcon(new ImageIcon(bas));
    		GaucheN.setIcon(new ImageIcon(gauche));
    		DroitN.setIcon(new ImageIcon(droit));

    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}


        avatar(0,0);

        this.addKeyListener(new ClavierListener());
        this.setFocusable(true);

        
        this.setVisible(true);
        
        
        //************************************************Les listeners************************************************************
        
        Nettoyer.addActionListener(new NettoyerListener());
        Polluer.addActionListener(new PolluerListener());
        Reinitialiser.addActionListener(new ReinitialiserListener());
        Quitter.addActionListener(new QuitterListener());
        
        PolluerDroit.addActionListener(new PolluerDroitListener());
        PolluerSauteurs.addActionListener(new PolluerSauteursListener());
        RobotsLibres.addActionListener(new RobotsLibresListener());
        QuitterG.addActionListener(new QuitterGListener());
       
        RobotsDroit.addActionListener(new RobotsDroitListener());
        NettoyerD.addActionListener(new NettoyerDroitListener());
        SmartRoboticCleaner.addActionListener(new SmartRoboticCleanerListener());
        QuitterD.addActionListener(new QuitterDListener());
    	

        HautP.addActionListener(new HautPListener());
        BasP.addActionListener(new BasPListener());
        GaucheP.addActionListener(new GauchePListener());
        DroitP.addActionListener(new DroitPListener());
        
        HautN.addActionListener(new HautNListener());
        BasN.addActionListener(new BasNListener());
        GaucheN.addActionListener(new GaucheNListener());
        DroitN.addActionListener(new DroitNListener());
        
    	
        

        ////////////////////////////////////////////////////////////////
        

      }
    
    
    public void avatar(int x, int y)
  	{  		
   	
        try {
    		Image avatarI = ImageIO.read(getClass().getResource("/images/Nettoyeur.png")); ///
    		ImageIcon avatarIC = new ImageIcon(avatarI);
        	matriceLabel[x][y].setIcon(avatarIC);

    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}

  	}
  	
  	
    
    class NettoyerListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
        	for(int i = 0; i < matriceLabel.length; i++ )
        	{
            	for(int j = 0; j < matriceLabel[i].length; j++ )
            	{
            		matriceLabel[i][j].setBackground(Color.WHITE);
            	}
        	}
        }
    }
    
    class PolluerListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
    	  
        	for(int i = 0; i < matriceLabel.length; i++ )
        	{
            	for(int j = 0; j < matriceLabel[i].length; j++ )
            	{
            		matriceLabel[i][j].setBackground(Color.BLACK);

            	}
        	}
        }
    }
    
    class ReinitialiserListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
    	  

        }
    }
    
    class QuitterListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
        	
        	System.exit(-1);

        }
    }

    class PolluerDroitListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
 
        	for(int i = 0; i < matriceLabel.length - PollueurToutDroit.posx ; i++)
        	{
           		       		
        		try {
            		matriceLabel[PollueurToutDroit.posx +  i ][PollueurToutDroit.posy].setBackground(Color.BLACK);
            		m.MetPapier((PollueurToutDroit.posx +  i) , PollueurToutDroit.posy);
            		//System.out.println(i);
					Thread.sleep(1);
					//wait(1);
					//TimeUnit.SECONDS.sleep(1);

					//repaint();
				//	matriceLabel[PollueurToutDroit.posx +  i ][PollueurToutDroit.posy].repaint();
					
				} catch (MettrePapierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		

        	}
        	//matriceLabel[PollueurToutDroit.posx][PollueurToutDroit.posy].setBackground(Color.RED);
        	 

        }
    }
    
    class PolluerSauteursListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
    	  

        }
    }
    
    class RobotsLibresListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
    	  

        }
    }
    
    class QuitterGListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
    	  

        }
    }
    
    class RobotsDroitListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
    	  

        }
    }
    
    class NettoyerDroitListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
        	
        	for(int i = 0; i < matriceLabel.length - NettoyeurToutDroit.posx ; i++)
        	{
           		       		
        		try {
            		matriceLabel[NettoyeurToutDroit.posx +  i ][NettoyeurToutDroit.posy].setBackground(Color.WHITE);
            		m.MetPapier((NettoyeurToutDroit.posx +  i) , NettoyeurToutDroit.posy);
            		//System.out.println(i);
					Thread.sleep(1);
					//wait(1);
					//TimeUnit.SECONDS.sleep(1);

					//repaint();
				//	matriceLabel[PollueurToutDroit.posx +  i ][PollueurToutDroit.posy].repaint();
					
				} catch (MettrePapierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		

        	}
        	//matriceLabel[PollueurToutDroit.posx][PollueurToutDroit.posy].setBackground(Color.RED);
    	  

        }
    }    
    
    class SmartRoboticCleanerListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
    	  

        }
    }    
    
    class QuitterDListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
    	  

        }
    }    
    
    
    
    class HautPListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
	  
        	PollueurToutDroit.setPosx(PollueurToutDroit.posx - 1, matriceLabel.length);	// 
        	avatar(PollueurToutDroit.posx, PollueurToutDroit.posy);
        	matriceLabel[PollueurToutDroit.posx + 1][PollueurToutDroit.posy].setIcon(null);

        }
    }    
    
    class BasPListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
    	  
        	PollueurToutDroit.setPosx(PollueurToutDroit.posx + 1, matriceLabel.length);
        	avatar(PollueurToutDroit.posx, PollueurToutDroit.posy);
        	matriceLabel[PollueurToutDroit.posx - 1][PollueurToutDroit.posy].setIcon(null);

        	
        }
    }    
    
    class GauchePListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
   	  
        	PollueurToutDroit.setPosy(PollueurToutDroit.posy - 1, matriceLabel.length);	// 
        	avatar(PollueurToutDroit.posx, PollueurToutDroit.posy);
        	matriceLabel[PollueurToutDroit.posx][PollueurToutDroit.posy + 1].setIcon(null);

        }
    }    
    
    class DroitPListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
 
        	PollueurToutDroit.setPosy(PollueurToutDroit.posy + 1, matriceLabel.length);	//
        	avatar(PollueurToutDroit.posx, PollueurToutDroit.posy);
        	matriceLabel[PollueurToutDroit.posx][PollueurToutDroit.posy - 1].setIcon(null);

        }
    }
    
    class HautNListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
        	
        	NettoyeurToutDroit.setPosx(NettoyeurToutDroit.posx - 1, matriceLabel.length);	// 
        	avatar(NettoyeurToutDroit.posx, NettoyeurToutDroit.posy);
        	matriceLabel[NettoyeurToutDroit.posx + 1][NettoyeurToutDroit.posy].setIcon(null);
    	  

        }
    }
    
    class BasNListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
    	  
        	NettoyeurToutDroit.setPosx(NettoyeurToutDroit.posx + 1, matriceLabel.length);
        	avatar(NettoyeurToutDroit.posx, NettoyeurToutDroit.posy);
        	matriceLabel[NettoyeurToutDroit.posx - 1][NettoyeurToutDroit.posy].setIcon(null);

        }
    }
    
    class GaucheNListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
        	
        	NettoyeurToutDroit.setPosy(NettoyeurToutDroit.posy - 1, matriceLabel.length);	// 
        	avatar(NettoyeurToutDroit.posx, NettoyeurToutDroit.posy);
        	matriceLabel[NettoyeurToutDroit.posx][NettoyeurToutDroit.posy + 1].setIcon(null);
    	  

        }
    }
    
    class DroitNListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
        	
        	NettoyeurToutDroit.setPosy(NettoyeurToutDroit.posy + 1, matriceLabel.length);	//
        	avatar(NettoyeurToutDroit.posx, NettoyeurToutDroit.posy);
        	matriceLabel[NettoyeurToutDroit.posx][NettoyeurToutDroit.posy - 1].setIcon(null);
        }
    }


    class ClavierListener implements KeyListener{

	    public void keyPressed(KeyEvent event) {
	    	
	    	if(event.getKeyCode() == KeyEvent.VK_UP)
	    	{
	    	    PollueurToutDroit.setPosx(PollueurToutDroit.posx - 1, matriceLabel.length);	// 
        	    avatar(PollueurToutDroit.posx, PollueurToutDroit.posy);
        	    matriceLabel[PollueurToutDroit.posx + 1][PollueurToutDroit.posy].setIcon(null);
	        	
	    	}
	    	
	    	if(event.getKeyCode() == KeyEvent.VK_DOWN)
	    	{
	    	    PollueurToutDroit.setPosx(PollueurToutDroit.posx + 1, matriceLabel.length);	// 
        	    avatar(PollueurToutDroit.posx, PollueurToutDroit.posy);
        	    matriceLabel[PollueurToutDroit.posx - 1][PollueurToutDroit.posy].setIcon(null);
        	    
	    	}
	    	
	    	if(event.getKeyCode() == KeyEvent.VK_RIGHT)
	    	{
	    	    PollueurToutDroit.setPosy(PollueurToutDroit.posy + 1, matriceLabel.length);	// 
        	    avatar(PollueurToutDroit.posx, PollueurToutDroit.posy);
        	    matriceLabel[PollueurToutDroit.posx][PollueurToutDroit.posy - 1].setIcon(null);

	    	}
	    	
	    	if(event.getKeyCode() == KeyEvent.VK_LEFT)
	    	{
	    	   PollueurToutDroit.setPosy(PollueurToutDroit.posy - 1, matriceLabel.length);	// 
        	   avatar(PollueurToutDroit.posx, PollueurToutDroit.posy);
        	   matriceLabel[PollueurToutDroit.posx][PollueurToutDroit.posy + 1].setIcon(null);
	    	
	    	}
	    	
	    	if(event.getKeyCode() == KeyEvent.VK_SPACE)
	    	{
	        	for(int i = 0; i < matriceLabel.length - PollueurToutDroit.posx ; i++)
	        	{
	        		matriceLabel[PollueurToutDroit.posx +  i ][PollueurToutDroit.posy].setBackground(Color.BLACK);
	        		try {
						m.MetPapier(PollueurToutDroit.posx +  i , PollueurToutDroit.posy);
					} catch (MettrePapierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	}

	    	}
	    	
	    }

	    public void keyReleased(KeyEvent event) {

	    }

	    public void keyTyped(KeyEvent event) {

	    }   	
	}  
    
}
