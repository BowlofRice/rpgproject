package example;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MouseTracer2 implements MouseListener{
	public Vector<Ally> allies=new Vector<Ally>();
	public int cost, remainingFunds;
	private MapTwo maptwo;
	private CharSelection2 cs2;
	private Screen2 screentwo;
	private JFrame parent;
	
	public MouseTracer2(MapTwo maptwo, CharSelection2 cs2, Screen2 screentwo, JFrame parent){
		this.maptwo=maptwo;
		this.cs2=cs2;
		this.screentwo=screentwo;
		this.parent=parent;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
			for(int i=0;i<maptwo.squares.size();i++){
				if(maptwo.squares.elementAt(i).isInside(arg0.getX(), arg0.getY())){
					if(maptwo.squares.elementAt(i).getPoint().x+19>arg0.getX() && maptwo.squares.elementAt(i).getPoint().y+19>arg0.getY()){
						if(cs2.ARCHER){
							cost=1000;
							if(maptwo.mapTraversal[maptwo.squares.elementAt(i).getPoint().x/20][maptwo.squares.elementAt(i).getPoint().y/20]==0){
								Archer archer=new Archer(maptwo.squares.elementAt(i).getPoint().x,maptwo.squares.elementAt(i).getPoint().y);
								allies.add(archer);
								remainingFunds=Integer.parseInt(cs2.funds.getText())-cost;
								screentwo.funds=remainingFunds;
								cs2.funds.setText(""+remainingFunds);
								archer.drawUnit(screentwo.getGraphics());
								cs2.ARCHER=false;
							}else
								JOptionPane.showMessageDialog(parent, "Unit cannot be place there");
						}
						if(cs2.FIGHTER){
							cost=1500;
							if(maptwo.mapTraversal[maptwo.squares.elementAt(i).getPoint().x/20][maptwo.squares.elementAt(i).getPoint().y/20]==0){
								Fighter fighter=new Fighter(maptwo.squares.elementAt(i).getPoint().x,maptwo.squares.elementAt(i).getPoint().y);
								allies.add(fighter);
								remainingFunds=Integer.parseInt(cs2.funds.getText())-cost;
								screentwo.funds=remainingFunds;
								cs2.funds.setText(""+remainingFunds);
								fighter.drawUnit(screentwo.getGraphics());
								cs2.FIGHTER=false;
							}else
								JOptionPane.showMessageDialog(parent, "Unit cannot be place there");
						}
						if(cs2.BLUE){
							cost=2000;
							if(maptwo.mapTraversal[maptwo.squares.elementAt(i).getPoint().x/20][maptwo.squares.elementAt(i).getPoint().y/20]==0){
								BlueCaster blue=new BlueCaster(maptwo.squares.elementAt(i).getPoint().x,maptwo.squares.elementAt(i).getPoint().y);
								allies.add(blue);
								remainingFunds=Integer.parseInt(cs2.funds.getText())-cost;
								screentwo.funds=remainingFunds;
								cs2.funds.setText(""+remainingFunds);
								blue.drawUnit(screentwo.getGraphics());
								cs2.BLUE=false;
							}else
								JOptionPane.showMessageDialog(parent, "Unit cannot be place there");
						}
						if(cs2.RED){
							cost=2000;
							if(maptwo.mapTraversal[maptwo.squares.elementAt(i).getPoint().x/20][maptwo.squares.elementAt(i).getPoint().y/20]==0){
								RedCaster red=new RedCaster(maptwo.squares.elementAt(i).getPoint().x,maptwo.squares.elementAt(i).getPoint().y);
								allies.add(red);
								remainingFunds=Integer.parseInt(cs2.funds.getText())-cost;
								screentwo.funds=remainingFunds;
								cs2.funds.setText(""+remainingFunds);
								red.drawUnit(screentwo.getGraphics());
								cs2.RED=false;
							}else
								JOptionPane.showMessageDialog(parent, "Unit cannot be place there");
						}
						if(cs2.GREEN){
							cost=2000;
							if(maptwo.mapTraversal[maptwo.squares.elementAt(i).getPoint().x/20][maptwo.squares.elementAt(i).getPoint().y/20]==0){
								GreenCaster green=new GreenCaster(maptwo.squares.elementAt(i).getPoint().x,maptwo.squares.elementAt(i).getPoint().y);
								allies.add(green);
								remainingFunds=Integer.parseInt(cs2.funds.getText())-cost;
								screentwo.funds=remainingFunds;
								cs2.funds.setText(""+remainingFunds);
								green.drawUnit(screentwo.getGraphics());
								cs2.GREEN=false;
							}else
								JOptionPane.showMessageDialog(parent, "Unit cannot be place there");
						}
						if(cs2.PROPHET){
							cost=5000;
							if(maptwo.mapTraversal[maptwo.squares.elementAt(i).getPoint().x/20][maptwo.squares.elementAt(i).getPoint().y/20]==0){
								Prophet prophet=new Prophet(maptwo.squares.elementAt(i).getPoint().x,maptwo.squares.elementAt(i).getPoint().y);
								allies.add(prophet);
								remainingFunds=Integer.parseInt(cs2.funds.getText())-cost;
								screentwo.funds=remainingFunds;
								cs2.funds.setText(""+remainingFunds);
								prophet.drawUnit(screentwo.getGraphics());
								cs2.PROPHET=false;
							}else
								JOptionPane.showMessageDialog(parent, "Unit cannot be place there");
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
