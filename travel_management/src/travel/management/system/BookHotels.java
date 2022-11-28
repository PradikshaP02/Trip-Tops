package travel.management.system;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookHotels extends JFrame implements ActionListener {

    Choice cHotel, CAC, CFood;
    JLabel labelUser, labelID, labelNum, labelPhone, price;
    JButton checkPrice, bookHotel,back;
    JTextField tfPersons,tfDays;
    String user;

    BookHotels(String user){
        this.user = user;
        setBounds(350,200,1100,600);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        Border raisedbevel = BorderFactory.createRaisedBevelBorder();

        JLabel text = new JLabel("BOOK HOTEL");
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

        JLabel lblPack = new JLabel("Select Hotel");
        lblPack.setBounds(40,110,150,20);
        lblPack.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblPack);

        cHotel = new Choice();
        cHotel.setBounds(250,110,200,25);
        add(cHotel);

        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");

            while(rs.next())
            {
                cHotel.add(rs.getString("Name"));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        JLabel lblNum = new JLabel("Number of people");
        lblNum.setBounds(40,150,150,20);
        lblNum.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblNum);

        tfPersons = new JTextField("I");
        tfPersons.setBounds(250,150,200,25);
        tfPersons.setBorder(raisedbevel);
        add(tfPersons);

        JLabel lblDays = new JLabel("Number of days");
        lblDays.setBounds(40,190,150,20);
        lblDays.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblDays);

        tfDays = new JTextField("1");
        tfDays.setBounds(250,190,200,25);
        tfDays.setBorder(raisedbevel);
        add(tfDays);

        JLabel lblAC = new JLabel("AC / Non-AC");
        lblAC.setBounds(40,270,150,20);
        lblAC.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblAC);

        CAC = new Choice();
        CAC.add("AC");
        CAC.add("Non-AC");
        CAC.setBounds(250,270,200,25);
        add(CAC);

        JLabel lblFood = new JLabel("Food Included");
        lblFood.setBounds(40,230,150,20);
        lblFood.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblFood);

        CFood = new Choice();
        CFood.add("Yes");
        CFood.add("No");
        CFood.setBounds(250,230,200,25);
        add(CFood);

        JLabel lblID = new JLabel("ID");
        lblID.setBounds(40,310,150,20);
        lblID.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblID);

        labelID = new JLabel();
        labelID.setBounds(250,310,200,25);
        labelID.setBorder(raisedbevel);
        add(labelID);

        JLabel lblIDnum = new JLabel("Number");
        lblIDnum.setBounds(40,350,150,25);
        lblIDnum.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblIDnum);

        labelNum = new JLabel();
        labelNum.setBounds(250,350,200,25);
        labelNum.setBorder(raisedbevel);
        add(labelNum);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(40,390,150,25);
        lblPhone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblPhone);

        labelPhone = new JLabel();
        labelPhone.setBounds(250,390,200,25);
        labelPhone.setBorder(raisedbevel);
        add(labelPhone);

        JLabel total = new JLabel("Total Price");
        total.setBounds(40,430,150,25);
        total.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(total);

        price = new JLabel();
        price.setBounds(250,430,200,25);
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
        checkPrice.setBounds(60,490,120,25);
        checkPrice.addActionListener(this);
        add(checkPrice);

        bookHotel = new JButton("Book Hotel");
        bookHotel.setBounds(200,490,120,25);
        bookHotel.addActionListener(this);
        add(bookHotel);

        back = new JButton("Back");
        back.setBounds(340,490,120,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel li2 = new JLabel(i3);
        li2.setBounds(500,10,600,500);
        add(li2);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == checkPrice)
        {
            try
            {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where Name = '"+cHotel.getSelectedItem()+"'");
                while(rs.next())
                {
                    int cost = Integer.parseInt(rs.getString("CostPerPerson"));
                    System.out.println(cost);
                    int food = Integer.parseInt(rs.getString("FoodIncluded"));
                    int ac = Integer.parseInt(rs.getString("ACRoom"));

                    int persons = Integer.parseInt(tfPersons.getText());
                    int days = Integer.parseInt(tfDays.getText());

                    String acSelect = CAC.getSelectedItem();
                    String foodSelect = CFood.getSelectedItem();

                    if((persons * days) > 0)
                    {
                        int total = 0;
                        total += acSelect.equals("AC") ? ac : 0;
                        total += foodSelect.equals("Yes") ? food : 0;

                        total+= cost;
                        total = total * persons * days;
                        price.setText("Rs "+total);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Please enter a valid number! ");
                    }
                }

                String pack = cHotel.getSelectedItem();
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
            catch(Exception e)
            {
                e.printStackTrace();
            }

        }
        else if(ae.getSource() == bookHotel){
            //System.out.printf("Hi from hotel");
            try
            {
                Conn c = new Conn();
                String query = "insert into bookhotel values('"+labelUser.getText()+"','"+cHotel.getSelectedItem()+"','"+tfPersons.getText()+"','"+tfDays.getText()+"','"+CAC.getSelectedItem()+"','"+CFood.getSelectedItem()+"','"+labelID.getText()+"','"+labelNum.getText()+"','"+labelPhone.getText()+"','"+price.getText()+"')";
                c.s.executeUpdate(query);
                System.out.println("hello");
                JOptionPane.showMessageDialog(null,"Booked Hotel Successfully");
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
        new BookHotels("Thamboo");
    }
}
