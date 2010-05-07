package example;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CharSelection {
	public boolean ARCHER = false;
	public boolean FIGHTER = false;
	public boolean BLUE = false;
	public boolean RED = false;
	public boolean GREEN = false;
	public boolean PROPHET = false;
	final JDialog charHolder = new JDialog();
	public Screen1 s;
	public JTextArea funds = new JTextArea();
	@SuppressWarnings("unused")
	private JFrame parent;
	private CharUpgrade cu;
	private CharSell sellpanel;

	public CharSelection(JFrame parent) {
		this.parent = parent;
		charHolder.addWindowListener(new WindowListener() {
			@Override
			public void windowActivated(WindowEvent arg0) {}
			@Override
			public void windowClosed(WindowEvent arg0) {}
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				charHolder.setVisible(false);
			}
			@Override
			public void windowDeactivated(WindowEvent arg0) {}
			@Override
			public void windowDeiconified(WindowEvent arg0) {}
			@Override
			public void windowIconified(WindowEvent arg0) {}
			@Override
			public void windowOpened(WindowEvent arg0) {}});
		JPanel holder = new JPanel();
		GridLayout my_layout = new GridLayout();
		my_layout.setColumns(2);
		my_layout.setRows(5);
		holder.setLayout(my_layout);
		JButton selectArcher = new JButton("Archer");
		JButton selectFighter = new JButton("Fighter");
		JButton selectBlue = new JButton("Blue Caster");
		JButton selectRed = new JButton("Red Caster");
		JButton selectGreen = new JButton("Green Caster");
		JButton selectProphet = new JButton("Prophet");
        JButton upgrade = new JButton("Upgrade Units");
        JButton sell=new JButton("Sell Units");
		holder.add(selectArcher);
		holder.add(selectFighter);
		holder.add(selectBlue);
		holder.add(selectRed);
		holder.add(selectGreen);
		holder.add(selectProphet);
        holder.add(upgrade);
        holder.add(sell);
        sell.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(sellpanel.mouse.canSell)
					sellpanel.setVisible(true);
				else
                	JOptionPane.showMessageDialog(charHolder, "you do not have any units to sell at this time.");
			}
        	
        });
        upgrade.addActionListener(new ActionListener(){
        	@Override
            public void actionPerformed(ActionEvent e){
        		if(cu.mouse.canUpgrade)
        			cu.setVisible(true);
                else
                	JOptionPane.showMessageDialog(charHolder, "you do not have any units to upgrade at this time.");
               	}
         	});
		selectArcher.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FIGHTER = false;
				BLUE = false;
				RED = false;
				GREEN = false;
				PROPHET = false;
				if (!ARCHER) {
					ARCHER = true;
					JOptionPane.showMessageDialog(charHolder,"click on the map to deploy an archer there. deploying an archer costs 1000G");
				} else 
					JOptionPane.showMessageDialog(charHolder,"you're currently deploying an archer. do so already.");
			
                        }

		});
		selectFighter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ARCHER = false;
				BLUE = false;
				RED = false;
				GREEN = false;
				PROPHET = false;
				if (!FIGHTER) {
					FIGHTER = true;
					JOptionPane.showMessageDialog(charHolder,"click on the map to deploy a fighter there. deploying a fighter costs 1500G");
				} else 
					JOptionPane.showMessageDialog(charHolder,"you're currently deploying a fighter. do so already.");
			}
		});
		selectBlue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ARCHER = false;
				FIGHTER = false;
				RED = false;
				GREEN = false;
				PROPHET = false;
				if (!BLUE) {
					BLUE = true;
					JOptionPane.showMessageDialog(charHolder,"click on the map to deploy a blue mage there. deploying a blue mage costs 2000G");
				} else 
					JOptionPane.showMessageDialog(charHolder,"you're currently deploying a blue mage. do so already.");
			}
		});
		selectRed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ARCHER = false;
				FIGHTER = false;
				BLUE = false;
				GREEN = false;
				PROPHET = false;
				if (!RED) {
					RED = true;
					JOptionPane.showMessageDialog(charHolder,"click on the map to deploy a red mage there. deploying a red mage costs 2000G");
				} else 
					JOptionPane.showMessageDialog(charHolder,"you're currently deploying a red mage. do so already.");
			}
		});
		selectGreen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ARCHER = false;
				FIGHTER = false;
				BLUE = false;
				RED = false;
				PROPHET = false;
				if (!GREEN) {
					GREEN = true;
					JOptionPane.showMessageDialog(charHolder,"click on the map to deploy a green mage there. deploying a green mage costs 2000G");
				} else 
					JOptionPane.showMessageDialog(charHolder,"you're currently deploying a green mage. do so already.");
			}
		});
		selectProphet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ARCHER = false;
				FIGHTER = false;
				BLUE = false;
				RED = false;
				GREEN = false;
				if (!PROPHET) {
					PROPHET = true;
					JOptionPane.showMessageDialog(charHolder,"click on the map to deploy a prophet there. deploying a prophet costs 5000G");
				} else 
					JOptionPane.showMessageDialog(charHolder,"you're currently deploying a prophet. do so already.");
			}
		});
		charHolder.add(holder);
		charHolder.pack();
		charHolder.setLocation(parent.getX() + 27, parent.getY() + 220);
	}

	public void setVisible(boolean b) {
		charHolder.setVisible(b);
	}

	public void addScreen(Screen1 s) {
		this.s = s;
		funds.setText("" + s.funds);
		funds.setEditable(false);

	}
	public void setUpgradePanel(CharUpgrade cu){
		this.cu=cu;
	}
	public void setSellPanel(CharSell sell){
		this.sellpanel=sell;
	}
}
