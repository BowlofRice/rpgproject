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
import java.util.Array;
import javax.swing.JCheckBox;

public class CharUpgrade extends JFrame {

    JFrame charUpgrade = new JFrame();
    
    //??
    public int num_allies = MouseTracer.allies.size();

    public String[] checkboxes = new String[num_allies];
    public String holder;








    public CharUpgrade(){
        
        super();
        setLayout(new BorderLayout());

        JPanel myCheckBoxPanel = new JPanel();
        myCheckBoxPanel.setLayout(new GridLayout(0,1));
        add(myCheckBoxPanel,BorderLayout.WEST);

        for(int i=0; i<num_allies;i++)
        {
            //attempting to set the value in the string array of i to
            //word CheckBoxi
            checkboxes[i] = ("CheckBox"+i);
            holder = checkboxes[i];

            //attempting to use that same string just created as name for
            //checkbox to be added

            myCheckBoxPanel.add(new JCheckBox(holder));


        }


        JPanel myGoodGuysToUpgrade = new JPanel();
        myGoodGuysToUpgrade.setLayout(new GridLayout(0,1));
        add(myGoodGuysToUpgrade,BorderLayout.CENTER);

        JLabel typeOfGoodGuy = new JLabel();

        for(int i=0;i<num_allies;i++)
        {
            //trying to set holder to contain the type of ally at that point in the vector
            holder = MouseTracer.allies.get(i);

            //setting the label to have holder as the label
            typeOfGoodGuy.setText(holder);

            //adding label to panel
            myGoodGuysToUpgrade.add(typeOfGoodGuy);
        }

        JLabel title = new JLabel("Check Units to Upgrade");
        add(title,BorderLayout.NORTH);




        //adds upgrade level button which has action listener, which uses
        //class EndingListener, which currently just closes program

        JButton upgradeGo = new JButton("Upgrade Level");
        EndingListener buttonEar = new EndingListener();
        upgradeGo.addActionListener(buttonEar);
        charUpgrade.setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        add(upgradeGo,BorderLayout.SOUTH);
        

    }







    public void setVisible(boolean t){
        charUpgrade.setVisible(t);

    }




}