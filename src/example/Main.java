package example;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final JFrame jf=new JFrame();
		final JPanel parent=new JPanel();
		final CharSelection cs1=new CharSelection();
		final CharSelection2 cs2=new CharSelection2();
		final CharSelection3 cs3=new CharSelection3();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel main=new JPanel(), mapselect=new JPanel();
		JPanel playmap1=new JPanel();
		JPanel playmap2=new JPanel();
		JPanel playmap3=new JPanel();
		JButton start=new JButton("start");
		GridLayout grid=new GridLayout();
		grid.setColumns(2);
		grid.setRows(2);
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
		final MapOne mapone=new MapOne();
		MapTwo maptwo=new MapTwo();
		MapThree mapthree=new MapThree();
		playmap1.add(quittomapsel);
		playmap2.add(quittomapsel1);
		playmap3.add(quittomapsel2);
        playmap1.add(selectplayers);
        playmap2.add(selectplayers1);
        playmap3.add(selectplayers2);
        final Screen1 screenone=new Screen1(mapone);
		final Screen2 screentwo=new Screen2(maptwo);
		final Screen3 screenthree=new Screen3(mapthree);
		MouseTracer mouse=new MouseTracer(mapone, cs1, screenone);
		screenone.addMouseTracer(mouse);
		screenone.addMouseListener(mouse);
		cs1.addScreen(screenone);
		cs2.addScreen(screentwo);
		cs3.addScreen(screenthree);
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
				screenone.playTime=0;
				myLayout.show(parent, "maps");
			}			
		});
		quittomapsel1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				screentwo.playTime=0;
				myLayout.show(parent, "maps");
			}			
		});
		quittomapsel2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
	}

}
