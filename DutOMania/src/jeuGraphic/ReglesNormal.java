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

public class ReglesNormal extends JPanel {
	private JLabel regle;
	private Image bg;
	private JButton retour;

	public ReglesNormal() {
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
		regle.setText("<html><center>Dans ce mode, vous avez une s�rie de 20 question auquel il vous faut r�pondre. Pour vous aider Vous avez le droit � deux jokers dans la partie : Le 42 qui vous donne la r�ponse � la question et un joker MoitMoit qui enl�ve deux mauvaises r�ponses.</center></html>");
		
		retour = new JButton(iconeRetour);
		retour.setLocation(new Point(350, 500));
		retour.setSize(new Dimension(100, 40));
		retour.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				DutOManiaWindow.cont.remove(DutOManiaWindow.ecranRegleNormal);
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
