//Name: Jacob Proffer
//Time Invested: 7 hours
//References:
// [1] http://ericskiff.com/music/
// [2] http://euclid.nmu.edu/~mkowalcz/cs120/labs/18/

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class HauntedHouse extends Applet implements MouseListener, KeyListener {
	private Ghost spooky;
	private int day;
	private int cloudXCord = 174;
	Image island;
	Image house;
	Image houseNight;
	Image clouds;
	AudioClip song;

	public void init() {
		spooky = new Ghost(250, 250, this);
		clouds = getImage(getCodeBase(), "images/clouds.png");
		island = getImage(getCodeBase(), "images/island.png");
		house = getImage(getCodeBase(), "images/house.png");
		houseNight = getImage(getCodeBase(), "images/house-night.png");
		song = getAudioClip(getCodeBase(), "sound/main-sound.wav"); //Downloaded from [1]
		song.loop(); //Loops main-sound.wav
		addMouseListener(this); //registers the applet to receive mouse events
		addKeyListener(this); //registers the applet to receive key events
	}
	
	public void paint(Graphics g) {
		Image buffer = createImage(getSize().width, getSize().height); //Copied from [2]
		Graphics h = buffer.getGraphics(); //Copied from [2]
		if (day == 0) {
			h.setColor(new Color(239, 226, 145)); //Day background color (#CABBDB)
			h.fillRect(0, 0, 10000, 10000); //Day background rectangle
			h.drawImage(clouds, cloudXCord, 150, this); //Clouds image
			h.drawImage(house, 328, 205, this); //Day house image
		}
		else if (day == 1) {
			h.setColor(new Color(30, 32, 35)); //Night background color (#000000)
			h.fillRect(0, 0, 10000, 10000); //Night background rectangle
			h.drawImage(clouds, cloudXCord, 150, this); //Clouds image
			h.drawImage(houseNight, 328, 205, this); //Day house image
		}
		h.drawImage(island, 223, 136, this); //Island image
		spooky.paint(h); //Ghost image
		g.drawImage(buffer, 0, 0, this); //Copied from [2]
	}
	
	public void update(Graphics g) { //Copied from [2]
    	paint(g);
	}
	
	public void mousePressed(MouseEvent e) {
		if (e.getX() < 400) {
			cloudXCord = cloudXCord - 10;
		}
		else {
			cloudXCord = cloudXCord + 10;
		}
		repaint();
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_N) {
			if (day == 0) {
				day = 1;
				repaint();
			}
			else {
				day = 0;
				repaint();
			}
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			spooky.floatLeft();
			repaint();
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			spooky.floatRight();
			repaint();
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			spooky.floatUp();
			repaint();
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			spooky.floatDown();
			repaint();
		}
	}
	
	public void keyReleased(KeyEvent e) {
	}
	
	public void keyTyped(KeyEvent e) {
	}
	
}