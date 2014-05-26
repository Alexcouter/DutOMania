package jeu;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class FenetreBase extends JFrame {
	 public FenetreBase(String title, int x, int y) {
//	    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/LogoAplacer.ici")));
	    setVisible(true);
	    setSize(x, y);
	    setLayout(new FlowLayout(1));
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setTitle("Dut'O'Mania | "+ title);
	    setResizable(false);
	  }
}
