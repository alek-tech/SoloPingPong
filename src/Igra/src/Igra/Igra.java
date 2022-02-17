package Igra;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Igra extends JPanel {
	// nardimo objekt zoga iz klase Zoga
	// new Zoga dodamo this zato da jo lahko spreminjamo iz Zoga klase
	Zoga zoga = new Zoga(this);
	Lopar lopar = new Lopar(this);
	
	private int tocke = 0;
	
	public Igra() {
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					lopar.nastaviPremikanje(1);
				}
				
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				    lopar.nastaviPremikanje(-1);
				}
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT) {
					lopar.ustaviPremikanje();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		setFocusable(true);
	}
	 
	public void paint(Graphics g) {
		super.paint(g);
		// ustvarimo objekt ki ga bomo dali kot argument metodi narisi iz klase Zoga
		Graphics2D g2d = (Graphics2D) g;
		// zaobli robe od zoges
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//izvedemo metodo narisi iz objekta zoga
		zoga.narisi(g2d);
		lopar.narisi(g2d);
		
		g2d.setColor(Color.RED);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(this.tocke), 10, 30);
	}
	
	public void KonecIgre() {
		JOptionPane.showMessageDialog(this, "Konce Igre!");
		System.exit(0);
	}
	
	public void povecajTocke() {
		this.tocke++;
	}

	public static void main(String[] args) {
		//OKVIR
		JFrame okvir = new JFrame("Igra");
		
		Igra igra = new Igra();
		
		okvir.add(igra);
		okvir.setSize(300,400);
		okvir.setVisible(true);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while(true) {
			//premakne zogo
			igra.zoga.premakni();
			igra.lopar.premakni();
			//refresha okno in pokaze novo pozicijo zoge
			igra.repaint();
			//upočasni zogo
			try {
				Thread.sleep(5);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

}
