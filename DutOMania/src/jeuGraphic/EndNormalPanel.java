package jeuGraphic;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import JeuCode.ScoreNormal;

public class EndNormalPanel extends JLabel {
	private JLabel texteFinal;
	private JButton retour;

	public EndNormalPanel() {

		texteFinal = new JLabel();
		
		texteFinal.setBounds(175, -100, 800, 600);
		Font f = new Font("Trackmania", Font.PLAIN, 50);
		texteFinal.setFont(f);
		

		retour = new JButton("Menu Principal");
		retour.setBounds(600, 500, 150, 25);
		retour.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				DutOManiaWindow.cont.remove(DutOManiaWindow.ecrantFinJeuNormal);
				DutOManiaWindow.cont.add(DutOManiaWindow.menuPrincipal);
				DutOManiaWindow.cont.validate();
				DutOManiaWindow.cont.repaint();

			}
		});

		setLayout(null);

		add(texteFinal);
		add(retour);

		setVisible(true);

	}
	public void setTexteFinal(){
		texteFinal.setText("<html><center>Fin de la partie<br>Votre score est de : <br><br>"
				+ DutOManiaWindow.ecranJeuNormal.getJeu().getScore().getScore() + "/20</center></html>");
		
	}

}