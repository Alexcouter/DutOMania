package jeuGraphic;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import JeuCode.ScoreSurvie;


public class FenetreJeuSurvie extends FenetreBase implements ActionListener {
	private JPanel panelSurvie = null;
	private JPanel vies = null;
	private JLabel survieTexteTop = null;
	private JLabel survieScore = null;
	private JLabel questionNumero = null;
	private JButton boutonQuitter = null;

	public FenetreJeuSurvie(int bouton) {
		super("Mode survie");
		setContentPane(getPanelSurvie());
		validate();	
	}		

	private JPanel getPanelSurvie() {
		if (this.panelSurvie == null)
		{  	
			//creation du panel


			//texte en haut ‡ gauche
			this.survieTexteTop = new JLabel();

			//setBounds(x,y,width,height)

			this.survieTexteTop.setBounds(0, 0, 100, 40);

			this.survieTexteTop.setText("- Mode Survie -");
			//Position du texte
			this.survieTexteTop.setLocation(new Point(10,0));
			this.panelSurvie = new JPanel();
			this.panelSurvie.setLayout(null);

			//Ajout des boutons via des methodes de cr√©ation 
			this.panelSurvie.add(this.survieTexteTop);
			this.panelSurvie.add(getBoutonQuitter());
			this.panelSurvie.add(getScore());
			this.panelSurvie.add(getQuestionNumero());

		}
		return this.panelSurvie;
	}

	private JLabel getQuestionNumero() {
		this.questionNumero = new JLabel();
		this.questionNumero.setHorizontalAlignment(0);
		this.questionNumero.setBounds(0, 0, 330, 40);
		this.questionNumero.setLocation(new Point(240,300));
		this.questionNumero.setText("Question n∞"/*+ numeroquestion*/ );
		return this.questionNumero;
	}

	private JLabel getScore() {
		this.survieScore = new JLabel();
		this.survieScore.setBounds(0, 0, 100, 40);
		this.survieScore.setLocation(new Point(710,0));
		this.survieScore.setText("Score : "/* + Score.recupererScore*/  );
		return this.survieScore;
	}

	private JButton getBoutonQuitter()
	{
		if (this.boutonQuitter == null)
		{
			this.boutonQuitter  = new JButton();
			this.boutonQuitter.setSize(new Dimension(150, 25));
			this.boutonQuitter.setText("Quitter la partie");
			this.boutonQuitter.setLocation(new Point(550,10));
			this.boutonQuitter.addActionListener(this);
			getRootPane().setDefaultButton(this.boutonQuitter);
		}
		return this.boutonQuitter;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.boutonQuitter){
			new panelMain();
			dispose();
		}
	}



}
