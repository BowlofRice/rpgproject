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


public class CharUpgrade3{
	public JDialog jd=new JDialog();
	public JPanel holder=new JPanel();
	public MouseTracer3 mouse;
	private JButton ok=new JButton("ok");
	public Vector<JCheckBox> boxes=new Vector<JCheckBox>();
	public Vector<JLabel> labels=new Vector<JLabel>();
	private CharSelection3 cs;
	public CharUpgrade3(MouseTracer3 mt){
		GridLayout grid=new GridLayout();
		grid.setColumns(2);
		grid.setRows(0);
		holder.setLayout(grid);
		holder.add(ok);
		holder.add(new JLabel());
		holder.add(new JLabel("    unit"));
		holder.add(new JLabel("upgrade?"));
		jd.setTitle("Upgrade Units");
		jd.add(holder);
		jd.pack();
		jd.setResizable(false);
		jd.setLocationRelativeTo(null);
		this.mouse=mt;
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int choice, remainingfunds=0,total=0;
				int currfunds=Integer.parseInt(cs.funds.getText());
				if(currfunds>=3000){
					choice=JOptionPane.showConfirmDialog(jd, "Are you sure you want to upgrade all the units you have selected? Each upgrade costs 3000G.");
					if(choice==0){
						if(3000<=Integer.parseInt(cs.funds.getText())){
							for(int i=0;i<boxes.size();i++){
								if(boxes.elementAt(i).isSelected()){
									if(mouse.allies.elementAt(i).getLevel()<5){
										total+=3000;
										mouse.allies.elementAt(i).increaseLevel();
										remainingfunds=Integer.parseInt(cs.funds.getText())-3000;
										cs.s.funds=remainingfunds;
										cs.funds.setText(""+remainingfunds);
									}else
										JOptionPane.showMessageDialog(jd, mouse.allies.elementAt(i).getJob()+" cannot be upgraded any further");
								}
							}
							if(currfunds-total==remainingfunds)
								JOptionPane.showMessageDialog(jd, "Units selected were upgraded");
							else
								JOptionPane.showMessageDialog(jd, "Some units could not be upgraded");
						}
					}else if(choice==1 || choice==2)
						JOptionPane.showMessageDialog(jd, "Process was cancelled.");
				}else
					JOptionPane.showMessageDialog(jd, "Not enough funds.");
			}
			
		});
	}
	public void makeUpWindow(Ally a){
			JCheckBox temp=new JCheckBox();
			JLabel label=new JLabel(" "+a.getJob());
			boxes.add(temp);
			labels.add(label);
			holder.add(label);
			holder.add(temp);
			jd.pack();
	}
	public void setVisible(boolean v){
		jd.setVisible(v);
	}
	public void reset(){
		boxes.removeAllElements();
		holder.removeAll();
		holder.add(ok);
		holder.add(new JLabel());
		holder.add(new JLabel("    unit"));
		holder.add(new JLabel("upgrade?"));
	}
	public void setCharSel(CharSelection3 cs){
		this.cs=cs;
	}
}
