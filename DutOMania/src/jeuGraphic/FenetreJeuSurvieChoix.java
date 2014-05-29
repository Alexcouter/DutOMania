package jeuGraphic;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FenetreJeuSurvieChoix extends FenetreBase implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelChoix = null;
	private JLabel survieChoixTxt = null;
	private JButton boutonFacile = null;
	private JButton boutonNormal = null;
	private JButton boutonDifficile = null;
	private JButton boutonRetour = null;

	public FenetreJeuSurvieChoix(){

		super("Survie - Selection de la difficulte");
		setContentPane(getPanelChoixSurvie());
		validate();
	}

	private JPanel getPanelChoixSurvie() {
		if (this.panelChoix == null)
		{  	
			this.survieChoixTxt = new JLabel();
			this.survieChoixTxt.setBounds(30, 125, 330, 40);
			this.survieChoixTxt.setHorizontalTextPosition(0);
			this.survieChoixTxt.setHorizontalAlignment(0);
			this.survieChoixTxt.setText("Mode Survie :");
			this.survieChoixTxt.setLocation(new Point(240,100));
			this.panelChoix = new JPanel();
			this.panelChoix.setLayout(null);
			this.panelChoix.add(getBoutonFacile());
			this.panelChoix.add(getBoutonNormal());
			this.panelChoix.add(getBoutonDifficile());
			this.panelChoix.add(getBoutonRetour());

			this.panelChoix.add(this.survieChoixTxt);

		}
		return this.panelChoix;
	}

	private JButton getBoutonFacile()
	{
		if (this.boutonFacile == null)
		{
			this.boutonFacile = new JButton();
			this.boutonFacile.setSize(new Dimension(320, 60));
			this.boutonFacile.setText("Facile");
			this.boutonFacile.setLocation(new Point(240,200));
			this.boutonFacile.addActionListener(this);
			getRootPane().setDefaultButton(this.boutonFacile);
		}
		return this.boutonFacile;
	}

	private JButton getBoutonNormal()
	{
		if (this.boutonNormal == null)
		{
			this.boutonNormal = new JButton();
			this.boutonNormal.setSize(new Dimension(320, 60));
			this.boutonNormal.setText("Normale");
			this.boutonNormal.setLocation(new Point(240,300));
			this.boutonNormal.addActionListener(this);
			getRootPane().setDefaultButton(this.boutonNormal);
		}
		return this.boutonNormal;
	}

	private JButton getBoutonDifficile()
	{
		if (this.boutonDifficile == null)
		{
			this.boutonDifficile = new JButton();
			this.boutonDifficile.setSize(new Dimension(320, 60));
			this.boutonDifficile.setText("Difficile");
			this.boutonDifficile.setLocation(new Point(240,400));
			this.boutonDifficile.addActionListener(this);
			getRootPane().setDefaultButton(this.boutonDifficile);
		}
		return this.boutonDifficile;
	}

	private JButton getBoutonRetour()
	{
		if (this.boutonRetour == null)
		{
			this.boutonRetour = new JButton();
			this.boutonRetour.setSize(new Dimension(100, 40));
			this.boutonRetour.setText("Retour");
			this.boutonRetour.setLocation(new Point(50,500));
			this.boutonRetour.addActionListener(this);
			getRootPane().setDefaultButton(this.boutonRetour);
		}
		return this.boutonRetour;
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		int bouton = 0;
			if (arg0.getSource() == this.boutonFacile) 
				bouton = 1;			
				else if (arg0.getSource() == this.boutonNormal) {
					bouton = 2;
				} else if (arg0.getSource() == this.boutonDifficile) {
					bouton = 3;
				}
				else if(arg0.getSource() == this.boutonRetour){
					bouton = 4;
				}
			if(bouton == 1 || bouton == 2 || bouton == 3){
		new FenetreJeuSurvie(bouton);
			}
			if(bouton == 4){
				new panelMain();
			}
		dispose();

	}
}
