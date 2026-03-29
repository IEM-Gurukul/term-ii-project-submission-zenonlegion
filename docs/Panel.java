package Main;
import utilsss.constant.direc.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import inputs.Keyboard;

import utilsss.constant;

import static utilsss.constant.playerconst.*;
import static utilsss.constant.direc.*;


public class Panel extends JPanel{
	
	private float xdel=100,ydel=100;
	
	private BufferedImage img;
	private BufferedImage[][] anims;
	private int animtick,animindex,animspeed=2;
	private int action=idle;
	private int dir=-1;
	private boolean moving =false;
	public Panel() {
		
		
		
		importimg();
		loadanimations();
		setPanelSize();
		addKeyListener(new Keyboard(this));
		
	}
	
	private void loadanimations() {
		anims = new BufferedImage[8][7];
		for(int j=0; j <anims.length; j++) {
			for(int i=0; i<anims[j].length; i++) {
				anims[j][i]=img.getSubimage(i*64,j*64,64, 64);
			}
		}
	}

	private void importimg() {
		InputStream is=getClass().getResourceAsStream("/Main/DarkSamurai.png");
		try {
			img=ImageIO.read(is);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	private void setPanelSize() {
		Dimension size=new Dimension(1280,800);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
		
	}

	public void setdirec(int direction) {
		this.dir=direction;
		moving=true;
	}
	
	public void setmoving(boolean moving) {
		this.moving=moving;
	}
	
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		updateAnim();
		setanimation();
		updatepos();
		g.drawImage(anims[action][animindex], (int)xdel, (int)ydel,256,240, null);
	}

	private void updatepos() {
		if(moving) {
			switch(dir) {
			case constant.direc.left:
				xdel-=10;
				break;
			case constant.direc.right:
				xdel+=10;
				break;
			case constant.direc.up:
				ydel-=10;
				break;
			case constant.direc.down:
				ydel+=10;
				break;
			}
		}
		
	}

	private void setanimation() {
		if(moving)
			action=run;
		else
			action=idle;
		
	}

	private void updateAnim() {
		animtick++;
		if(animtick >= animspeed) {
			animtick=0;
			animindex++;
			if(animindex >= anims[action].length)
				animindex=0;
		}
		
	}

	
}
