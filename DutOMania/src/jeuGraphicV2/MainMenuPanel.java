package jeuGraphicV2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import jeuGraphic.FenetreJeu;
import JeuImages.MainDut;

public class MainMenuPanel extends JPanel {
	private JButton boutonNormal = null;
	private JButton boutonSurvie = null;
	private JButton boutonQuitter = null;
	
	public MainMenuPanel() {
		//Image de fond
		MainDut backGround = new MainDut();
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
		
		//Ajout des boutons
		setLayout(null);
		add(boutonNormal);
		add(boutonQuitter);
		add(boutonSurvie);
		add(backGround);
		
		//ActionListeners
		boutonNormal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DutOManiaWindow.cont.add(DutOManiaWindow.ecranJeuNormal);
				DutOManiaWindow.cont.validate();
			}
		});
		boutonSurvie.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DutOManiaWindow.cont.add(DutOManiaWindow.menuChoixSurvie);
				DutOManiaWindow.cont.validate();
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
