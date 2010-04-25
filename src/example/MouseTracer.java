package example;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseTracer implements MouseListener{
	
	private MapOne mapone;
	private CharSelection cs1;

	public MouseTracer(MapOne mapone, CharSelection cs1){
		this.mapone=mapone;
		this.cs1=cs1;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
			for(int i=0;i<mapone.squares.size();i++){
				if(mapone.squares.elementAt(i).isInside(arg0.getX(), arg0.getY())){
					if(mapone.squares.elementAt(i).getPoint().x+19>arg0.getX() && mapone.squares.elementAt(i).getPoint().y+19>arg0.getY()){
						//System.out.println("square at:"+mapone.squares.elementAt(i).getPoint()+" click at:"+arg0.getX()+" "+arg0.getY());
						if(cs1.ARCHER){
							
						}
					}
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
