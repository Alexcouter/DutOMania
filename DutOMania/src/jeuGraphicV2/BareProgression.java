package jeuGraphicV2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class BareProgression extends JFrame{

	public BareProgression(){
		super("Test bare progession");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);
		setVisible(true);

	}

	public void paint(Graphics g){

		for (int i=1;i <= 20;i++){
			//			Rectangle  = new Rectangle(i);

		}

	}

	public class Rectangle{
		private int id;
		private int lon;
		private int larg;
		private Color c;

		public Rectangle(int id) {
			super();
			this.id = id;
			this.lon = 50;
			this.larg = 25;
			this.c = Color.darkGray;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getLon() {
			return lon;
		}

		public void setLon(int lon) {
			this.lon = lon;
		}

		public int getLarg() {
			return larg;
		}

		public void setLarg(int larg) {
			this.larg = larg;
		}

		public Color getC() {
			return c;
		}

		public void setC(Color c) {
			this.c = c;
		}

	}


	public static void main(String[] args) {
		new BareProgression();

	}

}
