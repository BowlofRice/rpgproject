package example;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseTracer implements MouseListener{
	
	private MapOne mapone;

	public MouseTracer(MapOne mapone){
		
		this.mapone=mapone;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

			for(int i=0;i<mapone.squares.size();i++){
				if(mapone.squares.elementAt(i).isInside(arg0.getX(), arg0.getY())){
					if(mapone.squares.elementAt(i).getPoint().x+20>arg0.getX() && mapone.squares.elementAt(i).getPoint().y+20>arg0.getY())
						System.out.println("square at:"+mapone.squares.elementAt(i).getPoint()+" click at:"+arg0.getX()+" "+arg0.getY());
				}
			}

		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
