package jeuGraphicV2;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SurvivalChoicePanel extends JPanel {
	private JLabel survieChoixTxt;
	private JButton boutonFacile;
	private JButton boutonNormal;
	private JButton boutonDifficile;
	private JButton boutonRetour;
	public int difficulte;
	
	public SurvivalChoicePanel(){
		//texte au dessus des boutons
		survieChoixTxt = new JLabel();
		
		//setBounds(x,y,width,height)
		survieChoixTxt.setBounds(30, 125, 330, 40);
		
		//Texte centre
		survieChoixTxt.setHorizontalAlignment(0);
		survieChoixTxt.setText("Mode Survie :");
		
		//Position du texte
		survieChoixTxt.setLocation(new Point(240,100));
		
		//Création des boutons
		boutonFacile = new JButton();
		boutonFacile.setSize(new Dimension(320, 60));
		boutonFacile.setText("Facile");
		boutonFacile.setLocation(new Point(240,200));
		
		boutonNormal = new JButton();
		boutonNormal.setSize(new Dimension(320, 60));
		boutonNormal.setText("Normale");
		boutonNormal.setLocation(new Point(240,300));
		
		boutonDifficile = new JButton();
		boutonDifficile.setSize(new Dimension(320, 60));
		boutonDifficile.setText("Difficile");
		boutonDifficile.setLocation(new Point(240,400));
		
		boutonRetour = new JButton();
		boutonRetour.setSize(new Dimension(100, 40));
		boutonRetour.setText("Retour");
		boutonRetour.setLocation(new Point(50,500));
		
		//Ajout des listener au boutons
		boutonFacile.addActionListener(new defDificulteSurvie());
		boutonNormal.addActionListener(new defDificulteSurvie());
		boutonDifficile.addActionListener(new defDificulteSurvie());
		boutonRetour.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DutOManiaWindow.cont.remove(DutOManiaWindow.menuChoixSurvie);
				DutOManiaWindow.cont.add(DutOManiaWindow.menuPrincipal);
				DutOManiaWindow.cont.validate();
				
			}
		});
		
		//Ajout des boutons
		setLayout(null);
		add(boutonFacile);
		add(boutonNormal);
		add(boutonDifficile);
		add(boutonRetour);
		add(survieChoixTxt);
		
	}
	
	public class defDificulteSurvie implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton boutonClique = (JButton) e.getSource();
			
			if(boutonClique == boutonFacile){
				difficulte = 1;
				DutOManiaWindow.ecranJeuSurvie.jeu.setDifficulte(difficulte);
				
			}else if(boutonClique == boutonNormal){
				difficulte = 2;
				DutOManiaWindow.ecranJeuSurvie.jeu.setDifficulte(difficulte);
			}else{
				difficulte = 3;
				DutOManiaWindow.ecranJeuSurvie.jeu.setDifficulte(difficulte);
			}
			DutOManiaWindow.cont.remove(DutOManiaWindow.menuChoixSurvie);
			DutOManiaWindow.cont.add(DutOManiaWindow.ecranJeuSurvie);
			DutOManiaWindow.cont.validate();
			
		}
		
	}
}
