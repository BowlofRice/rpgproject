package example;

import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CharUpgrade{
	public JDialog jd=new JDialog();
	private MouseTracer mt;

	public CharUpgrade(MouseTracer mt){
		this.mt=mt;
	}
	public void makeUpWindow(){
		System.out.println("making window size of allies is "+mt.allies.size());
		JPanel holder=new JPanel();
		JButton ok=new JButton("ok");
		Vector<JCheckBox> boxes=new Vector<JCheckBox>();
		GridLayout grid=new GridLayout();
		grid.setColumns(2);
		grid.setRows(0);
		holder.setLayout(grid);
		for(int i=0;i<mt.allies.size();i++){
			System.out.println("loop "+i);
			JCheckBox temp=new JCheckBox();
			boxes.add(temp);
			holder.add(new JLabel(mt.allies.elementAt(i).getJob()));
			holder.add(temp);
		}
		holder.add(ok);
		jd.add(holder);
	}
	public void setVisible(boolean v){
		jd.setVisible(v);
	}
}
