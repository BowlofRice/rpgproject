package example;

import javax.swing.JFrame;

public class TitleScreen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MapAltOne testmap=new MapAltOne();
		JFrame sample=new JFrame("Sample");
		sample.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sample.setResizable(false);
		sample.addKeyListener(new KeyListen());
		Field dS=new Field(testmap);
		sample.add(dS);
		sample.pack();
		sample.setLocationRelativeTo(null);
		sample.setVisible(true);
		while(true){
			dS.timestep();
			dS.repaint();
		}
	}

}
