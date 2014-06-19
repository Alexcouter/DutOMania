package jeuGraphic;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import JeuCode.Jeu;
import JeuCode.JeuNormal;
import JeuCode.Question;

public class FenetreJeuNormal extends FenetreBase implements ActionListener {
	private JPanel panelNormal = null;
	private JLabel normalTexteTop = null;
	private JLabel normalScore = null;
	private JLabel questionNumero = null;
	private JLabel progression = null;
	private JLabel questionTexte = null;
	private JButton boutonQuitter = null;
	private JButton reponse1 = null;
	private JButton reponse2 = null;
	private JButton reponse3 = null;
	private JButton reponse4 = null;
	private int compteurQuestion = 0;
	private JeuNormal jeu = new JeuNormal();
	private Question question = jeu.chargerQuestion();

	public FenetreJeuNormal() {
		super("Mode normal");
		setContentPane(getPanelNormal());
		validate();	
		
	}		

	private JPanel getPanelNormal() {
		if (this.panelNormal == null)
		{
			
			//creation du panel


			//texte en haut ‡ gauche
			this.normalTexteTop = new JLabel();

			//setBounds(x,y,width,height)

			this.normalTexteTop.setBounds(0, 0, 100, 40);

			this.normalTexteTop.setText("- Mode Normal -");
			//Position du texte
			this.normalTexteTop.setLocation(new Point(10,0));
			
			this.questionTexte = new JLabel(question.getIntituleQuestion());
			this.questionTexte.setBounds(0, 0, 330, 40);
			this.questionTexte.setLocation(new Point(230,320));
			
			
			
			// Creation du panel
			this.panelNormal = new JPanel();
			this.panelNormal.setLayout(null);
			//Ajout des boutons via des methodes de cr√©ation 
			this.panelNormal.add(this.normalTexteTop);
			this.panelNormal.add(getBoutonQuitter());
		getPanneauReponses();
			this.panelNormal.add(getScore());
			this.panelNormal.add(getQuestionNumero());
			this.panelNormal.add(this.questionTexte);

		}
		return this.panelNormal;
	}

	private void getPanneauReponses() {
		
		this.reponse1 = new JButton();
		this.reponse1.setSize(new Dimension(350, 50));
		this.reponse1.setText(question.getProposition(1));
		this.reponse1.addActionListener(new RepondreQuestion());
		this.reponse1.setLocation(new Point(35,400));
		this.panelNormal.add(this.reponse1);
		this.reponse2 = new JButton();
		this.reponse2.setSize(new Dimension(350, 50));
		this.reponse2.setText(question.getProposition(2));
		this.reponse2.addActionListener(new RepondreQuestion());
		this.reponse2.setLocation(new Point(400,400));
		this.panelNormal.add(this.reponse2);
		this.reponse3 = new JButton();
		this.reponse3.setSize(new Dimension(350, 50));
		this.reponse3.setText(question.getProposition(3));
		this.reponse3.addActionListener(new RepondreQuestion());
		this.reponse3.setLocation(new Point(35,470));
		this.panelNormal.add(this.reponse3);
		this.reponse4 = new JButton();
		this.reponse4.setSize(new Dimension(350, 50));
		this.reponse4.setText(question.getProposition(4));
		this.reponse4.addActionListener(new RepondreQuestion());
		this.reponse4.setLocation(new Point(400,470));
		this.panelNormal.add(this.reponse4);
	}

	private JLabel getQuestionNumero() {
		this.questionNumero = new JLabel();
		this.questionNumero.setHorizontalAlignment(0);
		this.questionNumero.setBounds(0, 0, 330, 40);
		this.questionNumero.setLocation(new Point(230,300));
		this.questionNumero.setText("Question n∞"+compteurQuestion);
		return this.questionNumero;
	}

	private JLabel getScore() {
		this.normalScore = new JLabel();
		this.normalScore.setBounds(0, 0, 100, 40);
		this.normalScore.setLocation(new Point(710,0));
		this.normalScore.setText("Score : "+jeu.getScore());
		return this.normalScore;
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
	
	public class RepondreQuestion implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton boutonClique = (JButton) e.getSource();
			boolean resultat = false;
			if(boutonClique == reponse1)
				resultat = question.checkReponse(1);
			if(boutonClique == reponse2)
				resultat = question.checkReponse(2);
			if(boutonClique == reponse3)
				resultat = question.checkReponse(3);
			if(boutonClique == reponse4)
				resultat = question.checkReponse(4);
			
			if(resultat == true){
				jeu.augmenterScore();
				boutonClique.setBackground(Color.GREEN);
				boutonClique.setContentAreaFilled(false);
				boutonClique.setOpaque(true);
                System.out.println("vrai"+jeu.getScore());
                boutonClique.revalidate();
                normalScore.setText("Score : "+jeu.getScore());
                normalScore.revalidate();
                }
			else{
				boutonClique.setBackground(Color.RED);
				boutonClique.setContentAreaFilled(false);
				boutonClique.setOpaque(true);
                System.out.println("faux");
                boutonClique.revalidate();			
			}
			
			compteurQuestion++;
		}

	}


}
