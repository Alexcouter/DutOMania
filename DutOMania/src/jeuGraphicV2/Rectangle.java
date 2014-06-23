package jeuGraphicV2;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle {
	private int lon;
	private int larg;
	private final int LON_DEFAULT = 20;
	private final int LARG_DEFAULT = 20;
	private int x;
	private int y;
	private Color color;
	private final Color COLOR_DEFAULT = Color.WHITE;

	public Rectangle(int id) {
		super();
		this.lon = LON_DEFAULT;
		this.larg = LARG_DEFAULT;
		this.color = COLOR_DEFAULT;
		this.x = 0;
		this.y = 0;
	}
	
	public void dessiner(Graphics g){
		g.setColor(this.getColor());
		g.fillRect(getX(), getY(), getLon(), getLarg());
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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

	public int getLON_DEFAULT() {
		return LON_DEFAULT;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color c) {
		this.color = c;
	}
}
