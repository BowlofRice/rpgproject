package example;

import java.awt.Color;
import javax.swing.JFrame;

public class TitleScreen{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame rpgproto=new JFrame("RPG Prototype");
		Field gamearea=new Field();
		gamearea.setBackground(Color.BLACK);
		rpgproto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rpgproto.addMouseListener(new MouseListen());
		rpgproto.setResizable(false);
		rpgproto.add(gamearea);
		rpgproto.pack();
		rpgproto.setLocationRelativeTo(null);
		rpgproto.setVisible(true);
	}



}
