package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class CheckPackages extends JFrame {

    CheckPackages()
    {
        setBounds(450,200,900,600);

        //Making the value dynamic
        String[] package1 = new String[]{"package1.jpg","GOLD PACKAGE","6 days and 7 Nights", "Airport Assistance at Aiport", "Half Day City Tour", "Welcome drinks on Arrival", "Daily Buffet", "Full Day 3 Island Cruise", "English Speaking Guide", "BOOK NOW", "Summer Special", "Rs 12000 only"};
        String[] package2 = new String[]{"package2.jpg","SILVER PACKAGE","4 days and 3 Nights", "Toll Free and Entrance Free Tickets", "Meet and Greet at Aiport", "Welcome drinks on Arrival", "Night Safari", "Full Day 3 Island Cruise", "Cruise with Dinner", "BOOK NOW", "Winter Special", "Rs 25000 only"};
        String[] package3 = new String[]{"package3.jpg","BRONZE PACKAGE","6 days and 5 Nights", "Return Airfare", "Free Clubbing, Horse Riding & other Games", "Welcome drinks on Arrival", "Daily Buffet", "Stay in 5 Star Hotel", "BBQ Dinner", "BOOK NOW", "Winter Special", "Rs 32000 only"};

        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel p1 = createPanel(package1);
        tabbedPane.addTab("Package 1", null, p1);

        JPanel p2 = createPanel(package2);
        tabbedPane.addTab("Package 2", null, p2);

        JPanel p3 = createPanel(package3);
        tabbedPane.addTab("Package 3", null, p3);

        add(tabbedPane, BorderLayout.CENTER);

        setVisible(true);
    }

    //Function that returns JPanel
    public JPanel createPanel(String[] pack)
    {

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.white);
        //add(p1);

        JLabel l1 = new JLabel(pack[1]);
        l1.setBounds(50,5,300,25);
        l1.setForeground(new Color(207,181,59));
        l1.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(l1);

        JLabel l2 = new JLabel(pack[2]);
        l2.setBounds(50,60,300,30);
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Tahoma",Font.HANGING_BASELINE,20));
        p1.add(l2);

        JLabel l3 = new JLabel(pack[3]);
        l3.setBounds(50,110,300,30);
        l3.setForeground(Color.RED);
        l3.setFont(new Font("Tahoma",Font.CENTER_BASELINE,20));
        p1.add(l3);

        JLabel l4 = new JLabel(pack[4]);
        l4.setBounds(50,160,300,30);
        l4.setForeground(Color.RED);
        l4.setFont(new Font("Tahoma",Font.LAYOUT_LEFT_TO_RIGHT,20));
        p1.add(l4);

        JLabel l5 = new JLabel(pack[5]);
        l5.setBounds(50,210,300,30);
        l5.setForeground(Color.RED);
        l5.setFont(new Font("Tahoma",Font.HANGING_BASELINE,20));
        p1.add(l5);

        JLabel l6 = new JLabel(pack[6]);
        l6.setBounds(50,260,300,30);
        l6.setForeground(Color.RED);
        l6.setFont(new Font("Tahoma",Font.CENTER_BASELINE,20));
        p1.add(l6);

        JLabel l7 = new JLabel(pack[7]);
        l7.setBounds(50,310,300,30);
        l7.setForeground(Color.RED);
        l7.setFont(new Font("Tahoma",Font.LAYOUT_LEFT_TO_RIGHT,20));
        p1.add(l7);

        JLabel l8 = new JLabel(pack[8]);
        l8.setBounds(50,360,300,30);
        l8.setForeground(Color.RED);
        l8.setFont(new Font("Tahoma",Font.HANGING_BASELINE,20));
        p1.add(l8);

        JLabel l9 = new JLabel(pack[9]);
        l9.setBounds(50,430,300,30);
        l9.setForeground(Color.BLUE);
        l9.setFont(new Font("Tahoma",Font.BOLD,25));
        p1.add(l9);

        JLabel l10 = new JLabel(pack[10]);
        l10.setBounds(50,480,300,30);
        l10.setForeground(Color.BLUE);
        l10.setFont(new Font("Tahoma",Font.BOLD,25));
        p1.add(l10);

        JLabel l11 = new JLabel(pack[11]);
        l11.setBounds(500,430,300,30);
        l11.setForeground(Color.GREEN);
        l11.setFont(new Font("Tahoma",Font.BOLD,25));
        p1.add(l11);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[0]));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel li2 = new JLabel(i3);
        li2.setBounds(350,10,500,500);
        p1.add(li2);

        return p1;

    }
    public static void main(String[] args)
    {
        new CheckPackages();
    }
}
