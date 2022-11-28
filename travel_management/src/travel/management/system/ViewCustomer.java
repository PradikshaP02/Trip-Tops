package travel.management.system;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.*;

public class ViewCustomer extends JFrame implements ActionListener {
    JButton back;
    ViewCustomer(String user)
    {
        Border raisedbevel = BorderFactory.createRaisedBevelBorder();
        
        setBounds(450,180,870,625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lbluser = new JLabel("Username");
        lbluser.setBounds(30,50,150,25);
        add(lbluser);

        JLabel labelUser = new JLabel();
        labelUser.setBounds(220,50,150,25);
        labelUser.setBorder(raisedbevel);
        add(labelUser);

        JLabel lblID = new JLabel("ID");
        lblID.setBounds(30,110,150,25);
        add(lblID);

        JLabel labelID = new JLabel();
        labelID.setBounds(220,110,150,25);
        labelID.setBorder(raisedbevel);
        add(labelID);

        JLabel lblNum = new JLabel("Number");
        lblNum.setBounds(30,170,150,25);
        add(lblNum);

        JLabel labelNum = new JLabel();
        labelNum.setBounds(220,170,150,25);
        labelNum.setBorder(raisedbevel);
        add(labelNum);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30,230,150,25);
        add(lblName);

        JLabel labelName = new JLabel();
        labelName.setBounds(220,230,150,25);
        labelName.setBorder(raisedbevel);
        add(labelName);

        JLabel lblgen = new JLabel("Gender");
        lblgen.setBounds(30,290,150,25);
        add(lblgen);

        JLabel labelGen = new JLabel();
        labelGen.setBounds(220,290,150,25);
        labelGen.setBorder(raisedbevel);
        add(labelGen);

        JLabel lblCoun = new JLabel("Country");
        lblCoun.setBounds(500,50,150,25);
        add(lblCoun);

        JLabel labelCtry = new JLabel();
        labelCtry.setBounds(690,50,150,25);
        labelCtry.setBorder(raisedbevel);
        add(labelCtry);

        JLabel lblad = new JLabel("Address");
        lblad.setBounds(500,110,150,25);
        add(lblad);

        JLabel labelAddr = new JLabel();
        labelAddr.setBounds(690,110,150,25);
        labelAddr.setBorder(raisedbevel);
        add(labelAddr);

        JLabel lblph = new JLabel("Phone number");
        lblph.setBounds(500,170,150,25);
        add(lblph);

        JLabel labelPhone = new JLabel();
        labelPhone.setBounds(690,170,150,25);
        labelPhone.setBorder(raisedbevel);
        add(labelPhone);

        JLabel lblem = new JLabel("Email");
        lblem.setBounds(500,230,150,25);
        add(lblem);

        JLabel labelEmail = new JLabel();
        labelEmail.setBounds(690,230,150,25);
        labelEmail.setBorder(raisedbevel);
        add(labelEmail);

        back = new JButton("Back");
        back.setBounds(410,350,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(120,400,600,200);
        add(image);

        try{
            Conn conn = new Conn();
            String query = "select * from customer where Username = '"+user+"'";
            ResultSet rs = conn.s.executeQuery(query);

            while(rs.next())
            {
                labelUser.setText(rs.getString("Username"));
                labelID.setText(rs.getString("ID"));
                labelNum.setText(rs.getString("Number"));
                labelName.setText(rs.getString("Name"));
                labelGen.setText(rs.getString("Gender"));
                labelCtry.setText(rs.getString("Country"));
                labelAddr.setText(rs.getString("Address"));
                labelPhone.setText(rs.getString("Phone"));
                labelEmail.setText(rs.getString("Email"));
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
        new ViewCustomer("Thamboo");

    }
}
