package example;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CharSelection {
	public boolean ARCHER=false;
	public boolean FIGHTER=false;
	public boolean BLUE=false;
	public boolean RED=false;
	public boolean GREEN=false;
	public boolean PROPHET=false;
        public int x_on_click;
        public int y_on_click;
	final JFrame charHolder=new JFrame();
	private Screen1 s;
	private JTextArea funds=new JTextArea();
	public CharSelection(){
		charHolder.addWindowListener(new WindowListener(){

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				charHolder.setVisible(false);
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		JPanel holder=new JPanel();
		GridLayout my_layout=new GridLayout();
		my_layout.setColumns(2);
		my_layout.setRows(5);
		holder.setLayout(my_layout);
		JButton selectArcher=new JButton("Archer");
        JButton selectFighter=new JButton("Fighter");
        JButton selectBlue=new JButton("Blue Caster");
        JButton selectRed=new JButton("Red Caster");
        JButton selectGreen=new JButton("Green Caster");
        JButton selectProphet=new JButton("Prophet");
        JButton startRound=new JButton("Play!");
        JLabel blank=new JLabel();
        JLabel fund_label=new JLabel("Funds:");
        holder.add(selectArcher);
        holder.add(selectFighter);
        holder.add(selectBlue);
        holder.add(selectRed);
        holder.add(selectGreen);
        holder.add(selectProphet);
        holder.add(startRound);
        holder.add(blank);
        holder.add(fund_label);
        holder.add(funds);
        selectArcher.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// TODO Auto-generated method stub
        		FIGHTER=false;
        		BLUE=false;
        		RED=false;
        		GREEN=false;
        		PROPHET=false;
        		if(!ARCHER){
        			ARCHER=true;
        			JOptionPane.showMessageDialog(charHolder, "click on the map to deploy an archer there. deploying an archer costs 1000G");
        		}else{
        			JOptionPane.showMessageDialog(charHolder, "you're currently deploying an archer. do so already.");
        		}

            }
        });
        selectFighter.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// TODO Auto-generated method stub

            	}
        });
        selectBlue.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// TODO Auto-generated method stub

                }
        });
        selectRed.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// TODO Auto-generated method stub

                }
        });
        selectGreen.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// TODO Auto-generated method stub

                }
        });
        selectProphet.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	// TODO Auto-generated method stub

                }
        });


        startRound.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
                                charHolder.setVisible(false);
				s.playTime=1;
				s.repaint();
			}
        	
        });
		charHolder.add(holder);
		charHolder.pack();
		charHolder.setLocationRelativeTo(null);
	}
	public void setVisible(boolean b){
		charHolder.setVisible(b);
	}
	public void addScreen(Screen1 s){
		this.s=s;
		funds.setText(""+s.funds);
		funds.setEditable(false);
		
	}
}
