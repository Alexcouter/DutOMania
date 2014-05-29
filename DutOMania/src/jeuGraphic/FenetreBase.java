package jeuGraphic;

import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class FenetreBase extends JFrame {
	 public FenetreBase(String title) {
//	    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/LogoAplacer.ici")));
	    setVisible(true);
	    setSize(800, 600);
	    setLayout(new FlowLayout(1));
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setTitle("Dut'O'Mania | "+ title);
	    setResizable(false);
	  }
}
