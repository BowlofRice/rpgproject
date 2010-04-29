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

public class CharUpgrade {
    	public boolean ARCHER_UPGRADE=false;
	public boolean FIGHTER_UPGRADE=false;
	public boolean BLUE_UPGRADE=false;
	public boolean RED_UPGRADE=false;
	public boolean GREEN_UPGRADE=false;
	public boolean PROPHET_UPGRADE=false;

        public boolean Increase_Attack_5=false;
        public boolean Increase_Attack_10=false;
        public boolean Increase_Attack_15=false;
        public boolean Increase_Attack_20=false;

        public boolean Increase_Level=false;




	final JFrame charHolder=new JFrame();
        final JFrame upgradeoptions=new JFrame();
        //upgradeoptions
	private Screen1 s;
	public JTextArea funds=new JTextArea();
	@SuppressWarnings("unused")
	private JFrame parent;
	public CharUpgrade(JFrame parent){
		this.parent=parent;
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
		JButton selectArcher=new JButton("Archer Upgrade");
        JButton selectFighter=new JButton("Fighter Upgrade");
        JButton selectBlue=new JButton("Blue Caster Upgrade");
        JButton selectRed=new JButton("Red Caster Upgrade");
        JButton selectGreen=new JButton("Green Caster Upgrade");
        JButton selectProphet=new JButton("Prophet Upgrade");
        JButton startRound=new JButton("Next Round");

        JPanel holder2=new JPanel();
        GridLayout my_layout2=new GridLayout();
        my_layout2.setColumns(2);
        my_layout2.setRows(8);
        holder2.setLayout(my_layout2);

        JButton selectIncreaseAttack_5=new JButton("Increase Attack 5%");
        JButton selectIncreaseAttack_10=new JButton("Increase Attack 10%");
        JButton selectIncreaseAttack_15=new JButton("Increase Attack 15%");
        JButton selectIncreaseAttack_20=new JButton("Increase Attack 20%");

        JButton selectIncreaseLVL=new JButton("Increase Level");
        JButton goBack=new JButton("Back");





        holder2.add(selectIncreaseAttack_5);
        holder2.add(selectIncreaseAttack_10);
        holder2.add(selectIncreaseAttack_15);
        holder2.add(selectIncreaseAttack_20);

        holder2.add(selectIncreaseLVL);
        holder2.add(goBack);


        JLabel blank=new JLabel();


        holder.add(selectArcher);
        holder.add(selectFighter);
        holder.add(selectBlue);
        holder.add(selectRed);
        holder.add(selectGreen);
        holder.add(selectProphet);
        holder.add(startRound);
        holder.add(blank);
        selectArcher.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// TODO Auto-generated method stub
        		FIGHTER_UPGRADE=false;
        		BLUE_UPGRADE=false;
        		RED_UPGRADE=false;
        		GREEN_UPGRADE=false;
        		PROPHET_UPGRADE=false;
        		if(!ARCHER_UPGRADE){
        			ARCHER_UPGRADE=true;
        			JOptionPane.showMessageDialog(charHolder, "click on the map to upgrade an archer. Upgrading an archer costs 1000G");
        		}else{
        			JOptionPane.showMessageDialog(charHolder, "you're currently upgrading an archer. do so already.");
        		}

            }
        });
        selectFighter.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// TODO Auto-generated method stub
        		ARCHER_UPGRADE=false;
        		BLUE_UPGRADE=false;
        		RED_UPGRADE=false;
        		GREEN_UPGRADE=false;
        		PROPHET_UPGRADE=false;
        		if(!FIGHTER_UPGRADE){
        			FIGHTER_UPGRADE=true;
        			JOptionPane.showMessageDialog(charHolder, "click on the map to upgrade a fighter. upgrading a fighter costs 1500G");
        		}else{
        			JOptionPane.showMessageDialog(charHolder, "you're currently upgrading a fighter. do so already.");
        		}
            }
        });
        selectBlue.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// TODO Auto-generated method stub
        		ARCHER_UPGRADE=false;
        		FIGHTER_UPGRADE=false;
        		RED_UPGRADE=false;
        		GREEN_UPGRADE=false;
        		PROPHET_UPGRADE=false;
        		if(!BLUE_UPGRADE){
        			BLUE_UPGRADE=true;
        			JOptionPane.showMessageDialog(charHolder, "click on the map to upgrade a blue mage. upgrading a blue mage costs 2000G");
        		}else{
        			JOptionPane.showMessageDialog(charHolder, "you're currently upgrading a blue mage. do so already.");
        		}
        	}
        });
        selectRed.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// TODO Auto-generated method stub
        		ARCHER_UPGRADE=false;
        		FIGHTER_UPGRADE=false;
        		BLUE_UPGRADE=false;
        		GREEN_UPGRADE=false;
        		PROPHET_UPGRADE=false;
        		if(!RED_UPGRADE){
        			RED_UPGRADE=true;
        			JOptionPane.showMessageDialog(charHolder, "click on the map to upgrade a red mage. upgrading a red mage costs 2000G");
        		}else{
        			JOptionPane.showMessageDialog(charHolder, "you're currently upgrading a red mage. do so already.");
        		}
        	}
        });
        selectGreen.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// TODO Auto-generated method stub
        		ARCHER_UPGRADE=false;
        		FIGHTER_UPGRADE=false;
        		BLUE_UPGRADE=false;
        		RED_UPGRADE=false;
        		PROPHET_UPGRADE=false;
        		if(!GREEN_UPGRADE){
        			GREEN_UPGRADE=true;
        			JOptionPane.showMessageDialog(charHolder, "click on the map to upgrade a green mage. upgrading a green mage costs 2000G");
        		}else{
        			JOptionPane.showMessageDialog(charHolder, "you're currently upgrading a green mage. do so already.");
        		}
        	}
        });
        selectProphet.addActionListener(new ActionListener() {
        @Override
        	public void actionPerformed(ActionEvent e) {
        	// TODO Auto-generated method stub
        		ARCHER_UPGRADE=false;
        		FIGHTER_UPGRADE=false;
        		BLUE_UPGRADE=false;
        		RED_UPGRADE=false;
        		GREEN_UPGRADE=false;
        		if(!PROPHET_UPGRADE){
        			PROPHET_UPGRADE=true;
        			JOptionPane.showMessageDialog(charHolder, "click on the map to upgrade a prophet. upgrading a prophet costs 5000G");
        		}else{
        			JOptionPane.showMessageDialog(charHolder, "you're currently upgrading a prophet. do so already.");
        		}
        	}
        });


        startRound.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(s.mouse.allies.size()!=0){
					charHolder.setVisible(false);
					s.playTime=1;
					s.repaint();
				}else{
					JOptionPane.showMessageDialog(charHolder, "No unit selected. Click a unit to upgrade");
				}
			}

        });
		charHolder.add(holder);
		charHolder.pack();
		charHolder.setLocation(parent.getX()+78, parent.getY()+200);
                upgradeoptions.add(holder2);
                upgradeoptions.pack();
                upgradeoptions.setLocation(parent.getX()+78, parent.getY()+200);

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


