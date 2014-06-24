package jeuGraphic;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import JeuImages.MainDut;

public class MainMenuPanel extends JPanel {
	private JButton boutonNormal = null;
	private JButton boutonSurvie = null;
	private JButton boutonQuitter = null;
	private JButton boutonGestionnaire;
	
	public MainMenuPanel() {
		//Image de fond
		
		MainDut backGround = new MainDut("JeuImages/MainDut.jpg");
		backGround.setBounds(0, 0, 800, 600);
		
		//Création bouton normal
		boutonNormal = new JButton();
		boutonNormal.setSize(new Dimension(320, 60));
		boutonNormal.setText("Normal");
		boutonNormal.setLocation(new Point(240,300));
		
		//Création bouton survie
		boutonSurvie = new JButton();
		boutonSurvie.setSize(new Dimension(320, 60));
		boutonSurvie.setLocation(new Point(240,400));
		boutonSurvie.setText("Survie");
		
		//Création bouton quitter
		boutonQuitter = new JButton();
		boutonQuitter.setSize(new Dimension(320, 60));
		boutonQuitter.setLocation(new Point(240,500));
		boutonQuitter.setText("Quitter le jeu");
		
		//Création bouton gestionnaire
//		ImageIcon icon = new ImageIcon(this.getClass().getResource("/JeuImages/iconeGestionnaire.jpg" )); 
//		boutonGestionnaire = new JButton(icon);
//		boutonGestionnaire.setIcon(new ImageIcon("/DutOMania/src/JeuImages/"));
		boutonGestionnaire = new JButton("Gestionnaire de questions");
		boutonGestionnaire.setSize(new Dimension(190, 20));
		boutonGestionnaire.setLocation(new Point(590, 540));
		boutonGestionnaire.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new GestionnaireWindow();
				
			}
		});
		
		//Ajout des boutons
		setLayout(null);
		add(boutonNormal);
		add(boutonQuitter);
		add(boutonSurvie);
		add(boutonGestionnaire);
		add(backGround);
		
		//ActionListeners
		boutonNormal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DutOManiaWindow.cont.remove(DutOManiaWindow.menuPrincipal);
				DutOManiaWindow.cont.add(DutOManiaWindow.ecranJeuNormal);
				DutOManiaWindow.cont.validate();
				DutOManiaWindow.cont.repaint();
			}
		});
		boutonSurvie.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DutOManiaWindow.cont.remove(DutOManiaWindow.menuPrincipal);
				DutOManiaWindow.cont.add(DutOManiaWindow.menuChoixSurvie);
				DutOManiaWindow.cont.validate();
				DutOManiaWindow.cont.repaint();
			}
		});
		boutonQuitter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
	}
	

}
