package travel.management.system;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookPackages extends JFrame implements ActionListener {

    Choice cPack;
    JLabel labelUser, labelID, labelNum, labelPhone, price;
    JButton checkPrice, bookPack,back;
    JTextField tfPersons;
    String user;

    BookPackages(String user){
        this.user = user;
        setBounds(350,200,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        Border raisedbevel = BorderFactory.createRaisedBevelBorder();

        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);

        JLabel lbluser = new JLabel("Username");
        lbluser.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbluser.setBounds(40,70,150,20);
        add(lbluser);

        labelUser = new JLabel();
        labelUser.setBounds(250,70,200,20);
        labelUser.setBorder(raisedbevel);
        labelUser.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelUser);

        JLabel lblPack = new JLabel("Select Package");
        lblPack.setBounds(40,110,150,20);
        lblPack.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblPack);

        cPack = new Choice();
        cPack.add("Gold Package");
        cPack.add("Silver Package");
        cPack.add("Bronze Package");
        cPack.setBounds(250,110,200,25);
        add(cPack);

        JLabel lblNum = new JLabel("Number of people");
        lblNum.setBounds(40,150,150,20);
        lblNum.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblNum);

        tfPersons = new JTextField("I");
        tfPersons.setBounds(250,150,200,25);
        tfPersons.setBorder(raisedbevel);
        add(tfPersons);

        JLabel lblID = new JLabel("ID");
        lblID.setBounds(40,190,150,20);
        lblID.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblID);

        labelID = new JLabel();
        labelID.setBounds(250,190,200,25);
        labelID.setBorder(raisedbevel);
        add(labelID);

        JLabel lblIDnum = new JLabel("Number");
        lblIDnum.setBounds(40,230,150,25);
        lblIDnum.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblIDnum);

        labelNum = new JLabel();
        labelNum.setBounds(250,230,200,25);
        labelNum.setBorder(raisedbevel);
        add(labelNum);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(40,270,150,25);
        lblPhone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblPhone);

        labelPhone = new JLabel();
        labelPhone.setBounds(250,270,200,25);
        labelPhone.setBorder(raisedbevel);
        add(labelPhone);

        JLabel total = new JLabel("Total Price");
        total.setBounds(40,310,150,25);
        total.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(total);

        price = new JLabel();
        price.setBounds(250,310,200,25);
        price.setBorder(raisedbevel);
        add(price);

        try{
            Conn conn = new Conn();
            String query = "select * from customer where Username = '"+user+"'";
            ResultSet rs = conn.s.executeQuery(query);

            while(rs.next())
            {
                labelUser.setText(rs.getString("Username"));
                labelID.setText(rs.getString("ID"));
                labelNum.setText(rs.getString("Number"));
                labelPhone.setText(rs.getString("Phone"));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        checkPrice = new JButton("Check Price");
        checkPrice.setBounds(60,380,120,25);
        checkPrice.addActionListener(this);
        add(checkPrice);

        bookPack = new JButton("Book Package");
        bookPack.setBounds(200,380,120,25);
        bookPack.addActionListener(this);
        add(bookPack);

        back = new JButton("Back");
        back.setBounds(340,380,120,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel li2 = new JLabel(i3);
        li2.setBounds(520,10,500,500);
        add(li2);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == checkPrice)
        {
            String pack = cPack.getSelectedItem();
            int cost = 0;
            if(pack.equals("Gold Package")){
                cost+=12000;
            }
            else if(pack.equals("Silver Package")){
                cost+=25000;
            }
            else {
                cost+=32000;
            }
            int per = Integer.parseInt(tfPersons.getText());
            cost *= per;
            price.setText("Rs "+cost+" /-");
        }
        else if(ae.getSource() == bookPack){
            try
            {
                //create table bookpack(Username varchar(50),Package varchar(30),Persons varchar(20),ID varchar(30), Number varchar(30), Phone varchar(15),Price varchar(20));
                //System.out.println("Hi");
                Conn c = new Conn();
                String query = "insert into bookpack values('"+labelUser.getText()+"','"+cPack.getSelectedItem()+"','"+tfPersons.getText()+"','"+labelID.getText()+"','"+labelNum.getText()+"','"+labelPhone.getText()+"','"+price.getText()+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Booked Package Successfully");
                setVisible(false);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        }
        else {
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new BookPackages("Thamboo");
    }
}
