package jeuGraphic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EndSurviePanel extends JPanel{
	private JLabel texteFinal;
	private JLabel scoreFinal;
	private JButton retour;
	private Image bg;

	public EndSurviePanel(){
		
		try
		{
			this.bg = ImageIO.read(getClass().getClassLoader().getResource("JeuImages/FindepartieSurvie.jpg"));

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		Font f = new Font("Trackmania", Font.PLAIN, 50);
		texteFinal = new JLabel();
		texteFinal.setBounds(175, -125, 800, 600);
		texteFinal.setFont(f);
		
		scoreFinal = new JLabel();
		scoreFinal.setBounds(375, 25 , 250, 600);
		scoreFinal.setFont(f);
		scoreFinal.setForeground(Color.white);


		retour = new JButton("Menu Principal");
		retour.setBounds(600, 500, 150, 25);
		retour.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				DutOManiaWindow.cont.remove(DutOManiaWindow.ecrantFinJeuSurvie);
				DutOManiaWindow.cont.add(DutOManiaWindow.menuPrincipal);
				DutOManiaWindow.cont.validate();
				DutOManiaWindow.cont.repaint();
				DutOManiaWindow.ecranJeuSurvie = new SurvieGamePanel();

			}
		});

		setLayout(null);

		add(texteFinal);
		add(scoreFinal);
		add(retour);

		setVisible(true);


	}
	public void setTexteFinal(){
		int scoreDuJeu = DutOManiaWindow.ecranJeuSurvie.getJeu().getScore().getScore();
		texteFinal.setText("<html><center>Fin de la partie<br>Votre score est de : ");
		scoreFinal.setText("<html><center>"+scoreDuJeu+"</center></html>");
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(this.bg, 0, 0, 794, 572, this);
	}
}
