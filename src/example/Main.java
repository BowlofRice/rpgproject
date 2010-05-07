package example;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Title title=new Title();
		final int RESET_FUNDS=20000;
		final int RESET_HP=100;
		final int RESET_HP_2=200;
		final int RESET_ROUND=1;
		final JFrame jf=new JFrame();
		final JPanel parent=new JPanel();
		final CharSelection cs1=new CharSelection(jf);
		final CharSelection2 cs2=new CharSelection2(jf);
		final CharSelection3 cs3=new CharSelection3(jf);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JPanel main=new JPanel();
		JPanel mapselect=new JPanel(), playmap1Menu=new JPanel(), playmap2Menu=new JPanel(), playmap3Menu=new JPanel();
		JPanel playmap1=new JPanel();
		JPanel playmap2=new JPanel();
		JPanel playmap3=new JPanel();
		jf.addWindowListener(new WindowAdapter(){
			public void windowActivated(WindowEvent e){
				System.out.println("i was activated");
				title.paint(title.getGraphics());
			}
		});
		JButton start=new JButton("start");
		GridLayout grid=new GridLayout();
		grid.setColumns(2);
		grid.setRows(6);
		JPanel mapselectbuttons=new JPanel();
		mapselectbuttons.setLayout(grid);
		JButton map1=new JButton("map1");
		JButton map2=new JButton("map2");
		JButton map3=new JButton("map3");
		JButton quit=new JButton("quit");
        JButton quit2=new JButton("quit");
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
        JButton healtroy=new JButton("restore troy");
        JButton healtroy1=new JButton("restore troy");
        JButton healtroy2=new JButton("restore troy");
        JButton startRound = new JButton("Play!");
        JButton startRound2 = new JButton("Play!");
        JButton startRound3 = new JButton("Play!");
        main.add(quit2);
        main.add(start);
        main.add(title);
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
		final MouseTracer mouse=new MouseTracer(mapone, cs1, screenone, cs1.charHolder);
		mapone.setTracer(mouse);
		final CharUpgrade cu=new CharUpgrade(mouse);
		final CharSell sellpanel=new CharSell(mouse);
		cu.setCharSel(cs1);
		sellpanel.setCharSel(cs1);
		cs1.setUpgradePanel(cu);
		cs1.setSellPanel(sellpanel);
		mouse.setUpgrade(cu);
		mouse.setSell(sellpanel);
		final MouseTracer2 mouse2=new MouseTracer2(maptwo, cs2, screentwo, cs2.charHolder);
		maptwo.setTracer(mouse2);
		final CharUpgrade2 cu2=new CharUpgrade2(mouse2);
		cu2.setCharSel(cs2);
		cs2.setUpgradePanel(cu2);
		mouse2.setUpgrade(cu2);
		final MouseTracer3 mouse3=new MouseTracer3(mapthree, cs3, screenthree, cs3.charHolder);
		mapthree.setTracer(mouse3);
		final CharUpgrade3 cu3=new CharUpgrade3(mouse3);
		cu3.setCharSel(cs3);
		cs3.setUpgradePanel(cu3);
		mouse3.setUpgrade(cu3);
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
		playmap1Menu.add(healtroy);
		playmap1Menu.add(startRound);
		playmap1Menu.add(new JLabel());
		playmap1Menu.add(new JLabel());
		playmap1Menu.add(new JLabel("                 Round"));
		screenone.roundDisp.setEditable(false);
		playmap1Menu.add(screenone.roundDisp);
		playmap2Menu.add(new JLabel("Funds/Score: "));
		playmap2Menu.add(cs2.funds);
		playmap2Menu.add(new JLabel("Troy HP: "));
		maptwo.troyHP.setEditable(false);
		playmap2Menu.add(maptwo.troyHP);
		playmap2Menu.add(healtroy1);
		playmap2Menu.add(startRound2);
		playmap2Menu.add(new JLabel());
		playmap2Menu.add(new JLabel());
		playmap2Menu.add(new JLabel("                 Round"));
		screentwo.roundDisp.setEditable(false);
		playmap2Menu.add(screentwo.roundDisp);
		playmap3Menu.add(new JLabel("Funds/Score: "));
		playmap3Menu.add(cs3.funds);
		playmap3Menu.add(new JLabel("Troy HP: "));
		mapthree.troyHP.setEditable(false);
		playmap3Menu.add(mapthree.troyHP);
		playmap3Menu.add(healtroy2);
		playmap3Menu.add(startRound3);
		playmap3Menu.add(new JLabel());
		playmap3Menu.add(new JLabel());
		playmap3Menu.add(new JLabel("                 Round"));
		screenthree.roundDisp.setEditable(false);
		playmap3Menu.add(screenthree.roundDisp);
		playmap1.add(playmap1Menu);
		playmap2.add(playmap2Menu);
		playmap3.add(playmap3Menu);
		playmap1.add(screenone);
		playmap2.add(screentwo);
		playmap3.add(screenthree);
		final CardLayout myLayout=new CardLayout();
        quit2.addActionListener(new ActionListener(){
        	@Override
            public void actionPerformed(ActionEvent e){
        		System.exit(0);
            }
        });
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
		startRound.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (mouse.allies.size() != 0) {
					cs1.setVisible(false);
					screenone.playTime = 1;
					screenone.roundDisp.setText(""+screenone.round);
					screenone.repaint();
				}else if(screenone.playTime==2)
					screenone.repaint();
				else
					JOptionPane.showMessageDialog(jf,"No units deployed. Add some units to play");
			}

		});
		startRound2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (mouse2.allies.size() != 0) {
					cs2.setVisible(false);
					screentwo.playTime = 1;
					screentwo.roundDisp.setText(""+screentwo.round);
					screentwo.repaint();
				}else if(screentwo.playTime==2)
					screentwo.repaint();
				else
					JOptionPane.showMessageDialog(jf,"No units deployed. Add some units to play");
			}

		});
		startRound3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (mouse3.allies.size() != 0) {
					cs3.setVisible(false);
					screenthree.playTime = 1;
					screenthree.roundDisp.setText(""+screenthree.round);
					screenthree.repaint();
				}else if(screenthree.playTime==2)
					screenthree.repaint();
				else
					JOptionPane.showMessageDialog(jf,"No units deployed. Add some units to play");
			}

		});
		healtroy.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int choice;
				if(Integer.parseInt(cs1.funds.getText())>=10000 && mapone.HP<100){
					choice=JOptionPane.showConfirmDialog(jf, "Do you want to restore Troy? Restoration costs 10000G.");
					if(choice==0){
						int leftovers=Integer.parseInt(cs1.funds.getText())-10000;
						cs1.funds.setText(""+leftovers);
						cs1.s.funds=leftovers;
						mapone.HP=100;
						mapone.troyHP.setText(mapone.HP+"/100");
						for(int i=0;i<mapone.castles.size();i++)
							mapone.castles.elementAt(i).health=100;
						JOptionPane.showMessageDialog(jf, "Troy was fully restored.");
					}else if(choice==1 || choice==2)
						JOptionPane.showMessageDialog(jf, "Restoration was cancelled");
					//yes = 0 no = 1 cancel = 2
				}else
					JOptionPane.showMessageDialog(jf, "Troy could not be restored or does not need to be restored at this time. Restoration costs 10000G.");
			}
			
		});
		healtroy1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int choice;
				if(Integer.parseInt(cs2.funds.getText())>=10000 && maptwo.HP<200){
					choice=JOptionPane.showConfirmDialog(jf, "Do you want to restore Troy? Restoration costs 10000G.");
					if(choice==0){
						int leftovers=Integer.parseInt(cs2.funds.getText())-10000;
						cs2.funds.setText(""+leftovers);
						cs2.s.funds=leftovers;
						maptwo.HP=200;
						maptwo.troyHP.setText(maptwo.HP+"/200");
						for(int i=0;i<maptwo.castles.size();i++)
							maptwo.castles.elementAt(i).health=100;
						JOptionPane.showMessageDialog(jf, "Troy was fully restored.");
					}else if(choice==1 || choice==2)
						JOptionPane.showMessageDialog(jf, "Restoration was cancelled");
					//yes = 0 no = 1 cancel = 2
				}else
					JOptionPane.showMessageDialog(jf, "Troy could not be restored or does not need to be restored at this time. Restoration costs 10000G.");
			}
			
		});
		healtroy2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int choice;
				if(Integer.parseInt(cs3.funds.getText())>=10000 && mapthree.HP<200){
					choice=JOptionPane.showConfirmDialog(jf, "Do you want to restore Troy? Restoration costs 10000G.");
					if(choice==0){
						int leftovers=Integer.parseInt(cs3.funds.getText())-10000;
						cs3.funds.setText(""+leftovers);
						cs3.s.funds=leftovers;
						mapthree.HP=200;
						mapthree.troyHP.setText(mapthree.HP+"/200");
						for(int i=0;i<mapthree.castles.size();i++)
							mapthree.castles.elementAt(i).health=100;
						JOptionPane.showMessageDialog(jf, "Troy was fully restored.");
					}else if(choice==1 || choice==2)
						JOptionPane.showMessageDialog(jf, "Restoration was cancelled");
					//yes = 0 no = 1 cancel = 2
				}else
					JOptionPane.showMessageDialog(jf, "Troy could not be restored or does not need to be restored at this time. Restoration costs 10000G.");
			}
			
		});
		quittomapsel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				screenone.mouse.allies.removeAllElements();
				mouse.canUpgrade=false;
				mouse.canSell=false;
				cu.reset();
				sellpanel.reset();
				mapone.enemies.removeAllElements();
				mapone.bossSpawns.removeAllElements();
				mapone.k=0;
				mapone.h=0;
				screenone.funds=RESET_FUNDS;
				cs1.funds.setText(""+screenone.funds);
				cs1.charHolder.setVisible(false);
				mapone.troy.health=RESET_HP;
				mapone.HP=RESET_HP;
				mapone.troyHP.setText(mapone.HP+"/100");
				screenone.round=RESET_ROUND;
				screenone.roundDisp.setText(""+screenone.round);
				screenone.playTime=0;
				myLayout.show(parent, "maps");
			}			
		});
		quittomapsel1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				screentwo.mouse.allies.removeAllElements();
				mouse2.canUpgrade=false;
				cu2.reset();
				maptwo.enemies.removeAllElements();
				maptwo.bossSpawns.removeAllElements();
				maptwo.k=0;
				maptwo.h=0;
				screentwo.funds=RESET_FUNDS;
				cs2.funds.setText(""+screentwo.funds);
				cs2.charHolder.setVisible(false);
				maptwo.troyA.health=RESET_HP_2;
				maptwo.troyB.health=RESET_HP_2;
				maptwo.HP=RESET_HP_2;
				maptwo.troyHP.setText(maptwo.HP+"/200");
				screentwo.round=RESET_ROUND;
				screentwo.roundDisp.setText(""+screentwo.round);
				screentwo.playTime=0;
				myLayout.show(parent, "maps");
			}			
		});
		quittomapsel2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				screenthree.mouse.allies.removeAllElements();
				mouse3.canUpgrade=false;
				cu3.reset();
				mapthree.enemies.removeAllElements();
				mapthree.bossSpawns.removeAllElements();
				mapthree.k=0;
				mapthree.h=0;
				screenthree.funds=RESET_FUNDS;
				cs3.funds.setText(""+screenthree.funds);
				cs3.charHolder.setVisible(false);
				mapthree.troyA.health=RESET_HP_2;
				mapthree.troyB.health=RESET_HP_2;
				mapthree.HP=RESET_HP_2;
				mapthree.troyHP.setText(mapthree.HP+"/200");
				screenthree.round=RESET_ROUND;
				screenthree.roundDisp.setText(""+screenthree.round);
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
