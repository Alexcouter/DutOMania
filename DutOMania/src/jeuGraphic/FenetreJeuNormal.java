package jeuGraphic;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetreJeuNormal extends FenetreBase implements ActionListener {
	private JPanel panelNormal = null;
	private JLabel normalTexteTop = null;
	private JLabel normalScore = null;
	private JLabel questionNumero = null;
	private JButton boutonQuitter = null;

	public FenetreJeuNormal() {
		super("Mode normal");
		setContentPane(getPanelSurvie());
		validate();	
	}		

	private JPanel getPanelSurvie() {
		if (this.panelNormal == null)
		{  	
			//creation du panel


			//texte en haut ‡ gauche
			this.normalTexteTop = new JLabel();

			//setBounds(x,y,width,height)

			this.normalTexteTop.setBounds(0, 0, 100, 40);

			this.normalTexteTop.setText("- Mode Normal -");
			//Position du texte
			this.normalTexteTop.setLocation(new Point(10,0));
			this.panelNormal = new JPanel();
			this.panelNormal.setLayout(null);

			//Ajout des boutons via des methodes de cr√©ation 
			this.panelNormal.add(this.normalTexteTop);
			this.panelNormal.add(getBoutonQuitter());
			this.panelNormal.add(getScore());
			this.panelNormal.add(getQuestionNumero());

		}
		return this.panelNormal;
	}

	private JLabel getQuestionNumero() {
		this.questionNumero = new JLabel();
		this.questionNumero.setHorizontalAlignment(0);
		this.questionNumero.setBounds(0, 0, 330, 40);
		this.questionNumero.setLocation(new Point(240,300));
		this.questionNumero.setText("Question n∞"/*+ numeroquestion*/ );
		return this.questionNumero;
	}

	private JLabel getScore() {
		this.normalScore = new JLabel();
		this.normalScore.setBounds(0, 0, 100, 40);
		this.normalScore.setLocation(new Point(710,0));
		this.normalScore.setText("Score : "/* + Score.recupererScore*/ );
		return this.normalScore;
	}

	private JButton getBoutonQuitter()
	{
		if (this.boutonQuitter == null)
		{
			this.boutonQuitter  = new JButton();
			this.boutonQuitter.setSize(new Dimension(150, 25));
			this.boutonQuitter.setText("Quitter la partie");
			this.boutonQuitter.setLocation(new Point(550,10));
			this.boutonQuitter.addActionListener(this);
			getRootPane().setDefaultButton(this.boutonQuitter);
		}
		return this.boutonQuitter;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.boutonQuitter){
			new panelMain();
			dispose();
		}
	}


}
