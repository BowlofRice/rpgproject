package example;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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









    public CharUpgrade(){
        
        

        

        setTitle("Character Upgrade Menu");
        charUpgrade.setSize(300, 700);
        //test
        System.out.println(num_allies);

        
        BorderLayout borderlay = new BorderLayout();

        JPanel myCheckBoxPanel = new JPanel();
        myCheckBoxPanel.setLayout(new GridLayout(num_allies,1));
        

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

        JPanel myGoodGuysToUpgrade = new JPanel();
        myGoodGuysToUpgrade.setLayout(new GridLayout(num_allies,1));
        

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
        this.a = a;
        num_allies = a.size();
        System.out.println("num_allies now equals "+num_allies);

    }




}
