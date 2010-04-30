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

public class CharUpgrade extends JFrame{

    JFrame charUpgrade = new JFrame();





    public CharUpgrade(){
        
        super();
        JPanel myPanel = new JPanel();
        JButton upgradeGo = new JButton("Upgrade Level");
        EndingListener buttonEar = new EndingListener();
        upgradeGo.addActionListener(buttonEar);
        charUpgrade.setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        myPanel.add(upgradeGo);
        

    }







    public void setVisible(boolean t){
        charUpgrade.setVisible(t);

    }




}