package jeuGraphic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import JeuCode.Jeu;
import JeuCode.JeuNormal;
import JeuCode.Joker;
import JeuCode.ListeQuestions;
import JeuCode.Question;
import JeuImages.MainDut;

public class NormalGamePanel extends JPanel {
	private Joker moitMoit = new Joker("MoitMoit", true);
	private Joker j42 = new Joker("42", true);
	private JeuNormal jeu = new JeuNormal();
	private JButton b42;
	private JButton bMoitMoit;
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
	private Color couleurDefautBouton;
	private BarreDeProgression barre = new BarreDeProgression();
	private Image bg;
	private Image theme;
	private String urltheme;

	public NormalGamePanel(){
		ImageIcon icon42 = new ImageIcon(this.getClass().getResource("/JeuImages/Bouton42.jpg" ));
		ImageIcon iconeMoitMoit = new ImageIcon(this.getClass().getResource("/JeuImages/BoutonMoitmoit.jpg"));
		ImageIcon iconeQuitter = new ImageIcon(this.getClass().getResource("/JeuImages/BoutonQuitter.jpg"));



		try
		{
			this.bg = ImageIO.read(getClass().getClassLoader().getResource("JeuImages/BgdeBase.jpg"));

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}




		//céation des éléments du panel
		normalTexteTop = new JLabel("- Mode Normal -");
		normalTexteTop.setBounds(0, 0, 100, 40);
		normalTexteTop.setLocation(new Point(10,0));

		questionTexte = new JLabel("Question");
		questionTexte.setBounds(0, 0, 750, 60);
		questionTexte.setLocation(new Point(35,310));
		questionTexte.setHorizontalAlignment(SwingConstants.CENTER);

		b42 = new JButton(icon42);
		b42.setSize(new Dimension(50, 25));
		b42.setLocation(new Point(600, 300));
		b42.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				b42.setEnabled(false);
				questionNumero.setText("Question n°"+compteurQuestion);
				barre.bonneReponse(compteurQuestion-1);
				barre.nouvelleQuestion(compteurQuestion);
				compteurQuestion++;
				j42.joker42();
				revalidate();
				repaint();


			}
		});

		bMoitMoit = new JButton(iconeMoitMoit);
		bMoitMoit.setSize(new Dimension(100, 25));
		bMoitMoit.setLocation(new Point(660, 300));
		bMoitMoit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (moitMoit.isDispo() == true)
					moitMoit.jokerMoitMoit(question, reponse1, reponse2, reponse3, reponse4);
				bMoitMoit.setEnabled(false);
				repaint();
			}
		});


		barre.setBounds(180, 11, 300, 300);

		questionNumero = new JLabel();
		questionNumero.setHorizontalAlignment(0);
		questionNumero.setBounds(0, 0, 330, 40);
		questionNumero.setLocation(new Point(230,300));


		normalScore = new JLabel();
		normalScore.setBounds(0, 0, 100, 40);
		normalScore.setLocation(new Point(710,0));
		


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
				if( compteurQuestion < 20){

					try {
						question = jeu.chargerQuestion();
						chargerInterfaceReponse();
						resetBoutons();	
					} catch (Exception e) {
						System.out.println("Pas encore assez de question pour finir");
					}
				}else{
					DutOManiaWindow.ecrantFinJeuNormal.setTexteFinal();
					DutOManiaWindow.cont.remove(DutOManiaWindow.ecranJeuNormal);
					DutOManiaWindow.cont.add(DutOManiaWindow.ecrantFinJeuNormal);
					DutOManiaWindow.cont.validate();
					DutOManiaWindow.cont.repaint();

				}
				repaint(); 

			}
		});
		suivant.setLocation(new Point(300,540));
		suivant.setVisible(false);

		if (boutonQuitter == null)
		{
			boutonQuitter  = new JButton(iconeQuitter);
			boutonQuitter.setSize(new Dimension(150, 25));
			boutonQuitter.setLocation(new Point(550,10));
			boutonQuitter.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					DutOManiaWindow.cont.remove(DutOManiaWindow.ecranJeuNormal);
					DutOManiaWindow.cont.add(DutOManiaWindow.menuPrincipal);
					DutOManiaWindow.cont.validate();
					DutOManiaWindow.cont.repaint();
					DutOManiaWindow.ecranJeuNormal = new NormalGamePanel();
				}
			});

		}

		//set des l'interface question
		resetBoutons();
		chargerInterfaceReponse();

		// Creation du panel
		setLayout(null);

		//Ajout des éléments au panel

		add(normalTexteTop);
		add(boutonQuitter);
		add(normalScore);
		add(questionNumero);
		add(questionTexte);
		add(reponse1);
		add(reponse2);
		add(reponse3);
		add(reponse4);
		add(suivant);
		add(b42);
		add(bMoitMoit);
		add(barre);

	}

	public void paintComponent(Graphics g)
	{
		g.drawImage(this.bg, 0, 0, 794, 572, this);
		g.drawImage(this.theme, 0, 45, 794, 254, this);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void chargerInterfaceReponse(){



		questionNumero.setText("Question n°"+compteurQuestion);
		questionNumero.setForeground(Color.WHITE);
		questionNumero.setBounds(35,290, 750, 60);
		questionNumero.setHorizontalAlignment(SwingConstants.CENTER);
		normalScore.setText("Score : "+jeu.getScore().getScore());
		reponse1.setText(question.getProposition(1));
		reponse2.setText(question.getProposition(2));
		reponse3.setText(question.getProposition(3));
		reponse4.setText(question.getProposition(4));
		questionTexte.setText(question.getIntituleQuestion());
		questionTexte.setForeground(Color.WHITE);
		chargerImageTheme();
	}

	//Listener des boutons de réponse
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
				System.out.println("vrai"+jeu.getScore().getScore());
				boutonClique.revalidate();
				normalScore.setText("Score : "+jeu.getScore().getScore());
				normalScore.revalidate();
				barre.bonneReponse(compteurQuestion-1);
				barre.nouvelleQuestion(compteurQuestion);
				barre.revalidate();
			}
			else{
				boutonClique.setBackground(Color.RED);
				boutonClique.setContentAreaFilled(false);
				boutonClique.setOpaque(true);
				System.out.println("faux");
				boutonClique.revalidate();	
				barre.mauvaiseReponse(compteurQuestion-1);
				barre.nouvelleQuestion(compteurQuestion);
				barre.revalidate();
			}

			compteurQuestion++;
		}

	}

	public JeuNormal getJeu() {
		return jeu;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}
