package jeuGraphic;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;


public class FenetreMain extends FenetreBase implements ActionListener {
	  private JPanel panelMain = null;
	  private JButton boutonNormal = null;
	  private JButton boutonSurvie = null;
	  private JButton bouton4J = null;
	  private JLabel information = null;
	  
	  
	 public FenetreMain(){
			super("Écran d'accueil",800,600);
			validate();
	 }
	  

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}	

}
