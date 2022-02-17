package Igra;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Lopar {
	private final int Y = 330;
	private final int SIRINA = 60;
	private final int VISINA = 20;
	
	
	private int x = 0;
	private int xPremik = 0;
	
	private Igra igra;
	
	public Lopar(Igra igra) {
		this.igra = igra;
	}
	
	
	
	public void narisi(Graphics2D g2d) {
		g2d.fillRect(this.x, Y, SIRINA, VISINA);
	}


	public void nastaviPremikanje(int smerPremikanja) {
		this.xPremik = smerPremikanja;
		
	}
	// da mejo premikanja loparju
	public void premakni() {
		if(this.x + xPremik >= 0 && this.x + xPremik <= igra.getWidth() - SIRINA) {
			this.x += xPremik;
		}
	}

	
	public void ustaviPremikanje() {
		this.xPremik = 0;
	}

	public Rectangle getMejeLoparja() {
		return new Rectangle(this.x, Y, SIRINA, VISINA);
	}
}
