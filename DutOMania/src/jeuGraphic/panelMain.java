package jeuGraphic;

import java.awt.Dimension;
import java.awt.FlowLayout;
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
import JeuImages.MainDut;


public class panelMain extends FenetreBase implements ActionListener {
	private JPanel panelMain = null;
	private JButton boutonNormal = null;
	private JButton boutonSurvie = null;
	private JButton boutonQuitter = null;


	public panelMain(){
		super("Ecran d'accueil");
		setContentPane(getPanelPrincipal());
		validate();
	}

	private JPanel getPanelPrincipal()
	{
		if (this.panelMain == null)
		{
			MainDut bg = new MainDut();
			bg.setBounds(0, 0, 800, 600);
			this.panelMain = new JPanel();
			this.panelMain.setLayout(null);
			this.panelMain.add(getBoutonNormal());
			this.panelMain.add(getBoutonSurvie());
			this.panelMain.add(getBoutonQuitter());
			this.panelMain.add(bg);
		}
		return this.panelMain;
	}

	private JButton getBoutonNormal()
	{
		if (this.boutonNormal == null)
		{
			this.boutonNormal = new JButton();
			this.boutonNormal.setSize(new Dimension(320, 60));
			this.boutonNormal.setText("Normal");
			this.boutonNormal.setLocation(new Point(240,300));
			this.boutonNormal.addActionListener(this);
			getRootPane().setDefaultButton(this.boutonNormal);
		}
		return this.boutonNormal;
	}

	private JButton getBoutonSurvie()
	{
		if (this.boutonSurvie == null)
		{
			this.boutonSurvie = new JButton();
			this.boutonSurvie.setSize(new Dimension(320, 60));
			this.boutonSurvie.setLocation(new Point(240,400));
			this.boutonSurvie.setText("Survie");
			this.boutonSurvie.addActionListener(this);
		}
		return this.boutonSurvie;
	}

	private JButton getBoutonQuitter()
	{
		if (this.boutonQuitter == null)
		{
			this.boutonQuitter = new JButton();
			this.boutonQuitter.setSize(new Dimension(320, 60));
			this.boutonQuitter.setLocation(new Point(240,500));
			this.boutonQuitter.setText("Quitter le jeu");
			this.boutonQuitter.addActionListener(this);
		}
		return this.boutonQuitter;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		int bouton = 0;
		if (arg0.getSource() == this.boutonNormal) {
			bouton = 1;
		} else if (arg0.getSource() == this.boutonSurvie) {
			bouton = 2;
		}
		new FenetreJeu(bouton);
		dispose();
	}	



}
