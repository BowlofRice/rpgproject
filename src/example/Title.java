package example;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Title extends Canvas {
	Image horse = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/thorse.png");
	public Title() {
		setSize(400, 400);
		//setBackground(Color.DARK_GRAY);
	}
	public void update(Graphics g){
		System.out.println("we update just cuz");
		Image os = createImage(getWidth(), getHeight());
		paint(os.getGraphics());
		g.drawImage(os,0,0,this);
	}
	public void paint(Graphics g) {
		System.out.println("we paint just cuz");
		//g.setColor(Color.ORANGE);
		//g.drawString("Battle for troy", 200, 200);
		g.drawImage(horse, 0, 0, null);
	}
}
