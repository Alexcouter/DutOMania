package jeuGraphic;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;


public class FenetreMain extends FenetreBase implements ActionListener {
	  private JPanel panelMain = null;
	  private JButton boutonNormal = null;
	  private JButton boutonSurvie = null;
	  private JButton bouton4J = null;
	  private JLabel information = null;
	  
	  
	 public FenetreMain(){
			super("Écran d'accueil",800,600);
			validate();
	 }
	  
	 private JButton getBoutonNormal()
	  {
	    if (this.boutonNormal == null)
	    {
	      this.boutonNormal = new JButton();
	      this.boutonNormal.setPreferredSize(new Dimension(87, 26));
	      this.boutonNormal.setSize(new Dimension(331, 61));
	      this.boutonNormal.setText("Normal");
	      this.boutonNormal.setLocation(new Point(30, 170));
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
	      this.boutonSurvie.setBounds(30, 250, 331, 61);
	      this.boutonSurvie.setText("Survie");
	      this.boutonSurvie.addActionListener(this);
	    }
	    return this.boutonSurvie;
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
