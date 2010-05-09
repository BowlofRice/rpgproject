package example;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class CharSell2{
	public JDialog jd=new JDialog();
	private JPanel holder=new JPanel();
	public MouseTracer2 mouse;
	private JButton ok=new JButton("ok");
	private Vector<JCheckBox> boxes=new Vector<JCheckBox>();
	private Vector<Integer> boxes2remove=new Vector<Integer>();
	private Vector<JLabel> names=new Vector<JLabel>();
	private Vector<JLabel> prices=new Vector<JLabel>();
	private Vector<JLabel> blanks=new Vector<JLabel>();
	private CharSelection2 cs;
	private Screen2 s;
	private CharUpgrade2 cu;
	public CharSell2(MouseTracer2 mt){
		GridLayout grid=new GridLayout();
		grid.setColumns(2);
		grid.setRows(0);
		holder.setLayout(grid);
		holder.add(ok);
		holder.add(new JLabel());
		holder.add(new JLabel("unit"));
		holder.add(new JLabel("worth"));
		jd.setTitle("Sell Units");
		jd.add(holder);
		jd.pack();
		jd.setResizable(false);
		jd.setLocationRelativeTo(null);
		this.mouse=mt;
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int choice, newfunds=0;
				choice=JOptionPane.showConfirmDialog(jd, "Are you sure you want to sell all the units selected?");
				if(choice==0){
					if(boxes.size()!=0){
						for(int i=0;i<boxes.size();i++){
							if(boxes.elementAt(i).isSelected()){
								boxes2remove.add(i);
								newfunds=Integer.parseInt(cs.funds.getText())+mouse.allies.elementAt(i).getSellWorth();
								cs.s.funds+=mouse.allies.elementAt(i).getSellWorth();
								cs.funds.setText(""+newfunds);
							}
						}
						
						for(int i=0;i<boxes2remove.size();i++){
							holder.remove(blanks.elementAt(boxes2remove.elementAt(i)));
							holder.remove(boxes.elementAt(boxes2remove.elementAt(i)));
							holder.remove(names.elementAt(boxes2remove.elementAt(i)));
							holder.remove(prices.elementAt(boxes2remove.elementAt(i)));
							cu.holder.remove(cu.boxes.elementAt(boxes2remove.elementAt(i)));
							cu.holder.remove(cu.labels.elementAt(boxes2remove.elementAt(i)));
						}
						for(int i=0;i<boxes2remove.size();i++){
							System.out.println(boxes2remove.elementAt((boxes2remove.size()-1)-i));
							boxes.remove((int)boxes2remove.elementAt((boxes2remove.size()-1)-i));
							names.remove((int)boxes2remove.elementAt((boxes2remove.size()-1)-i));
							prices.remove((int)boxes2remove.elementAt((boxes2remove.size()-1)-i));
							cu.boxes.remove((int)boxes2remove.elementAt((boxes2remove.size()-1)-i));
							cu.labels.remove((int)boxes2remove.elementAt((boxes2remove.size()-1)-i));
							mouse.allies.remove((int)boxes2remove.elementAt((boxes2remove.size()-1)-i));
						}
						System.out.println("the size of allies is "+mouse.allies.size());
						if(mouse.allies.size()==0){
							s.playTime=0;
							cu.mouse.canUpgrade=false;
							cu.reset();
							s.repaint();
						}
						boxes2remove.removeAllElements();
						holder.revalidate();
						cu.holder.revalidate();
						cu.jd.repaint();
						cu.jd.pack();
						jd.repaint();
						jd.pack();
					}else{
						JOptionPane.showMessageDialog(jd, "No units left to sell.");
						jd.setVisible(false);
					}
				}else if(choice==1 || choice==2)
					JOptionPane.showMessageDialog(jd, "Process was cancelled.");
			}
		});
	}
	public void makeUpWindow(Ally a){
			JCheckBox temp=new JCheckBox();
			JLabel name=new JLabel(" "+a.getJob());
			JLabel price=new JLabel(" "+a.getSellWorth());
			JLabel blank=new JLabel();
			boxes.add(temp);
			names.add(name);
			prices.add(price);
			blanks.add(blank);
			holder.add(name);
			holder.add(price);
			holder.add(temp);
			holder.add(blank);
			jd.pack();
	}
	public void setVisible(boolean v){
		jd.setVisible(v);
	}
	public void reset(){
		boxes.removeAllElements();
		names.removeAllElements();
		prices.removeAllElements();
		holder.removeAll();
		holder.add(ok);
		holder.add(new JLabel());
		holder.add(new JLabel("unit"));
		holder.add(new JLabel("worth"));
	}
	public void setCharSel(CharSelection2 cs){
		this.cs=cs;
	}
	public void setScreen(Screen2 s){
		this.s=s;
	}
	public void setCharUpgrade(CharUpgrade2 cu){
		this.cu=cu;
	}
}
