package jeuGraphic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import JeuCode.ScoreNormal;
import JeuImages.MainDut;

public class EndNormalPanel extends JLabel {
	private JLabel texteFinal;
	private JButton retour;
	private JLabel commNote;
	private JLabel scoreFinal;
	private Image bg;

	public EndNormalPanel() {
		
		try
		{
			this.bg = ImageIO.read(getClass().getClassLoader().getResource("JeuImages/Findepartie.jpg"));

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		Font f = new Font("Trackmania", Font.PLAIN, 50);
		
		texteFinal = new JLabel();
		texteFinal.setBounds(175, -150, 800, 600);
		texteFinal.setFont(f);
		
		
		scoreFinal = new JLabel();
		scoreFinal.setBounds(350, -25 , 200, 600);
		scoreFinal.setFont(f);
		scoreFinal.setForeground(Color.white);
		
		commNote = new JLabel();
		commNote.setBounds(100, 300, 800, 200);
		commNote.setFont(f);
		

		retour = new JButton("Menu Principal");
		retour.setBounds(600, 500, 150, 25);
		retour.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				DutOManiaWindow.cont.remove(DutOManiaWindow.ecrantFinJeuNormal);
				DutOManiaWindow.cont.add(DutOManiaWindow.menuPrincipal);
				DutOManiaWindow.cont.validate();
				DutOManiaWindow.cont.repaint();
				DutOManiaWindow.ecranJeuNormal = new NormalGamePanel();

			}
		});

		setLayout(null);

		add(texteFinal);
		add(commNote);
		add(retour);
		add(scoreFinal);

		setVisible(true);

	}
	public void setTexteFinal(){
		int scoreDuJeu = DutOManiaWindow.ecranJeuNormal.getJeu().getScore().getScore();
		texteFinal.setText("<html><center>Fin de la partie<br>Votre score est de : </center></html>");
		scoreFinal.setText("<html><center>"+scoreDuJeu+"/20</center></html>");
		
		if(scoreDuJeu < 10){
			commNote.setText("<html><center>C'était presque pas trop mal<br>mais rejoue encore !!</center></html>");
		}else if(scoreDuJeu >= 10 && scoreDuJeu < 15){
			commNote.setText("<html><center>Ouai pas mal<br>mais encore a perfectionner !</center></html>");
		}
		else{
			commNote.setText("<html><center>Bien tu a eu ton DUT<br>Bien jouer !!</center></html>");
		}
		
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(this.bg, 0, 0, 794, 572, this);
	}
	

}