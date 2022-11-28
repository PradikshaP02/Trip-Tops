package travel.management.system;


import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ViewBookedHotel extends JFrame {
    private JPanel contentPane;
    Choice c1;
    public ViewBookedHotel(String username)  {
        Border raisedbevel = BorderFactory.createRaisedBevelBorder();

        setBounds(580, 220, 850, 600);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 350,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(450,50,350,350);
        add(la1);

        JLabel text = new JLabel("VIEW BOOKED HOTEL");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(60,0,300,30);
        add(text);

        JLabel lb3 = new JLabel("Username");
        lb3.setBounds(35, 70, 200, 14);
        contentPane.add(lb3);

        JLabel l1 = new JLabel();
        l1.setBounds(230, 70, 200, 14);
        l1.setBorder(raisedbevel);
        contentPane.add(l1);

        JLabel lblId = new JLabel("Name");
        lblId.setBounds(35, 110, 200, 14);
        contentPane.add(lblId);

        JLabel l2 = new JLabel();
        l2.setBounds(230, 110, 200, 14);
        l2.setBorder(raisedbevel);
        contentPane.add(l2);

        JLabel lb2 = new JLabel("Number of Persons");
        lb2.setBounds(35, 150, 200, 14);
        contentPane.add(lb2);

        JLabel l3 = new JLabel();
        l3.setBounds(230, 150, 200, 14);
        l3.setBorder(raisedbevel);
        contentPane.add(l3);

        JLabel lblName_1 = new JLabel("Number of Days");
        lblName_1.setBounds(35, 190, 200, 14);
        contentPane.add(lblName_1);

        JLabel l4 = new JLabel();
        l4.setBounds(230, 190, 200, 14);
        l4.setBorder(raisedbevel);
        contentPane.add(l4);


        JLabel lblGender = new JLabel("AC / Non-AC");
        lblGender.setBounds(35, 230, 200, 14);
        contentPane.add(lblGender);

        JLabel l5 = new JLabel();
        l5.setBounds(230, 230, 200, 14);
        l5.setBorder(raisedbevel);
        contentPane.add(l5);

        JLabel lblCountry = new JLabel("Food Included (Yes/No)");
        lblCountry.setBounds(35, 270, 200, 14);
        contentPane.add(lblCountry);

        JLabel l6 = new JLabel();
        l6.setBounds(230, 270, 200, 14);
        l6.setBorder(raisedbevel);
        contentPane.add(l6);

        JLabel lblReserveRoomNumber = new JLabel("ID");
        lblReserveRoomNumber.setBounds(35, 310, 200, 14);
        contentPane.add(lblReserveRoomNumber);

        JLabel l7 = new JLabel();
        l7.setBounds(230, 310, 200, 14);
        l7.setBorder(raisedbevel);
        contentPane.add(l7);

        JLabel lblCheckInStatus = new JLabel("Number");
        lblCheckInStatus.setBounds(35, 350, 200, 14);
        contentPane.add(lblCheckInStatus);

        JLabel l8 = new JLabel();
        l8.setBounds(230, 350, 200, 14);
        l8.setBorder(raisedbevel);
        contentPane.add(l8);


        JLabel lblDeposite = new JLabel("Phone");
        lblDeposite.setBounds(35, 390, 200, 14);
        contentPane.add(lblDeposite);

        JLabel l9 = new JLabel();
        l9.setBounds(230, 390, 200, 14);
        l9.setBorder(raisedbevel);
        contentPane.add(l9);

        JLabel la2 = new JLabel("Cost");
        la2.setBounds(35, 430, 200, 14);
        contentPane.add(la2);

        JLabel l10 = new JLabel();
        l10.setBounds(230, 430, 200, 14);
        l10.setBorder(raisedbevel);
        contentPane.add(l10);

        setVisible(true);

        Conn c = new Conn();
        try{

            ResultSet rs = c.s.executeQuery("select * from bookHotel where username = '"+username+"'");
            while(rs.next()){
                l1.setText(rs.getString("Username"));
                l2.setText(rs.getString("Name"));
                l3.setText(rs.getString("Persons"));
                l4.setText(rs.getString("Days"));
                l5.setText(rs.getString("AC"));
                l6.setText(rs.getString("Food"));
                l7.setText(rs.getString("ID"));
                l8.setText(rs.getString("Number"));
                l9.setText(rs.getString("Phone"));
                l10.setText(rs.getString("Price"));
            }
            rs.close();
        }
        catch(SQLException e){}


        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnExit.setBounds(270, 470, 120, 30);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
        new ViewBookedHotel("Thamboo");
    }
}
