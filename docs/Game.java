package Main;

public class Game implements Runnable{
	private static final double FPS_SET = 30;
	private Panel panel;
	private Thread thread;
	public Game() {
		panel = new Panel();
		Window window = new Window(panel);
		panel.requestFocus();
		gamestart();
	}
	private void gamestart() {
		thread=new Thread(this);
		thread.start();
		
	}
	@Override
	public void run() {
		double timeperframe=1000000000.0/FPS_SET;
		long lastframe=System.nanoTime();
		long now=System.nanoTime();
		
		while (true) {
			now=System.nanoTime();
			if(now-lastframe >= timeperframe) {
				panel.repaint();
				lastframe=now;
			}
		}
	
	}
}
