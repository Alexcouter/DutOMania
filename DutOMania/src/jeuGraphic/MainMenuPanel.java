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
		//Images
		ImageIcon iconeNormal = new ImageIcon(this.getClass().getResource("/JeuImages/BoutonNormal.jpg" ));
		ImageIcon iconeSurvie = new ImageIcon(this.getClass().getResource("/JeuImages/BoutonSurvie.jpg"));
		ImageIcon iconeQuitter = new ImageIcon(this.getClass().getResource("/JeuImages/BoutonQuitterMain.jpg"));
		ImageIcon iconeGestionnaire = new ImageIcon(this.getClass().getResource("/JeuImages/BoutonGestionnaire.jpg"));

		MainDut backGround = new MainDut("JeuImages/MainDut.jpg");
		backGround.setBounds(0, 0, 800, 600);
		
		//Cr�ation bouton normal
		boutonNormal = new JButton(iconeNormal);
		boutonNormal.setSize(new Dimension(320, 60));
		boutonNormal.setLocation(new Point(240,300));
		
		//Cr�ation bouton survie
		boutonSurvie = new JButton(iconeSurvie);
		boutonSurvie.setSize(new Dimension(320, 60));
		boutonSurvie.setLocation(new Point(240,400));

		//Cr�ation bouton quitter
		boutonQuitter = new JButton(iconeQuitter);
		boutonQuitter.setSize(new Dimension(320, 60));
		boutonQuitter.setLocation(new Point(240,500));
		
		//Cr�ation bouton gestionnaire
//		ImageIcon icon = new ImageIcon(this.getClass().getResource("/JeuImages/iconeGestionnaire.jpg" )); 
//		boutonGestionnaire = new JButton(icon);
//		boutonGestionnaire.setIcon(new ImageIcon("/DutOMania/src/JeuImages/"));
		boutonGestionnaire = new JButton(iconeGestionnaire);
		boutonGestionnaire.setSize(new Dimension(116, 20));
		boutonGestionnaire.setLocation(new Point(650, 540));
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
