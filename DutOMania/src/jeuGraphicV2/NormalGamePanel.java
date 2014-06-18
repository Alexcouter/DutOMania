package jeuGraphicV2;

import java.awt.Point;

import javax.swing.*;

public class NormalGamePanel extends JPanel {
	private JPanel panelNormal = null;
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
	
	public NormalGamePanel(){
		normalTexteTop = new JLabel();

		//setBounds(x,y,width,height)

		normalTexteTop.setBounds(0, 0, 100, 40);

		normalTexteTop.setText("- Mode Normal -");
		
		//Position du texte
		normalTexteTop.setLocation(new Point(10,0));
		questionTexte = new JLabel("Question");
		questionTexte.setBounds(0, 0, 330, 40);
		questionTexte.setLocation(new Point(230,320));
		
	}
}
