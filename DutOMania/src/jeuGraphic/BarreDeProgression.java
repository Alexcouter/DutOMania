package jeuGraphic;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class BarreDeProgression extends JComponent{
	private Rectangle tabRectangles[];
	private final int POSX_DEFAULT = 70;
	private final int POSY_DEFAULT = 6;

	public BarreDeProgression() {
		tabRectangles = new Rectangle[20];

		int decalX = 0;
		for (int i = 0; i < 20; i++) {
			tabRectangles[i] = new Rectangle(i);
			tabRectangles[i].setX(POSX_DEFAULT + decalX);
			tabRectangles[i].setY(POSY_DEFAULT);
			decalX = decalX + tabRectangles[i].getLON_DEFAULT();
			
		}
		setBounds(POSX_DEFAULT, POSY_DEFAULT, 500, 300);
		this.nouvelleQuestion(0);
		
	}
	
	public void bonneReponse(int id) {
		tabRectangles[id].setColor(Color.GREEN);
	}

	public void mauvaiseReponse(int id) {
		tabRectangles[id].setColor(Color.RED);
	}
	
	public void nouvelleQuestion(int id){
		if(id < 20)
			tabRectangles[id].setColor(Color.GRAY);
	}
	
	public void dessiner(Graphics g){
		for(int i = 0; i < 20; i++){
			tabRectangles[i].dessiner(g);
		}
	}
	
	public void paintComponent(Graphics g){
		this.dessiner(g);
	}
}
