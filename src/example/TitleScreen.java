package example;

import javax.swing.JFrame;

public class TitleScreen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MapAltOne testmap=new MapAltOne();
		MapAltTwo test2map=new MapAltTwo();
		MapAltThree test3map=new MapAltThree();
		JFrame sample=new JFrame("Sample");
		sample.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sample.setResizable(false);
		sample.addKeyListener(new KeyListen());
		Field dS=new Field(testmap, test2map, test3map);
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
