package travel.management.system;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.*;

public class ViewPackage extends JFrame implements ActionListener {
    JButton back;
    ViewPackage(String user)
    {
        Border raisedbevel = BorderFactory.createRaisedBevelBorder();

        setBounds(450,200,900,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(60,0,300,30);
        add(text);

        JLabel lbluser = new JLabel("Username");
        lbluser.setBounds(30,50,150,25);
        add(lbluser);

        JLabel labelUser = new JLabel();
        labelUser.setBounds(220,50,150,25);
        labelUser.setBorder(raisedbevel);
        add(labelUser);

        JLabel lblpac = new JLabel("Package");
        lblpac.setBounds(30,90,150,25);
        add(lblpac);

        JLabel labelPack = new JLabel();
        labelPack.setBounds(220,90,150,25);
        labelPack.setBorder(raisedbevel);
        add(labelPack);

        JLabel lblper = new JLabel("Total Persons");
        lblper.setBounds(30,130,150,25);
        add(lblper);

        JLabel labelNum = new JLabel();
        labelNum.setBounds(220,130,150,25);
        labelNum.setBorder(raisedbevel);
        add(labelNum);

        JLabel lblID = new JLabel("ID");
        lblID.setBounds(30,170,150,25);
        add(lblID);

        JLabel labelID = new JLabel();
        labelID.setBounds(220,170,150,25);
        labelID.setBorder(raisedbevel);
        add(labelID);

        JLabel lblNum = new JLabel("Number");
        lblNum.setBounds(30,210,150,25);
        add(lblNum);

        JLabel labelNumb = new JLabel();
        labelNumb.setBounds(220,210,150,25);
        labelNumb.setBorder(raisedbevel);
        add(labelNumb);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(30,250,150,25);
        add(lblPhone);

        JLabel labelPh = new JLabel();
        labelPh.setBounds(220,250,150,25);
        labelPh.setBorder(raisedbevel);
        add(labelPh);

        JLabel lblPri = new JLabel("Price");
        lblPri.setBounds(30,290,150,25);
        add(lblPri);

        JLabel labelPrice = new JLabel();
        labelPrice.setBounds(220,290,150,25);
        labelPrice.setBorder(raisedbevel);
        add(labelPrice);

        back = new JButton("Back");
        back.setBounds(220,360,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,20,500,400);
        add(image);

        try{
            Conn conn = new Conn();
            String query = "select * from bookpack where Username = '"+user+"'";
            ResultSet rs = conn.s.executeQuery(query);

            while(rs.next())
            {
                labelUser.setText(rs.getString("Username"));
                labelPack.setText(rs.getString("Package"));
                labelID.setText(rs.getString("ID"));
                labelNum.setText(rs.getString("Persons"));
                labelNumb.setText(rs.getString("Number"));
                labelPh.setText(rs.getString("Phone"));
                labelPrice.setText(rs.getString("Price"));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }

    public static void main(String[] args)
    {
        new ViewPackage("Thamboo");

    }
}
