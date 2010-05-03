package example;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MouseTracer implements MouseListener{
	public Vector<Ally> allies=new Vector<Ally>();
	public int cost, remainingFunds;
	private MapOne mapone;
	private CharSelection cs1;
	private Screen1 screenone;
	private JFrame parent;
    private CharUpgrade cu;

	
	public MouseTracer(MapOne mapone, CharSelection cs1, Screen1 screenone, JFrame parent, CharUpgrade cu){
		this.mapone=mapone;
		this.cs1=cs1;
		this.screenone=screenone;
		this.parent=parent;
                this.cu=cu;

	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
			for(int i=0;i<mapone.squares.size();i++){
				if(mapone.squares.elementAt(i).isInside(arg0.getX(), arg0.getY())){
					if(mapone.squares.elementAt(i).getPoint().x+19>arg0.getX() && mapone.squares.elementAt(i).getPoint().y+19>arg0.getY()){
						if(cs1.ARCHER){
							cost=1000;
							if(Integer.parseInt(cs1.funds.getText())-cost>0){
								if(mapone.mapTraversal[mapone.squares.elementAt(i).getPoint().x/20][mapone.squares.elementAt(i).getPoint().y/20]==0){
									Archer archer=new Archer(mapone.squares.elementAt(i).getPoint().x,mapone.squares.elementAt(i).getPoint().y);
									allies.add(archer);
									remainingFunds=Integer.parseInt(cs1.funds.getText())-cost;
									screenone.funds=remainingFunds;
									cs1.funds.setText(""+remainingFunds);
									archer.drawUnit(screenone.getGraphics());
									cs1.ARCHER=false;
                                                                        cu.setAllies(allies);
								}else
									JOptionPane.showMessageDialog(parent, "Unit cannot be place there");
							}else{
								JOptionPane.showMessageDialog(parent, "Not enough funds to make purchase");
								cs1.ARCHER=false;
							}
						}
						if(cs1.FIGHTER){
							cost=1500;
							if(Integer.parseInt(cs1.funds.getText())-cost>0){
								if(mapone.mapTraversal[mapone.squares.elementAt(i).getPoint().x/20][mapone.squares.elementAt(i).getPoint().y/20]==0){
									Fighter fighter=new Fighter(mapone.squares.elementAt(i).getPoint().x,mapone.squares.elementAt(i).getPoint().y);
									allies.add(fighter);
									remainingFunds=Integer.parseInt(cs1.funds.getText())-cost;
									screenone.funds=remainingFunds;
									cs1.funds.setText(""+remainingFunds);
									fighter.drawUnit(screenone.getGraphics());
									cs1.FIGHTER=false;
                                                                        cu.setAllies(allies);
								}else
									JOptionPane.showMessageDialog(parent, "Unit cannot be place there");
							}else{
								JOptionPane.showMessageDialog(parent, "Not enough funds to make purchase");
								cs1.FIGHTER=false;
							}
						}
						if(cs1.BLUE){
							cost=2000;
							if(Integer.parseInt(cs1.funds.getText())-cost>0){
								if(mapone.mapTraversal[mapone.squares.elementAt(i).getPoint().x/20][mapone.squares.elementAt(i).getPoint().y/20]==0){
									BlueCaster blue=new BlueCaster(mapone.squares.elementAt(i).getPoint().x,mapone.squares.elementAt(i).getPoint().y);
									allies.add(blue);
									remainingFunds=Integer.parseInt(cs1.funds.getText())-cost;
									screenone.funds=remainingFunds;
									cs1.funds.setText(""+remainingFunds);
									blue.drawUnit(screenone.getGraphics());
									cs1.BLUE=false;
                                                                        cu.setAllies(allies);
								}else
									JOptionPane.showMessageDialog(parent, "Unit cannot be place there");
							}else{
								JOptionPane.showMessageDialog(parent, "Not enough funds to make purchase");
								cs1.BLUE=false;
							}
						}
						if(cs1.RED){
							cost=2000;
							if(Integer.parseInt(cs1.funds.getText())-cost>0){
								if(mapone.mapTraversal[mapone.squares.elementAt(i).getPoint().x/20][mapone.squares.elementAt(i).getPoint().y/20]==0){
									RedCaster red=new RedCaster(mapone.squares.elementAt(i).getPoint().x,mapone.squares.elementAt(i).getPoint().y);
									allies.add(red);
									remainingFunds=Integer.parseInt(cs1.funds.getText())-cost;
									screenone.funds=remainingFunds;
									cs1.funds.setText(""+remainingFunds);
									red.drawUnit(screenone.getGraphics());
									cs1.RED=false;
                                                                        cu.setAllies(allies);
								}else
									JOptionPane.showMessageDialog(parent, "Unit cannot be place there");
							}else{
								JOptionPane.showMessageDialog(parent, "Not enough funds to make purchase");
								cs1.RED=false;
							}
						}
						if(cs1.GREEN){
							cost=2000;
							if(Integer.parseInt(cs1.funds.getText())-cost>0){
								if(mapone.mapTraversal[mapone.squares.elementAt(i).getPoint().x/20][mapone.squares.elementAt(i).getPoint().y/20]==0){
									GreenCaster green=new GreenCaster(mapone.squares.elementAt(i).getPoint().x,mapone.squares.elementAt(i).getPoint().y);
									allies.add(green);
									remainingFunds=Integer.parseInt(cs1.funds.getText())-cost;
									screenone.funds=remainingFunds;
									cs1.funds.setText(""+remainingFunds);
									green.drawUnit(screenone.getGraphics());
									cs1.GREEN=false;
                                                                        cu.setAllies(allies);
								}else	
									JOptionPane.showMessageDialog(parent, "Unit cannot be place there");
							}else{
								JOptionPane.showMessageDialog(parent, "Not enough funds to make purchase");
								cs1.GREEN=false;
							}
						}
						if(cs1.PROPHET){
							cost=5000;
							if(Integer.parseInt(cs1.funds.getText())-cost>0){
								if(mapone.mapTraversal[mapone.squares.elementAt(i).getPoint().x/20][mapone.squares.elementAt(i).getPoint().y/20]==0){
									Prophet prophet=new Prophet(mapone.squares.elementAt(i).getPoint().x,mapone.squares.elementAt(i).getPoint().y);
									allies.add(prophet);
									remainingFunds=Integer.parseInt(cs1.funds.getText())-cost;
									screenone.funds=remainingFunds;
									cs1.funds.setText(""+remainingFunds);
									prophet.drawUnit(screenone.getGraphics());
									cs1.PROPHET=false;
                                                                        cu.setAllies(allies);
								}else
									JOptionPane.showMessageDialog(parent, "Unit cannot be place there");
							}else{
								JOptionPane.showMessageDialog(parent, "Not enough funds to make purchase");
								cs1.PROPHET=false;
							}
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
