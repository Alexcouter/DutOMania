package jeuGraphic;

import java.awt.*;

import javax.swing.*;

public class DutOManiaWindow extends JFrame {
	public static MainMenuPanel menuPrincipal = new MainMenuPanel();
	public static SurvivalChoicePanel menuChoixSurvie = new SurvivalChoicePanel();
	public static NormalGamePanel ecranJeuNormal = new NormalGamePanel();
	public static SurvieGamePanel ecranJeuSurvie = new SurvieGamePanel();
	public static EndNormalPanel ecrantFinJeuNormal = new EndNormalPanel();
	public static EndSurviePanel ecrantFinJeuSurvie = new EndSurviePanel();
	public static Container cont;
	
	public DutOManiaWindow(){
		super("DutOMania");
	 	//Permet la création d'une super classe fenêtre
//	    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/LogoAplacer.ici")));
	    
	    //taille 800x600
	    
	    setSize(800, 600);
//	    setLayout(new CardLayout());
	    
	    //Ajout des panels
	    cont = getContentPane();
	    cont.add(menuPrincipal);
  
	   
	    
	    //Centré au lancement
	    
	    
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	    setResizable(false);
	    setVisible(true);
	}
	
	public static void main(String[] args) {
		new DutOManiaWindow();
		
		
	}
}
