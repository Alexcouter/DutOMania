package jeuGraphicV2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EndSurviePanel extends JPanel{
	private JLabel texteFinal;
	private JButton retour;

	public EndSurviePanel(){

		texteFinal = new JLabel();
		texteFinal.setBounds(175, -100, 800, 600);
		Font f = new Font("Trackmania", Font.PLAIN, 50);
		texteFinal.setFont(f);


		retour = new JButton("Menu Principal");
		retour.setBounds(600, 500, 150, 25);
		retour.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				DutOManiaWindow.cont.remove(DutOManiaWindow.ecrantFinJeuSurvie);
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
				+ DutOManiaWindow.ecranJeuSurvie.getJeu().getScore().getScore() + "</center></html>");
	}
}
