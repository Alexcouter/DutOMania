package jeuGraphic;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ReglesSurvie extends JPanel {
	private JLabel regle;
	private Image bg;
	private JButton retour;

	public ReglesSurvie() {
		ImageIcon iconeRetour = new ImageIcon(this.getClass().getResource("/JeuImages/BoutonRetour.jpg"));

		try
		{
			this.bg = ImageIO.read(getClass().getClassLoader().getResource("JeuImages/ReglesFond.jpg"));

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}




		Font f = new Font(null, Font.PLAIN, 25);
		regle = new JLabel();
		regle.setFont(f);
		regle.setBounds(0, 0, 800, 600);
		regle.setText("<html><center>Dans ce mode, vous devez répondre a un aximum de question. Il y a trois niveau de difficulté : En facile, vous débuté avec 5 vies, en normale 3 vies et en difficile seulement une vie. La partie se termine lorsque vous donné une maucaise éponse et que vous n'avez plus de vie.</center></html>");

		retour = new JButton(iconeRetour);
		retour.setLocation(new Point(350, 500));
		retour.setSize(new Dimension(100, 40));
		retour.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				DutOManiaWindow.cont.remove(DutOManiaWindow.ecranRegleSurvie);
				DutOManiaWindow.cont.add(DutOManiaWindow.menuPrincipal);
				DutOManiaWindow.cont.validate();
				DutOManiaWindow.cont.repaint();

			}
		});


		regle.setBackground(null);

		setLayout(null);

		add(retour);
		add(regle);


	}

	public void paintComponent(Graphics g)
	{
		g.drawImage(this.bg, 0, 0, 794, 572, this);
	}


}


