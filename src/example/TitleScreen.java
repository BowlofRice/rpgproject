package example;

import java.awt.Button;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TitleScreen{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame rpgproto=new JFrame("RPG Prototype");
		Field gamearea=new Field(rpgproto);
		gamearea.setBackground(Color.BLACK);
		rpgproto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rpgproto.addKeyListener(new KeyListen());
		rpgproto.addMouseListener(new MouseListen());
		rpgproto.setResizable(false);
		rpgproto.add(gamearea);
		rpgproto.pack();
		rpgproto.setLocationRelativeTo(null);
		rpgproto.setVisible(true);
		while(true){
			gamearea.repaint();
			gamearea.timestep();
		}
	}



}
