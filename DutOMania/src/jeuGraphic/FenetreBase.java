package jeuGraphic;

import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class FenetreBase extends JFrame {
	 public FenetreBase(String title) {
	 	
	 	//Permet la création d'une super classe fenêtre
	 	
//	    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/LogoAplacer.ici")));
	    setVisible(true);
	    
	    //taille 800x600
	    
	    setSize(800, 600);
	    setLayout(new FlowLayout(1));
	    
	    //Centré au lancement
	    
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	    //Contient un titre pour chaque nouvelle fenêtre
	    
	    setTitle("Dut'O'Mania | "+ title);
	    setResizable(false);
	  }
}
