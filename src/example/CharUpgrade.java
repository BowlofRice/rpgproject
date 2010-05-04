package example;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
<<<<<<< HEAD
=======
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.GridLayout;


import java.util.Vector;
import javax.swing.JCheckBox;

public class CharUpgrade extends JFrame {

    JFrame charUpgrade = new JFrame();
    
   
     public int num_allies;

    public String[] checkboxes = new String[num_allies];
    public String holder;
    
    public Vector<JCheckBox> checkers = new Vector<JCheckBox>();
    private Vector<Ally> a;

    JPanel myCheckBoxPanel = new JPanel();
    JPanel myGoodGuysToUpgrade = new JPanel();
    JLabel typeOfGoodGuy = new JLabel();









    public CharUpgrade(){
        
        

        

        setTitle("Character Upgrade Menu");
        charUpgrade.setSize(300, 700);
        //test
        System.out.println(num_allies);

        
        BorderLayout borderlay = new BorderLayout();

        
        myCheckBoxPanel.setLayout(new GridLayout(0,1));
        

        for(int i=0; i<num_allies;i++)
        {
            //attempting to set the value in the string array of i to
            //word CheckBoxi
            
            
            JCheckBox temp = new JCheckBox();
            System.out.println("checkbox added to checkbox vector");
            checkers.add(temp);


            myCheckBoxPanel.add(temp);
            System.out.println("checkbox added to checkbox panel");


        }
        add(myCheckBoxPanel,borderlay.WEST);
        //myCheckBoxPanel.setVisible(true);
        System.out.println("myCheckBoxPanel added to BorderLayout");

        //JPanel myGoodGuysToUpgrade = new JPanel();
        myGoodGuysToUpgrade.setLayout(new GridLayout(0,1));
        

        JLabel typeOfGoodGuy = new JLabel();

        for(int i=0;i<num_allies;i++)
        {
            //trying to set holder to contain the type of ally at that point in the vector
            holder =a.elementAt(i).getJob();

            //setting the label to have holder as the label
            typeOfGoodGuy.setText(holder);

            //adding label to panel
            myGoodGuysToUpgrade.add(typeOfGoodGuy);
        }
        add(myGoodGuysToUpgrade,borderlay.CENTER);
        System.out.println("myGoodGuysToUpgrade panel added to borderlayout");
        

        JLabel title = new JLabel("Check Units to Upgrade");
        add(title,borderlay.NORTH);




       

        JButton upgradeGo = new JButton("Upgrade Level");
        add(upgradeGo,borderlay.SOUTH);
       
        upgradeGo.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {

                    for(int i =0; i < checkers.size(); i++)
                     {
                         if(checkers.elementAt(i).isSelected())
                         {
                            a.elementAt(i).increaseLevel();
                         }
                     }
                    setVisible(false);

    }
        });
        charUpgrade.setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        
        setLocationRelativeTo(null);
        pack();
        setLayout(borderlay);
        setVisible(true);


    }







    public void setVisible(boolean t){
        charUpgrade.setVisible(t);

    }

    public void setAllies(Vector<Ally> a){
        int i=0;
        this.a = a;
        num_allies = a.size();
        System.out.println("num_allies now equals "+num_allies);
        JCheckBox temp = new JCheckBox();
        checkers.add(temp);
        myCheckBoxPanel.add(temp);
        holder =a.elementAt(i).getJob();
        typeOfGoodGuy.setText(holder);
        myGoodGuysToUpgrade.add(typeOfGoodGuy);


    }


>>>>>>> a1abb01eea8dec619e18538e85bff5e75a1bbab4


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
