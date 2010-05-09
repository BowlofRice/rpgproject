package example;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class MouseTracer3 implements MouseListener{
	public Vector<Ally> allies=new Vector<Ally>();
	public int cost, remainingFunds;
	public boolean canUpgrade=false, canSell=false;
	private MapThree mapthree;
	private CharSelection3 cs3;
	private Screen3 screenthree;
	private JDialog parent;
	private CharUpgrade3 cu;
	private CharSell3 sellpanel;
	
	public MouseTracer3(MapThree mapthree, CharSelection3 cs3, Screen3 screenthree, JDialog parent){
		this.mapthree=mapthree;
		this.cs3=cs3;
		this.screenthree=screenthree;
		this.parent=parent;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
			for(int i=0;i<mapthree.squares.size();i++){
				if(mapthree.squares.elementAt(i).isInside(arg0.getX(), arg0.getY())){
					if(mapthree.squares.elementAt(i).getPoint().x+19>arg0.getX() && mapthree.squares.elementAt(i).getPoint().y+19>arg0.getY()){
						if(cs3.ARCHER){
							cost=1000;
							if(Integer.parseInt(cs3.funds.getText())-cost>0){
								if(mapthree.mapTraversal[mapthree.squares.elementAt(i).getPoint().x/20][mapthree.squares.elementAt(i).getPoint().y/20]==0){
									Archer archer=new Archer(mapthree.squares.elementAt(i).getPoint().x,mapthree.squares.elementAt(i).getPoint().y);
									archer.setSellWorth(cost/2);
									allies.add(archer);
									remainingFunds=Integer.parseInt(cs3.funds.getText())-cost;
									screenthree.funds=remainingFunds;
									cs3.funds.setText(""+remainingFunds);
									archer.drawUnit(screenthree.getGraphics());
									cu.makeUpWindow(archer);
									sellpanel.makeUpWindow(archer);
									canUpgrade=true;
									canSell=true;
									cs3.ARCHER=false;
								}else
									JOptionPane.showMessageDialog(parent, "Unit cannot be place there");
							}else{
								JOptionPane.showMessageDialog(parent, "Not enough funds to make purchase");
								cs3.ARCHER=false;
							}
						}
						if(cs3.FIGHTER){
							cost=1500;
							if(Integer.parseInt(cs3.funds.getText())-cost>0){
								if(mapthree.mapTraversal[mapthree.squares.elementAt(i).getPoint().x/20][mapthree.squares.elementAt(i).getPoint().y/20]==0){
									Fighter fighter=new Fighter(mapthree.squares.elementAt(i).getPoint().x,mapthree.squares.elementAt(i).getPoint().y);
									fighter.setSellWorth(cost/2);
									allies.add(fighter);
									remainingFunds=Integer.parseInt(cs3.funds.getText())-cost;
									screenthree.funds=remainingFunds;
									cs3.funds.setText(""+remainingFunds);
									fighter.drawUnit(screenthree.getGraphics());
									cu.makeUpWindow(fighter);
									sellpanel.makeUpWindow(fighter);
									canUpgrade=true;
									canSell=true;
									cs3.FIGHTER=false;
								}else
									JOptionPane.showMessageDialog(parent, "Unit cannot be place there");
							}else{
								JOptionPane.showMessageDialog(parent, "Not enough funds to make purchase");
								cs3.FIGHTER=false;
							}
						}
						if(cs3.BLUE){
							cost=2000;
							if(Integer.parseInt(cs3.funds.getText())-cost>0){
								if(mapthree.mapTraversal[mapthree.squares.elementAt(i).getPoint().x/20][mapthree.squares.elementAt(i).getPoint().y/20]==0){
									BlueCaster blue=new BlueCaster(mapthree.squares.elementAt(i).getPoint().x,mapthree.squares.elementAt(i).getPoint().y);
									blue.setSellWorth(cost/2);
									allies.add(blue);
									remainingFunds=Integer.parseInt(cs3.funds.getText())-cost;
									screenthree.funds=remainingFunds;
									cs3.funds.setText(""+remainingFunds);
									blue.drawUnit(screenthree.getGraphics());
									cu.makeUpWindow(blue);
									sellpanel.makeUpWindow(blue);
									canUpgrade=true;
									canSell=true;
									cs3.BLUE=false;
								}else
									JOptionPane.showMessageDialog(parent, "Unit cannot be place there");
							}else{
								JOptionPane.showMessageDialog(parent, "Not enough funds to make purchase");
								cs3.BLUE=false;
							}
						}
						if(cs3.RED){
							cost=2000;
							if(Integer.parseInt(cs3.funds.getText())-cost>0){
								if(mapthree.mapTraversal[mapthree.squares.elementAt(i).getPoint().x/20][mapthree.squares.elementAt(i).getPoint().y/20]==0){
									RedCaster red=new RedCaster(mapthree.squares.elementAt(i).getPoint().x,mapthree.squares.elementAt(i).getPoint().y);
									red.setSellWorth(cost/2);
									allies.add(red);
									remainingFunds=Integer.parseInt(cs3.funds.getText())-cost;
									screenthree.funds=remainingFunds;
									cs3.funds.setText(""+remainingFunds);
									red.drawUnit(screenthree.getGraphics());
									cu.makeUpWindow(red);
									sellpanel.makeUpWindow(red);
									canUpgrade=true;
									canSell=true;
									cs3.RED=false;
								}else
									JOptionPane.showMessageDialog(parent, "Unit cannot be place there");
							}else{
								JOptionPane.showMessageDialog(parent, "Not enough funds to make purchase");
								cs3.RED=false;
							}
						}
						if(cs3.GREEN){
							cost=2000;
							if(Integer.parseInt(cs3.funds.getText())-cost>0){
								if(mapthree.mapTraversal[mapthree.squares.elementAt(i).getPoint().x/20][mapthree.squares.elementAt(i).getPoint().y/20]==0){
									GreenCaster green=new GreenCaster(mapthree.squares.elementAt(i).getPoint().x,mapthree.squares.elementAt(i).getPoint().y);
									green.setSellWorth(cost/2);
									allies.add(green);
									remainingFunds=Integer.parseInt(cs3.funds.getText())-cost;
									screenthree.funds=remainingFunds;
									cs3.funds.setText(""+remainingFunds);
									green.drawUnit(screenthree.getGraphics());
									cu.makeUpWindow(green);
									sellpanel.makeUpWindow(green);
									canUpgrade=true;
									canSell=true;
									cs3.GREEN=false;
								}else
									JOptionPane.showMessageDialog(parent, "Unit cannot be place there");
							}else{
								JOptionPane.showMessageDialog(parent, "Not enough funds to make purchase");
								cs3.GREEN=false;
							}
						}
						if(cs3.PROPHET){
							cost=5000;
							if(Integer.parseInt(cs3.funds.getText())-cost>0){
								if(mapthree.mapTraversal[mapthree.squares.elementAt(i).getPoint().x/20][mapthree.squares.elementAt(i).getPoint().y/20]==0){
									Prophet prophet=new Prophet(mapthree.squares.elementAt(i).getPoint().x,mapthree.squares.elementAt(i).getPoint().y);
									prophet.setSellWorth(cost/2);
									allies.add(prophet);
									remainingFunds=Integer.parseInt(cs3.funds.getText())-cost;
									screenthree.funds=remainingFunds;
									cs3.funds.setText(""+remainingFunds);
									prophet.drawUnit(screenthree.getGraphics());
									cu.makeUpWindow(prophet);
									sellpanel.makeUpWindow(prophet);
									canUpgrade=true;
									canSell=true;
									cs3.PROPHET=false;
								}else
									JOptionPane.showMessageDialog(parent, "Unit cannot be place there");
							}else{
								JOptionPane.showMessageDialog(parent, "Not enough funds to make purchase");
								cs3.PROPHET=false;
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
	public void setUpgrade(CharUpgrade3 cu){
		this.cu=cu;
	}
	public void setSell(CharSell3 sell){
		this.sellpanel=sell;
	}
}
