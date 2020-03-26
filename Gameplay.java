import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
	
	private boolean play;
	
	private int delay;
	private Timer timer;
	public MapGenerator mapG1;
	public MapGenerator Nextmap;
	
	public Gameplay() {
		mapG1 = new MapGenerator(28,28);
		int numberAliveCells = 301;
		for(int i = 0; i <= numberAliveCells; i++ ) {
			mapG1.map[getRandom()][getRandom()].setAlive();
		}
		Nextmap = new MapGenerator(28,28);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}

	public void paint(Graphics g) {
		//background
		g.setColor(Color.black);
		g.fillRect(1,1,700,700);
		//g.fillRect(1,1,getFrameHeight(),700);
		
		//drawing map
		mapG1.draw((Graphics2D)g);
		//Nextmap.draw((Graphics2D)g);
		
		
	}
	@Override
	//public void actionPerformed(ActionEvent arg0) {
	public void actionPerformed(ActionEvent e) {
		
		//mapG1.nextGeneration(Nextmap);		
		//repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			mapG1.copyMapInto(Nextmap);
			mapG1.nextGeneration(Nextmap);
			Nextmap.copyMapInto(mapG1);
			repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public int getRandom() {
		Random rand = new Random();
		int random = rand.nextInt(27) +1;
		return random;
	}
}
