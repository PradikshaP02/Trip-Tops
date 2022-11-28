package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    String user;
    JButton addpersonDet, viewpersonDet, uppersonDet, chekPack,bookPack,viewPack,viewHotel,dest,bookHotel,viewBookedHotel,pay;
    Dashboard(String user){
        this.user = user;
        //setBounds(0,0,1560,1000);
        //Instead of hard-coding as above, we try to maximise to the full screen
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel pan1 = new JPanel();
        pan1.setLayout(null);
        pan1.setBackground(new Color(0,0,102));
        pan1.setBounds(0,0,1600,63);
        add(pan1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.png"));
        Image i2 = i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5,0,70,70);;
        pan1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(100,25,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        pan1.add(heading);

        JPanel pan2 = new JPanel();
        pan2.setLayout(null);
        pan2.setBackground(new Color(0,0,102));
        pan2.setBounds(0,63,300,900);
        add(pan2);

        addpersonDet = new JButton("Add personal details");
        addpersonDet.setBounds(0,20,300,50);
        addpersonDet.setBackground(new Color(0,0,102));
        addpersonDet.setForeground(Color.WHITE);
        addpersonDet.setFont(new Font("Tahoma",Font.PLAIN,20));
        //addpersonDet.setMargin(new Insets(0,0,0,60));
        addpersonDet.addActionListener(this);
        pan2.add(addpersonDet);

        uppersonDet = new JButton("Update personal details");
        uppersonDet.setBounds(0,80,300,50);
        uppersonDet.setBackground(new Color(0,0,102));
        uppersonDet.setForeground(Color.WHITE);
        uppersonDet.setFont(new Font("Tahoma",Font.PLAIN,20));
        //addpersonDet.setMargin(new Insets(0,0,0,60));
        uppersonDet.addActionListener(this);
        pan2.add(uppersonDet);

        viewpersonDet = new JButton("View personal details");
        viewpersonDet.setBounds(0,140,300,50);
        viewpersonDet.setBackground(new Color(0,0,102));
        viewpersonDet.setForeground(Color.WHITE);
        viewpersonDet.setFont(new Font("Tahoma",Font.PLAIN,20));
        //addpersonDet.setMargin(new Insets(0,0,0,60));
        viewpersonDet.addActionListener(this);
        pan2.add(viewpersonDet);

        JButton delpersonDet = new JButton("Delete personal details");
        delpersonDet.setBounds(0,200,300,50);
        delpersonDet.setBackground(new Color(0,0,102));
        delpersonDet.setForeground(Color.WHITE);
        delpersonDet.setFont(new Font("Tahoma",Font.PLAIN,20));
        //addpersonDet.setMargin(new Insets(0,0,0,60));
        pan2.add(delpersonDet);

        chekPack = new JButton("Check packages");
        chekPack.setBounds(0,260,300,50);
        chekPack.setBackground(new Color(0,0,102));
        chekPack.setForeground(Color.WHITE);
        chekPack.setFont(new Font("Tahoma",Font.PLAIN,20));
        //addpersonDet.setMargin(new Insets(0,0,0,60));
        chekPack.addActionListener(this);
        pan2.add(chekPack);

        bookPack = new JButton("Book packages");
        bookPack.setBounds(0,310,300,50);
        bookPack.setBackground(new Color(0,0,102));
        bookPack.setForeground(Color.WHITE);
        bookPack.setFont(new Font("Tahoma",Font.PLAIN,20));
        //addpersonDet.setMargin(new Insets(0,0,0,60));
        bookPack.addActionListener(this);
        pan2.add(bookPack);

        viewPack = new JButton("View packages");
        viewPack.setBounds(0,380,300,50);
        viewPack.setBackground(new Color(0,0,102));
        viewPack.setForeground(Color.WHITE);
        viewPack.setFont(new Font("Tahoma",Font.PLAIN,20));
        //addpersonDet.setMargin(new Insets(0,0,0,60));
        viewPack.addActionListener(this);
        pan2.add(viewPack);

        viewHotel = new JButton("View hotels");
        viewHotel.setBounds(0,440,300,50);
        viewHotel.setBackground(new Color(0,0,102));
        viewHotel.setForeground(Color.WHITE);
        viewHotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        //addpersonDet.setMargin(new Insets(0,0,0,60));
        viewHotel.addActionListener(this);
        pan2.add(viewHotel);

        bookHotel = new JButton("Book hotels");
        bookHotel.setBounds(0,500,300,50);
        bookHotel.setBackground(new Color(0,0,102));
        bookHotel.setForeground(Color.WHITE);
        bookHotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        //addpersonDet.setMargin(new Insets(0,0,0,60));
        bookHotel.addActionListener(this);
        pan2.add(bookHotel);

        viewBookedHotel = new JButton("View booked hotel");
        viewBookedHotel.setBounds(0,560,300,50);
        viewBookedHotel.setBackground(new Color(0,0,102));
        viewBookedHotel.setForeground(Color.WHITE);
        viewBookedHotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        //addpersonDet.setMargin(new Insets(0,0,0,60));
        viewBookedHotel.addActionListener(this);
        pan2.add(viewBookedHotel);

        dest = new JButton("Destinations");
        dest.setBounds(0,610,300,50);
        dest.setBackground(new Color(0,0,102));
        dest.setForeground(Color.WHITE);
        dest.setFont(new Font("Tahoma",Font.PLAIN,20));
        //addpersonDet.setMargin(new Insets(0,0,0,60));
        dest.addActionListener(this);
        pan2.add(dest);

        pay = new JButton("Make payment");
        pay.setBounds(0,670,300,50);
        pay.setBackground(new Color(0,0,102));
        pay.setForeground(Color.WHITE);
        pay.setFont(new Font("Tahoma",Font.PLAIN,20));
        //addpersonDet.setMargin(new Insets(0,0,0,60));
        pay.addActionListener(this);
        pan2.add(pay);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,1650,1000);
        add(image);

        JLabel text = new JLabel("Top Trips");
        text.setBounds(750,100,1000,70);
        text.setForeground(Color.red);
        text.setFont(new Font("Algerian",Font.BOLD,50));
        image.add(text);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == addpersonDet)
        {
            new AddCustomer(user);
        }
        else if(ae.getSource() == viewpersonDet)
        {
            new ViewCustomer(user);
        }
        else if(ae.getSource() == uppersonDet)
        {
            new UpdateCustomer(user);
        }
        else if(ae.getSource() == chekPack)
        {
            new CheckPackages();
        }
        else if(ae.getSource() == bookPack)
        {
            new BookPackages(user);
        }
        else if (ae.getSource() == viewPack)
        {
            new ViewPackage(user);
        }
        else if(ae.getSource() == viewHotel)
        {
            new CheckHotels();
        }
        else if(ae.getSource() == dest)
        {
            new Destinations();
        }
        else if(ae.getSource() == bookHotel)
        {
            new BookHotels(user);
        }
        else if(ae.getSource() == viewBookedHotel)
        {
            new ViewBookedHotel(user);
        }
        else if(ae.getSource() == pay)
        {
            new Payment();
        }
    }

    public static void main(String[] args){
        new Dashboard("");
    }
}
