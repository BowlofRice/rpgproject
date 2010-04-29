package example;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int RESET_FUNDS=20000;
		final int RESET_HP=100;
		final int RESET_HP_2=200;
		final JFrame jf=new JFrame();
		final JPanel parent=new JPanel();
		final CharSelection cs1=new CharSelection(jf);
		final CharSelection2 cs2=new CharSelection2(jf);
		final CharSelection3 cs3=new CharSelection3(jf);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel main=new JPanel(), mapselect=new JPanel(), playmap1Menu=new JPanel(), playmap2Menu=new JPanel(), playmap3Menu=new JPanel();
		JPanel playmap1=new JPanel();
		JPanel playmap2=new JPanel();
		JPanel playmap3=new JPanel();
		JButton start=new JButton("start");
		GridLayout grid=new GridLayout();
		grid.setColumns(2);
		grid.setRows(3);
		JPanel mapselectbuttons=new JPanel();
		mapselectbuttons.setLayout(grid);
		JButton map1=new JButton("map1");
		JButton map2=new JButton("map2");
		JButton map3=new JButton("map3");
		JButton quit=new JButton("quit");
		mapselectbuttons.add(map1);
		mapselectbuttons.add(map2);
		mapselectbuttons.add(map3);
		mapselectbuttons.add(quit);
		JButton quittomapsel=new JButton("quit");
		JButton quittomapsel1=new JButton("quit");
		JButton quittomapsel2=new JButton("quit");   
		JButton selectplayers=new JButton("Player Select");
		JButton selectplayers1=new JButton("Player Select");
        JButton selectplayers2=new JButton("Player Select");
        main.add(start);
		main.add(new Title());
		mapselect.add(mapselectbuttons);
		mapselect.add(new SelectaMap());
		final MapOne mapone=new MapOne(cs1);
		final MapTwo maptwo=new MapTwo(cs2);
		final MapThree mapthree=new MapThree(cs3);
		playmap1Menu.setLayout(grid);
		playmap1Menu.add(quittomapsel);
		playmap1Menu.add(selectplayers);
		playmap2Menu.setLayout(grid);
		playmap2Menu.add(quittomapsel1);
		playmap2Menu.add(selectplayers1);
		playmap3Menu.setLayout(grid);
		playmap3Menu.add(quittomapsel2);
		playmap3Menu.add(selectplayers2);
        final Screen1 screenone=new Screen1(mapone);
		final Screen2 screentwo=new Screen2(maptwo);
		final Screen3 screenthree=new Screen3(mapthree);
		MouseTracer mouse=new MouseTracer(mapone, cs1, screenone, cs1.charHolder);
		mapone.setTracer(mouse);
		MouseTracer2 mouse2=new MouseTracer2(maptwo, cs2, screentwo, cs2.charHolder);
		maptwo.setTracer(mouse2);
		MouseTracer3 mouse3=new MouseTracer3(mapthree, cs3, screenthree, cs3.charHolder);
		mapthree.setTracer(mouse3);
		screenone.addMouseTracer(mouse);
		screenone.addMouseListener(mouse);
		screentwo.addMouseTracer(mouse2);
		screentwo.addMouseListener(mouse2);
		screenthree.addMouseTracer(mouse3);
		screenthree.addMouseListener(mouse3);
		cs1.addScreen(screenone);
		cs2.addScreen(screentwo);
		cs3.addScreen(screenthree);
		playmap1Menu.add(new JLabel("Funds/Score: "));
		playmap1Menu.add(cs1.funds);
		playmap1Menu.add(new JLabel("Troy HP: "));
		mapone.troyHP.setEditable(false);
		playmap1Menu.add(mapone.troyHP);
		playmap2Menu.add(new JLabel("Funds/Score: "));
		playmap2Menu.add(cs2.funds);
		playmap2Menu.add(new JLabel("Troy HP: "));
		maptwo.troyHP.setEditable(false);
		playmap2Menu.add(maptwo.troyHP);
		playmap3Menu.add(new JLabel("Funds/Score: "));
		playmap3Menu.add(cs3.funds);
		playmap3Menu.add(new JLabel("Troy HP: "));
		mapthree.troyHP.setEditable(false);
		playmap3Menu.add(mapthree.troyHP);
		playmap1.add(playmap1Menu);
		playmap2.add(playmap2Menu);
		playmap3.add(playmap3Menu);
		playmap1.add(screenone);
		playmap2.add(screentwo);
		playmap3.add(screenthree);
		final CardLayout myLayout=new CardLayout();
		start.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myLayout.show(parent, "maps");
			}
			
		});
		quit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myLayout.show(parent, "title");
			}
			
		});
		map1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myLayout.show(parent, "map1");
				screenone.paint(screenone.getGraphics());
			}			
		});
		map2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myLayout.show(parent, "map2");
				screentwo.paint(screentwo.getGraphics());
			}			
		});
		map3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myLayout.show(parent, "map3");
				screenthree.paint(screenthree.getGraphics());
			}			
		});
		quittomapsel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				screenone.mouse.allies.removeAllElements();
				mapone.enemies.removeAllElements();
				mapone.k=0;
				screenone.funds=RESET_FUNDS;
				cs1.funds.setText(""+screenone.funds);
				mapone.HP=RESET_HP;
				mapone.troyHP.setText(mapone.HP+"/100");
				screenone.playTime=0;
				myLayout.show(parent, "maps");
			}			
		});
		quittomapsel1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				screentwo.mouse.allies.removeAllElements();
				maptwo.enemies.removeAllElements();
				maptwo.k=0;
				screentwo.funds=RESET_FUNDS;
				cs2.funds.setText(""+screentwo.funds);
				maptwo.HP=RESET_HP_2;
				maptwo.troyHP.setText(maptwo.HP+"/200");
				screentwo.playTime=0;
				myLayout.show(parent, "maps");
			}			
		});
		quittomapsel2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				screenthree.mouse.allies.removeAllElements();
				mapthree.enemies.removeAllElements();
				mapthree.k=0;
				screenthree.funds=RESET_FUNDS;
				cs3.funds.setText(""+screenthree.funds);
				mapthree.HP=RESET_HP_2;
				mapthree.troyHP.setText(mapthree.HP+"/200");
				screenthree.playTime=0;
				myLayout.show(parent, "maps");
			}			
		});
        selectplayers.addActionListener(new ActionListener(){
        	@Override
            public void actionPerformed(ActionEvent e){
        		cs1.setVisible(true);
            }
        });
        selectplayers1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	cs2.setVisible(true);
            }
        });
        selectplayers2.addActionListener(new ActionListener(){
        	@Override
            public void actionPerformed(ActionEvent e){
        		cs3.setVisible(true);
            }
        });
		parent.setLayout(myLayout);
		parent.add(main,"title");
		parent.add(mapselect, "maps");
		parent.add(playmap1, "map1");
		parent.add(playmap2, "map2");
		parent.add(playmap3, "map3");
		jf.add(parent);
		jf.pack();
		//Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize();
		
		jf.setResizable(false);
		jf.setLocation(250,100);
		jf.setVisible(true);
	}

}
