package jeuGraphicV2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jeuGraphicV2.NormalGamePanel.RepondreQuestion;

import JeuCode.JeuNormal;
import JeuCode.JeuSurvie;
import JeuCode.Question;

public class SurvieGamePanel extends JPanel{
	public JeuSurvie jeu =  new JeuSurvie();;

	private JLabel vies = null;
	private JLabel survieTexteTop = null;
	private JLabel survieScore = null;
	private JLabel questionNumero = null;
	private JButton boutonQuitter = null;
//	private JLabel progression = null;
	private JLabel questionTexte = null;
	private JButton reponse1 = null;
	private JButton reponse2 = null;
	private JButton reponse3 = null;
	private JButton reponse4 = null;
	private Question question = jeu.chargerQuestion();
	private JButton suivant;
	private Color couleurDefautBouton;
	
	public SurvieGamePanel(){
		
		//céation des éléments du panel
				survieTexteTop = new JLabel("- Mode Survie -");

				survieTexteTop.setBounds(0, 0, 100, 40);

				//		normalTexteTop.setLocation(new Point(10,0));
				//		
				//		questionTexte.setBounds(0, 0, 330, 40);
				//		questionTexte.setLocation(new Point(230,320));

				survieTexteTop.setLocation(new Point(10,0));

				questionTexte = new JLabel("Question");
				questionTexte.setBounds(0, 0, 330, 40);
				questionTexte.setLocation(new Point(230,320));



				questionNumero = new JLabel();
				questionNumero.setHorizontalAlignment(0);
				questionNumero.setBounds(0, 0, 330, 40);
				questionNumero.setLocation(new Point(230,300));


				survieScore = new JLabel();
				survieScore.setBounds(0, 0, 100, 40);
				survieScore.setLocation(new Point(710,0));


				reponse1 = new JButton();
				reponse1.setSize(new Dimension(350, 50));
				reponse1.addActionListener(new RepondreQuestion());
				reponse1.setLocation(new Point(35,400));

				reponse2 = new JButton();
				reponse2.setSize(new Dimension(350, 50));
				reponse2.addActionListener(new RepondreQuestion());
				reponse2.setLocation(new Point(400,400));

				reponse3 = new JButton();
				reponse3.setSize(new Dimension(350, 50));
				reponse3.addActionListener(new RepondreQuestion());
				reponse3.setLocation(new Point(35,470));


				reponse4 = new JButton();
				reponse4.setSize(new Dimension(350, 50));
				reponse4.addActionListener(new RepondreQuestion());
				reponse4.setLocation(new Point(400,470));

				suivant = new JButton("Question suivante");
				suivant.setSize(new Dimension(200, 25));
				suivant.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						jeu.enleverQuestionListe(question);
						try {
							question = jeu.chargerQuestion();
							chargerInterfaceReponse();
							resetBoutons();	
						} catch (Exception e) {
							System.out.println("Pas encore assez de question pour finir");
						}




						repaint();

					}
				});
				
				suivant.setLocation(new Point(300,540));
				suivant.setVisible(false);
				
				boutonQuitter  = new JButton();
				boutonQuitter.setSize(new Dimension(150, 25));
				boutonQuitter.setText("Quitter la partie");
				boutonQuitter.setLocation(new Point(550,10));
				boutonQuitter.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						DutOManiaWindow.cont.remove(DutOManiaWindow.ecranJeuNormal);
						DutOManiaWindow.cont.add(DutOManiaWindow.menuPrincipal);
						DutOManiaWindow.cont.validate();

					}
				});
				
				//chargement de l'interface
				Color couleurDefautBoutoncouleurDefautBouton = reponse1.getBackground();
				chargerInterfaceReponse();
				
				// Creation du panel
				setLayout(null);
				
				//ajout des composant dans le panel
				add(survieTexteTop);
				add(boutonQuitter);
				add(survieScore);
				add(questionNumero);
				add(questionTexte);
				add(reponse1);
				add(reponse2);
				add(reponse3);
				add(reponse4);
				add(suivant);
				
		
	}
	
	public void resetBoutons(){
		reponse1.setEnabled(true);
		reponse2.setEnabled(true);
		reponse3.setEnabled(true);
		reponse4.setEnabled(true);
		
		reponse1.setBackground(couleurDefautBouton);
		reponse2.setBackground(couleurDefautBouton);
		reponse3.setBackground(couleurDefautBouton);
		reponse4.setBackground(couleurDefautBouton);

		suivant.setVisible(false);

	}


	public void chargerInterfaceReponse(){
//		questionNumero.setText("Question n°"+compteurQuestion);
//		survieScore.setText("Score : "+jeu.getScore());
		reponse1.setText(question.getProposition(1));
		reponse2.setText(question.getProposition(2));
		reponse3.setText(question.getProposition(3));
		reponse4.setText(question.getProposition(4));
		questionTexte.setText(question.getIntituleQuestion());
	}
	
	
	public class RepondreQuestion implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			reponse1.setEnabled(false);
			reponse2.setEnabled(false);
			reponse3.setEnabled(false);
			reponse4.setEnabled(false);
			suivant.setVisible(true);

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
				survieScore.setText("Score : "+jeu.getScore());
				survieScore.revalidate();
			}
			else{
				jeu.gererVies();
				boutonClique.setBackground(Color.RED);
				boutonClique.setContentAreaFilled(false);
				boutonClique.setOpaque(true);
				System.out.println("faux");
				boutonClique.revalidate();			
			}

//			compteurQuestion++;
		}

	}
	
	
}
