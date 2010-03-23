package example;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class KeyListen implements KeyListener{
	public static int keycode;

	public void keyTyped ( KeyEvent e ){}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		keycode=e.getKeyCode();
	    System.out.println(keycode);
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		keycode=0;
	}  

}
