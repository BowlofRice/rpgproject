package example;

import java.awt.CardLayout;
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

                final JPanel good_guy_selection=new JPanel();

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel main=new JPanel(), mapselect=new JPanel();

		JPanel playmap1=new JPanel();
		JPanel playmap2=new JPanel();
		JPanel playmap3=new JPanel();


		JButton start=new JButton("start");
		JButton map1=new JButton("map1");
		JButton map2=new JButton("map2");
		JButton map3=new JButton("map3");
		JButton quit=new JButton("quit");

		JButton quittomapsel=new JButton("quit");
		JButton quittomapsel1=new JButton("quit");
		JButton quittomapsel2=new JButton("quit");


                JButton selectplayers=new JButton("Player Select");
                JButton selectplayers1=new JButton("Player Select");
                JButton selectplayers2=new JButton("Player Select");

                JButton selectArcher=new JButton("Archer");
                JButton selectMelee=new JButton("Melee");
                JButton selectBlue=new JButton("Blue Caster");
                JButton selectRed=new JButton("Red Caster");
                JButton selectGreen=new JButton("Green Caster");
                JButton selectProphet=new JButton("Prophet");

		main.add(start);
		main.add(new Title());

		mapselect.add(map1);
		mapselect.add(map2);
		mapselect.add(map3);
		mapselect.add(quit);
		mapselect.add(new SelectaMap());

		MapOne mapone=new MapOne();
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

		playmap1.add(screenone);
		playmap2.add(screentwo);
		playmap3.add(screenthree);

		final CardLayout myLayout=new CardLayout();
                final CardLayout goodguyLayout=new CardLayout();

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
				screenone.repaint();
			}
			
		});
		map2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myLayout.show(parent, "map2");
				screentwo.repaint();
			}
			
		});
		map3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myLayout.show(parent, "map3");
				screenthree.repaint();
			}
			
		});
		quittomapsel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myLayout.show(parent, "maps");
			}
			
		});
		quittomapsel1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myLayout.show(parent, "maps");
			}
			
		});
		quittomapsel2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myLayout.show(parent, "maps");
			}
			
		});

                selectplayers.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e){

                    }
                });

               selectplayers1.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e){

                    }
                });

               selectplayers2.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e){

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
                
              //  good_guy_selection.setLayout(goodguyLayout);
               // good_guy_selection.add(quit)


	}

}
