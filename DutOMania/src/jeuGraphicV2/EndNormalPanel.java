package jeuGraphicV2;

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

public class EndNormalPanel extends JLabel{
	private JLabel texteFinal;
	private JButton retour;
	


	public EndNormalPanel(){

		texteFinal = new JLabel("Fin de la partie\nVotre score est de : "+ DutOManiaWindow.ecranJeuNormal.getJeu().getScore().getScore()+"/"+DutOManiaWindow.ecranJeuNormal.getJeu().totalScore());
		texteFinal.setBounds(225, 250, 500, 100);
		Font f = new Font("Trackmania", Font.PLAIN, 50);
		texteFinal.setFont(f);
		
		retour = new JButton("Menu Principal");
		retour.setBounds(500, 325, 100, 50);
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

		setVisible(true);

	}



	
}