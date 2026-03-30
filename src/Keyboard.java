package inputs;
import utilsss.constant;
import utilsss.constant.direc.*; 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.Panel;
import Main.Game;
public class Keyboard implements KeyListener{
	
	private Panel panel;
	public Keyboard(Panel panel) {
		this.panel=panel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}


	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_A:
			panel.setdirec(constant.direc.left);
			panel.repaint();
			break;
		case KeyEvent.VK_S:
			panel.setdirec(constant.direc.down);
			panel.repaint();
			System.out.println("S");
			break;
		case KeyEvent.VK_W:
			panel.setdirec(constant.direc.up);
			panel.repaint();
			System.out.println("W");
			break;
		case KeyEvent.VK_D:
			panel.setdirec(constant.direc.right);
			panel.repaint();
			System.out.println("D");
			break;
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_A:
		case KeyEvent.VK_S:			
		case KeyEvent.VK_W:			
		case KeyEvent.VK_D:
			panel.setmoving(false);
			
		}
		
		
	}

}
 