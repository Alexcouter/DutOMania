package jeuGraphicV2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import jeuGraphic.panelMain;
import jeuGraphic.FenetreJeuNormal.RepondreQuestion;

import JeuCode.JeuNormal;
import JeuCode.ListeQuestions;
import JeuCode.Question;

public class NormalGamePanel extends JPanel {
	private JeuNormal jeu = new JeuNormal();
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
	private Question question = jeu.chargerQuestion();
	private int compteurQuestion = 1;
	private JButton suivant;
	
	
	public NormalGamePanel(){
		
		//céation des éléments du panel
		normalTexteTop = new JLabel("- Mode Normal -");
		
		questionTexte = new JLabel("Question");
		
		questionNumero = new JLabel();
//		questionNumero.setHorizontalAlignment(0);
//		questionNumero.setBounds(0, 0, 330, 40);
		questionNumero.setLocation(new Point(230,300));
		questionNumero.setText("Question n°"+compteurQuestion);
		
		normalScore = new JLabel();
		normalScore.setLocation(new Point(710,0));
		normalScore.setText("Score : "+jeu.getScore());
		
		reponse1 = new JButton();
		reponse1.setSize(new Dimension(350, 50));
		reponse1.setText(question.getProposition(1));
		reponse1.addActionListener(new RepondreQuestion());
		reponse1.setLocation(new Point(35,400));
		
		reponse2 = new JButton();
		reponse2.setSize(new Dimension(350, 50));
		reponse2.setText(question.getProposition(2));
		reponse2.addActionListener(new RepondreQuestion());
		reponse2.setLocation(new Point(400,400));
		
		reponse3 = new JButton();
		reponse3.setSize(new Dimension(350, 50));
		reponse3.setText(question.getProposition(3));
		reponse3.addActionListener(new RepondreQuestion());
		reponse3.setLocation(new Point(35,470));
		
		reponse4 = new JButton();
		reponse4.setSize(new Dimension(350, 50));
		reponse4.setText(question.getProposition(4));
		reponse4.addActionListener(new RepondreQuestion());
		reponse4.setLocation(new Point(400,470));
		
		suivant = new JButton("Question suivante");
		suivant.setSize(new Dimension(200, 25));
		suivant.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
								
			}
		});
		this.suivant.setLocation(new Point(300,540));
		this.suivant.setVisible(false);
		
		if (this.boutonQuitter == null)
		{
			this.boutonQuitter  = new JButton();
			this.boutonQuitter.setSize(new Dimension(150, 25));
			this.boutonQuitter.setText("Quitter la partie");
			this.boutonQuitter.setLocation(new Point(550,10));
//			getRootPane().setDefaultButton(boutonQuitter);
			this.boutonQuitter.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
//					DutOManiaWindow.cont.remove(DutOManiaWindow.ecranJeuNormal);
					DutOManiaWindow.cont.add(DutOManiaWindow.menuPrincipal);
					DutOManiaWindow.cont.validate();
					
				}
			});
			
		}
		
		
		

		
		
		//Position du texte
	

		normalTexteTop.setBounds(0, 0, 100, 40);
		//setBounds(x,y,width,height)
		normalTexteTop.setLocation(new Point(10,0));
		
		questionTexte.setBounds(0, 0, 330, 40);
		questionTexte.setLocation(new Point(230,320));
		
		normalTexteTop.setLocation(new Point(10,0));
		
		questionTexte = new JLabel("Bientot on aura l'intitulé de la question");
		questionTexte.setBounds(0, 0, 330, 40);
		questionTexte.setLocation(new Point(230,320));
		
		
		
		// Creation du panel
		panelNormal = new JPanel();
		panelNormal.setLayout(null);
		
		
		//bar de progession
		
	
		
		//Ajout des éléments au panel
		panelNormal.add(normalTexteTop);
		panelNormal.add(boutonQuitter);
		panelNormal.add(normalScore);
		panelNormal.add(questionNumero);
		panelNormal.add(questionTexte);
		panelNormal.add(reponse1);
		panelNormal.add(reponse2);
		panelNormal.add(reponse3);
		panelNormal.add(reponse4);
		panelNormal.add(suivant);
		
	}
	
	//Listener des boutons de réponse
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
