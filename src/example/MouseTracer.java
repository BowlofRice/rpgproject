package example;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

public class MouseTracer implements MouseListener{
	public Vector<Ally> allies=new Vector<Ally>();
	private MapOne mapone;
	private CharSelection cs1;
	public int arrayLocationX=0;
	public int arrayLocationY=0;
	private Screen1 screenone;

	public MouseTracer(MapOne mapone, CharSelection cs1, Screen1 screenone){
		this.mapone=mapone;
		this.cs1=cs1;
		this.screenone=screenone;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
			for(int i=0;i<mapone.squares.size();i++){
				if(mapone.squares.elementAt(i).isInside(arg0.getX(), arg0.getY())){
					if(mapone.squares.elementAt(i).getPoint().x+19>arg0.getX() && mapone.squares.elementAt(i).getPoint().y+19>arg0.getY()){
						//System.out.println("square at:"+mapone.squares.elementAt(i).getPoint()+" click at:"+arg0.getX()+" "+arg0.getY());
						if(cs1.ARCHER){
							Archer archer=new Archer(mapone.squares.elementAt(i).getPoint().x,mapone.squares.elementAt(i).getPoint().y);
							allies.add(archer);
							System.out.println("we're in");
							archer.drawUnit(screenone.getGraphics());
							//screenone.paint(screenone.getGraphics());
							cs1.ARCHER=false;
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
