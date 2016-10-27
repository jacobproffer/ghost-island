//Name: Jacob Proffer
//Time Invested: 7 hours
//References: None
//Note: Notice a flicker the first time that I move the ghost left/right. Any idea?

import java.awt.*;
import java.applet.*; 

public class Ghost {
	private int x;
	private int y;
	private int ghostState = 2;
	
	Image ghost; //reference to the image to draw on the screen
	Image ghostB;
	Image ghostL;
	Image ghostR;
	Applet mainApplet; //reference to the main applet.
	
	public Ghost(int xCord, int yCord, Applet a) {
		x = xCord;
		y = yCord;
		mainApplet = a; //copy in a reference to the main applet.
		ghost = mainApplet.getImage(mainApplet.getCodeBase(), "images/ghost.png");
		ghostL = mainApplet.getImage(mainApplet.getCodeBase(), "images/ghost-left.png");
		ghostR = mainApplet.getImage(mainApplet.getCodeBase(), "images/ghost-right.png");
		ghostB = mainApplet.getImage(mainApplet.getCodeBase(), "images/ghost-back.png");
	}
	
	public void floatUp() {
		ghostState = 0;
		y -= 10;
		if (y <= 250) {
			y = 250;
		}
	}
	
	public void floatRight() {
		ghostState = 1;
		x += 10;
		if (x >= 538) {
			x = 538;
		}
	}
	
	public void floatDown() {
		ghostState = 2;
		y += 10;
		if (y >= 260) {
			y = 260;
		}
	}
	
	public void floatLeft() {
		ghostState = 3;
		x -= 10;
		if (x <= 233) {
			x = 233;
		}
	}
	
	public void paint(Graphics g) {
		if (ghostState == 0) {
			g.drawImage(ghostB, x, y, mainApplet);
		}
		else if (ghostState == 1) {
			g.drawImage(ghostR, x, y, mainApplet);
		}
		else if (ghostState == 2) {
			g.drawImage(ghost, x, y, mainApplet);
		}
		else if (ghostState == 3) {
			g.drawImage(ghostL, x, y, mainApplet);
		}
	}
}