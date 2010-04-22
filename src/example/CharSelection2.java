package example;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CharSelection2 {
	final JFrame charHolder=new JFrame();
	private Screen2 s;
	public CharSelection2(){
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
		my_layout.setRows(4);
		holder.setLayout(my_layout);
		JButton selectArcher=new JButton("Archer");
        JButton selectMelee=new JButton("Fighter");
        JButton selectBlue=new JButton("Blue Caster");
        JButton selectRed=new JButton("Red Caster");
        JButton selectGreen=new JButton("Green Caster");
        JButton selectProphet=new JButton("Prophet");
        JButton startRound=new JButton("Play!");
        holder.add(selectArcher);
        holder.add(selectMelee);
        holder.add(selectBlue);
        holder.add(selectRed);
        holder.add(selectGreen);
        holder.add(selectProphet);
        holder.add(startRound);
        startRound.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
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
	public void addScreen(Screen2 s){
		this.s=s;
	}
}
