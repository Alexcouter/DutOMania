package jeuGraphic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import jeuGraphic.NormalGamePanel.RepondreQuestion;
import JeuCode.JeuNormal;
import JeuCode.JeuSurvie;
import JeuCode.Question;

public class SurvieGamePanel extends JPanel{
	public JeuSurvie jeu =  new JeuSurvie();

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
	private Image bg;
	private Image theme;
	private String urltheme;


	public SurvieGamePanel(){
		ImageIcon iconeQuitter = new ImageIcon(this.getClass().getResource("/JeuImages/BoutonQuitter.jpg"));
		ImageIcon iconeSuivante = new ImageIcon(this.getClass().getResource("/JeuImages/questionSuivante.jpg"));

		try
		{
			this.bg = ImageIO.read(getClass().getClassLoader().getResource("JeuImages/SurvieBg.jpg"));

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		//céation des éléments du panel
		survieTexteTop = new JLabel("- Mode Survie -");


		survieTexteTop.setBounds(0, 0, 100, 40);

		//		normalTexteTop.setLocation(new Point(10,0));
		//		
		//		questionTexte.setBounds(0, 0, 330, 40);
		//		questionTexte.setLocation(new Point(230,320));

		survieTexteTop.setLocation(new Point(10,0));

		questionTexte = new JLabel("Question");
		questionTexte.setBounds(0, 0, 750, 60);
		questionTexte.setLocation(new Point(35,310));
		questionTexte.setHorizontalAlignment(SwingConstants.CENTER);



		questionNumero = new JLabel();
		questionNumero.setHorizontalAlignment(0);
		questionNumero.setBounds(0, 0, 330, 40);
		questionNumero.setLocation(new Point(230,300));


		survieScore = new JLabel();
		survieScore.setBounds(0, 0, 100, 40);
		survieScore.setLocation(new Point(710,0));


		vies = new JLabel();
		vies.setBounds(0, 0, 100, 40);
		vies.setLocation(new Point(200,0));






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

		suivant = new JButton(iconeSuivante);
		suivant.setSize(new Dimension(200, 25));
		suivant.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				jeu.enleverQuestionListe(question);
				if(jeu.nbVieRestante()<0){
					DutOManiaWindow.ecrantFinJeuSurvie.setTexteFinal();
					DutOManiaWindow.cont.remove(DutOManiaWindow.ecranJeuSurvie);
					DutOManiaWindow.cont.add(DutOManiaWindow.ecrantFinJeuSurvie);
					DutOManiaWindow.cont.validate();
					DutOManiaWindow.cont.repaint();
				}else{
					try {
						question = jeu.chargerQuestion();
						chargerInterfaceReponse();
						resetBoutons();	
					} catch (Exception e) {
						System.out.println("Pas encore assez de question pour finir");
					}
				}



				repaint();

			}
		});

		suivant.setLocation(new Point(300,540));
		suivant.setVisible(false);

		boutonQuitter  = new JButton(iconeQuitter);
		boutonQuitter.setSize(new Dimension(150, 25));
		boutonQuitter.setLocation(new Point(550,10));
		boutonQuitter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				DutOManiaWindow.cont.remove(DutOManiaWindow.ecranJeuSurvie);
				DutOManiaWindow.cont.add(DutOManiaWindow.menuPrincipal);
				DutOManiaWindow.cont.validate();
				DutOManiaWindow.cont.repaint();
				DutOManiaWindow.ecranJeuSurvie = new SurvieGamePanel();

			}
		});

		//chargement de l'interface
		


		// Creation du panel
		resetBoutons();
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
		add(vies);



		chargerInterfaceReponse();

	}

	public void resetBoutons(){
		reponse1.setEnabled(true);
		reponse2.setEnabled(true);
		reponse3.setEnabled(true);
		reponse4.setEnabled(true);

		reponse1.setBackground(Color.LIGHT_GRAY);
		reponse2.setBackground(Color.LIGHT_GRAY);
		reponse3.setBackground(Color.LIGHT_GRAY);
		reponse4.setBackground(Color.LIGHT_GRAY);

		suivant.setVisible(false);

	}


	public void chargerInterfaceReponse(){
		
		survieScore.setText("Score : "+jeu.getScore().getScore());
		vies.setText("Vies : "+jeu.getScore().getNbVies());
		reponse1.setText(question.getProposition(1));
		reponse2.setText(question.getProposition(2));
		reponse3.setText(question.getProposition(3));
		reponse4.setText(question.getProposition(4));
		questionTexte.setText(question.getIntituleQuestion());
		questionTexte.setForeground(Color.WHITE);
		chargerImageTheme();
		
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
				if (boutonQuitter == null)
				{
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
							DutOManiaWindow.cont.repaint();
						}
					});

				}
				boutonClique.revalidate();
				survieScore.setText("Score : "+jeu.getScore().getScore());
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


		}

	}


	public void miseAJourVies() {
		vies.setText("Vies : "+jeu.getScore().getNbVies());

	}

	public JLabel getSurvieScore() {
		return survieScore;
	}

	public void setSurvieScore(JLabel survieScore) {
		this.survieScore = survieScore;
	}

	public JeuSurvie getJeu() {
		return jeu;
	}

	public void chargerImageTheme() {

		switch(question.getTheme()){
		case "Algorithmique et programmation":
			urltheme = "JeuImages/ThemeProg.png";
			break;
		case "Outils et modèles du génie logiciel" :
			urltheme = "JeuImages/ThemeOMGL.png";
			break;
		case "Architecture des systèmes et réseaux" :
			urltheme = "JeuImages/ThemeReseau.png";
			break;
		case "Culture geek":
			urltheme = "JeuImages/ThemeGeek.png";
			break;
		case "Anglais" :
			urltheme = "JeuImages/ThemeAnglais.png";
			break;
		case "Mathématiques" :
			urltheme = "JeuImages/ThemeMath.png";
			break;
		case "Projets" :
			urltheme = "JeuImages/ThemeProjet.png";
			break;
		case "Base de données" :
			urltheme = "JeuImages/ThemeBDD.png";
			break;
		case "Vie étudiante" :
			urltheme = "JeuImages/ThemeVieEtu.png";
			break;
		case "Économie et gestion des organisations" :
			urltheme = "JeuImages/ThemeEco.png";
			break;
		}
		try {
			theme = ImageIO.read(getClass().getClassLoader().getResource(urltheme));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(this.bg, 0, 0, 794, 572, this);
		g.drawImage(this.theme, 0, 45, 794, 254, this);
	}

}
