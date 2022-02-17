package Igra;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Zoga {
	private final int PREMER = 30;
	private int x = 0;
	private int y = 0;
	private Igra igra;
	private int yPremik = 1;
	private int xPremik = 1;
	
	public Zoga(Igra igra) {
		this.igra = igra;
	}
	// Narise zogo, sprejme objekt kot argument ki ga bomo dali not v mainu
	public void narisi(Graphics2D g2d) {
		g2d.fillOval(x, y, PREMER, PREMER);
	}
	// premakne zogo diagonalno dol
	public void premakni() {
		// ce je zoga prisla do desnega roba okvirja, x se začne zmanjševat kar odbije žogo v levo 
		if(this.x + 1 > igra.getWidth() - PREMER) {
			this.xPremik = -1;	
		}
		// ko zadane spodnji rob okvirja
		if(this.y + 1 > igra.getHeight() - PREMER) {
			igra.KonecIgre();
		}
		// ko zadane levi rob okvirja 
		if (this.x == 0) {
			this.xPremik = 1;
		}
		// ko zadane zgornji rob okvirja
		if (this.y == 0) {
			this.yPremik = 1;
		}
		// ko zadane zoga lopar 
		if (this.trkZLoparjem()) {
			if(yPremik == 1 ) {
				igra.povecajTocke();
			}
			this.yPremik = -1;
		}
		this.x += xPremik; 
		this.y += yPremik;
	}
	
	private Rectangle getMejeZoge() {
		return new Rectangle(this.x, this.y, PREMER, PREMER);
		
	}
	
	private boolean trkZLoparjem() {
		return igra.lopar.getMejeLoparja().intersects(this.getMejeZoge());
	}

}
