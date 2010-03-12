package example;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class MouseListen extends MouseAdapter{

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e);
	}


}
