package example;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class MouseTracer2 implements MouseListener{
	public Vector<Ally> allies=new Vector<Ally>();
	public int cost, remainingFunds;
	public boolean canUpgrade=false, canSell=false;
	private MapTwo maptwo;
	private CharSelection2 cs2;
	private Screen2 screentwo;
	private JDialog parent;
	private CharUpgrade2 cu;
	private CharSell2 sellpanel;
	
	public MouseTracer2(MapTwo maptwo, CharSelection2 cs2, Screen2 screentwo, JDialog parent){
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
							if(Integer.parseInt(cs2.funds.getText())-cost>0){
								if(maptwo.mapTraversal[maptwo.squares.elementAt(i).getPoint().x/20][maptwo.squares.elementAt(i).getPoint().y/20]==0){
									Archer archer=new Archer(maptwo.squares.elementAt(i).getPoint().x,maptwo.squares.elementAt(i).getPoint().y);
									archer.setSellWorth(cost/2);
									allies.add(archer);
									remainingFunds=Integer.parseInt(cs2.funds.getText())-cost;
									screentwo.funds=remainingFunds;
									cs2.funds.setText(""+remainingFunds);
									archer.drawUnit(screentwo.getGraphics());
									cu.makeUpWindow(archer);
									sellpanel.makeUpWindow(archer);
									canUpgrade=true;
									canSell=true;
									cs2.ARCHER=false;
								}else
									JOptionPane.showMessageDialog(parent, "Unit cannot be place there");
							}else{
								JOptionPane.showMessageDialog(parent, "Not enough funds to make purchase");
								cs2.ARCHER=false;
							}
						}
						if(cs2.FIGHTER){
							cost=1500;
							if(Integer.parseInt(cs2.funds.getText())-cost>0){
								if(maptwo.mapTraversal[maptwo.squares.elementAt(i).getPoint().x/20][maptwo.squares.elementAt(i).getPoint().y/20]==0){
									Fighter fighter=new Fighter(maptwo.squares.elementAt(i).getPoint().x,maptwo.squares.elementAt(i).getPoint().y);
									fighter.setSellWorth(cost/2);
									allies.add(fighter);
									remainingFunds=Integer.parseInt(cs2.funds.getText())-cost;
									screentwo.funds=remainingFunds;
									cs2.funds.setText(""+remainingFunds);
									fighter.drawUnit(screentwo.getGraphics());
									cu.makeUpWindow(fighter);
									sellpanel.makeUpWindow(fighter);
									canUpgrade=true;
									canSell=true;
									cs2.FIGHTER=false;
								}else
									JOptionPane.showMessageDialog(parent, "Unit cannot be place there");
							}else{
								JOptionPane.showMessageDialog(parent, "Not enough funds to make purchase");
								cs2.FIGHTER=false;
							}
						}
						if(cs2.BLUE){
							cost=2000;
							if(Integer.parseInt(cs2.funds.getText())-cost>0){
								if(maptwo.mapTraversal[maptwo.squares.elementAt(i).getPoint().x/20][maptwo.squares.elementAt(i).getPoint().y/20]==0){
									BlueCaster blue=new BlueCaster(maptwo.squares.elementAt(i).getPoint().x,maptwo.squares.elementAt(i).getPoint().y);
									blue.setSellWorth(cost/2);
									allies.add(blue);
									remainingFunds=Integer.parseInt(cs2.funds.getText())-cost;
									screentwo.funds=remainingFunds;
									cs2.funds.setText(""+remainingFunds);
									blue.drawUnit(screentwo.getGraphics());
									cu.makeUpWindow(blue);
									sellpanel.makeUpWindow(blue);
									canUpgrade=true;
									canSell=true;
									cs2.BLUE=false;
								}else
									JOptionPane.showMessageDialog(parent, "Unit cannot be place there");
							}else{
								JOptionPane.showMessageDialog(parent, "Not enough funds to make purchase");
								cs2.BLUE=false;
							}
						}
						if(cs2.RED){
							cost=2000;
							if(Integer.parseInt(cs2.funds.getText())-cost>0){
								if(maptwo.mapTraversal[maptwo.squares.elementAt(i).getPoint().x/20][maptwo.squares.elementAt(i).getPoint().y/20]==0){
									RedCaster red=new RedCaster(maptwo.squares.elementAt(i).getPoint().x,maptwo.squares.elementAt(i).getPoint().y);
									red.setSellWorth(cost/2);
									allies.add(red);
									remainingFunds=Integer.parseInt(cs2.funds.getText())-cost;
									screentwo.funds=remainingFunds;
									cs2.funds.setText(""+remainingFunds);
									red.drawUnit(screentwo.getGraphics());
									cu.makeUpWindow(red);
									sellpanel.makeUpWindow(red);
									canUpgrade=true;
									canSell=true;
									cs2.RED=false;
								}else
									JOptionPane.showMessageDialog(parent, "Unit cannot be place there");
							}else{
								JOptionPane.showMessageDialog(parent, "Not enough funds to make purchase");
								cs2.RED=false;
							}
						}
						if(cs2.GREEN){
							cost=2000;
							if(Integer.parseInt(cs2.funds.getText())-cost>0){
								if(maptwo.mapTraversal[maptwo.squares.elementAt(i).getPoint().x/20][maptwo.squares.elementAt(i).getPoint().y/20]==0){
									GreenCaster green=new GreenCaster(maptwo.squares.elementAt(i).getPoint().x,maptwo.squares.elementAt(i).getPoint().y);
									green.setSellWorth(cost/2);
									allies.add(green);
									remainingFunds=Integer.parseInt(cs2.funds.getText())-cost;
									screentwo.funds=remainingFunds;
									cs2.funds.setText(""+remainingFunds);
									green.drawUnit(screentwo.getGraphics());
									cu.makeUpWindow(green);
									sellpanel.makeUpWindow(green);
									canUpgrade=true;
									canSell=true;
									cs2.GREEN=false;
								}else
									JOptionPane.showMessageDialog(parent, "Unit cannot be place there");
							}else{
								JOptionPane.showMessageDialog(parent, "Not enough funds to make purchase");
								cs2.GREEN=false;
							}
						}
						if(cs2.PROPHET){
							cost=5000;
							if(Integer.parseInt(cs2.funds.getText())-cost>0){
								if(maptwo.mapTraversal[maptwo.squares.elementAt(i).getPoint().x/20][maptwo.squares.elementAt(i).getPoint().y/20]==0){
									Prophet prophet=new Prophet(maptwo.squares.elementAt(i).getPoint().x,maptwo.squares.elementAt(i).getPoint().y);
									prophet.setSellWorth(cost/2);
									allies.add(prophet);
									remainingFunds=Integer.parseInt(cs2.funds.getText())-cost;
									screentwo.funds=remainingFunds;
									cs2.funds.setText(""+remainingFunds);
									prophet.drawUnit(screentwo.getGraphics());
									cu.makeUpWindow(prophet);
									sellpanel.makeUpWindow(prophet);
									canUpgrade=true;
									canSell=true;
									cs2.PROPHET=false;
								}else
									JOptionPane.showMessageDialog(parent, "Unit cannot be place there");
							}else{
								JOptionPane.showMessageDialog(parent, "Not enough funds to make purchase");
								cs2.PROPHET=false;
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
	public void setUpgrade(CharUpgrade2 cu){
		this.cu=cu;
	}
	public void setSell(CharSell2 sell){
		this.sellpanel=sell;
	}
}
