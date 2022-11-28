package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Destinations extends JFrame{
    //A slideshow
    //Different labels for each and every image

    Destinations()
    {
        setBounds(500,200,800,600);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/des.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,800,600);
        add(l1);

        setVisible(true);
        }



    public static void main(String[] args)
    {

        new Destinations();
    }
}
