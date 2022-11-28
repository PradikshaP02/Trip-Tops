/*package travel.management.system;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateCustomer extends JFrame {
    JLabel userName, lblName;
    JComboBox comboID;
    JTextField tfnumber, tfCountry, tfAddress, tfPhone, tfEmail;
    JRadioButton rMale, rFemale;
    JButton add, back;
    UpdateCustomer(){
    UpdateCustomer(String user2) {

            Border loweredbevel = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);

            setBounds(500, 200, 850, 550);
            setLayout(null);
            getContentPane().setBackground(Color.WHITE);

            JLabel text = new JLabel("Update Customer Details");
            text.setBounds(50, 0, 300, 25);
            text.setFont(new Font("Tahoma", Font.PLAIN, 20));
            add(text);

            JLabel user = new JLabel("Username");
            user.setBounds(30, 50, 150, 25);
            add(user);

            //The user details will be displayed here
            userName = new JLabel();
            userName.setBounds(220, 50, 150, 25);
            userName.setBorder(loweredbevel);
            add(userName);

            JLabel idUser = new JLabel("Identity");
            idUser.setBounds(30, 90, 150, 25);
            add(idUser);

            //This is similar to using choice class and add method in sign-up
            //Creating a string 1D object and having values
            //Not mandate to use add function
            comboID = new JComboBox(new String[]{"Passport", "Pan Card", "Aadhar card", "Ration Card"});
            comboID.setBounds(220, 90, 150, 25);
            comboID.setBackground(Color.white);
            add(comboID);

            JLabel lblID = new JLabel("Number");
            lblID.setBounds(30, 130, 150, 25);
            add(lblID);

            //Getting input from the user
            tfnumber = new JTextField();
            tfnumber.setBounds(220, 130, 150, 25);
            tfnumber.setBorder(loweredbevel);
            add(tfnumber);

            JLabel name = new JLabel("Name");
            name.setBounds(30, 170, 150, 25);
            add(name);

            //Uneditable field
            lblName = new JLabel();
            lblName.setBounds(220, 170, 150, 25);
            lblName.setBorder(loweredbevel);
            add(lblName);

            JLabel gen = new JLabel("Gender");
            gen.setBounds(30, 210, 150, 25);
            add(gen);

            rMale = new JRadioButton("Male");
            rMale.setBounds(220, 210, 70, 25);
            rMale.setBackground(Color.WHITE);
            add(rMale);

            rFemale = new JRadioButton("Female");
            rFemale.setBounds(310, 210, 70, 25);
            rFemale.setBackground(Color.WHITE);
            add(rFemale);

            //To deselect male when female is selected
            ButtonGroup bg = new ButtonGroup();
            bg.add(rMale);
            bg.add(rFemale);

            JLabel lblCountry = new JLabel("Country");
            lblCountry.setBounds(30, 250, 150, 25);
            add(lblCountry);

            //Getting input from the user
            tfCountry = new JTextField();
            tfCountry.setBounds(220, 250, 150, 25);
            tfCountry.setBorder(loweredbevel);
            add(tfCountry);

            JLabel lblAddress = new JLabel("Address");
            lblAddress.setBounds(30, 290, 150, 25);
            add(lblAddress);

            //Getting input from the user
            tfAddress = new JTextField();
            tfAddress.setBounds(220, 290, 150, 25);
            tfAddress.setBorder(loweredbevel);
            add(tfAddress);

            JLabel lblPhone = new JLabel("Phone Number");
            lblPhone.setBounds(30, 330, 150, 25);
            add(lblPhone);

            //Getting input from the user
            tfPhone = new JTextField();
            tfPhone.setBounds(220, 330, 150, 25);
            tfPhone.setBorder(loweredbevel);
            add(tfPhone);

            JLabel lblEmail = new JLabel("Email");
            lblEmail.setBounds(30, 370, 150, 25);
            add(lblEmail);

            //Getting input from the user
            tfEmail = new JTextField();
            tfEmail.setBounds(220, 370, 150, 25);
            tfEmail.setBorder(loweredbevel);
            add(tfEmail);

            add = new JButton("Add");
            add.setBounds(70, 430, 100, 25);
            add.addActionListener(this);
            add(add);

            back = new JButton("Back");
            back.setBounds(220, 430, 100, 25);
            back.addActionListener(this);
            add(back);

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/customer.jpg"));
            Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(400, 40, 400, 500);
            add(image);

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from account where Username = 'Thamboo';");
                while (rs.next()) {
                    userName.setText(rs.getString("Username"));
                    lblName.setText(rs.getString("Name"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            setVisible(true);

        }

        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource() == add)
            {
                String user = userName.getText();
                String id = (String) comboID.getSelectedItem();
                String num = tfnumber.getText();
                String name = lblName.getText();
                String gender = null;

                if(rMale.isSelected())
                {
                    gender = "Male";
                }
                else
                {
                    gender = "Female";
                }

                String country = tfCountry.getText();
                String address = tfAddress.getText();
                String phone = tfPhone.getText();
                String email = tfEmail.getText();

                //Creating a table in the database
                //create table customer(Username varchar(50), ID varchar(30), Number varchar(30), Name varchar(50), Gender varchar(20), Country varchar(30), Address varchar(50), Phone varchar(15), Email varchar(30));
                try {
                    Conn c = new Conn();
                    String query = "insert into customer values('"+user+"','"+id+"','"+num+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+email+"')";
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null,"Customer details added successfully");
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

        public static void main(String[] args) {
            new AddCustomer("");
        }

}*/

package travel.management.system;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateCustomer extends JFrame implements ActionListener {
    JLabel userName, lblName;
    JComboBox comboID;
    JTextField tfnumber, tfCountry, tfAddress, tfPhone, tfEmail, tfid, tfgender;
    JRadioButton rMale, rFemale;
    JButton add, back;

    UpdateCustomer(String user1) {

        Border loweredbevel = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);

        setBounds(450, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("Update Customer Details");
        text.setBounds(50, 0, 300, 25);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(text);

        JLabel user = new JLabel("Username");
        user.setBounds(30, 50, 150, 25);
        add(user);

        //The user details will be displayed here
        userName = new JLabel();
        userName.setBounds(220, 50, 150, 25);
        userName.setBorder(loweredbevel);
        add(userName);

        JLabel idUser = new JLabel("Identity");
        idUser.setBounds(30, 90, 150, 25);
        add(idUser);

        tfid = new JTextField();
        tfid.setBounds(220,90,150,25);
        add(tfid);


        JLabel lblID = new JLabel("Number");
        lblID.setBounds(30,130,150,25);
        add(lblID);

        //Getting input from the user
        tfnumber = new JTextField();
        tfnumber.setBounds(220,130,150,25);
        tfnumber.setBorder(loweredbevel);
        add(tfnumber);

        JLabel name = new JLabel("Name");
        name.setBounds(30, 170, 150, 25);
        add(name);

        //Uneditable field
        lblName = new JLabel();
        lblName.setBounds(220, 170, 150, 25);
        lblName.setBorder(loweredbevel);
        add(lblName);

        JLabel gen = new JLabel("Gender");
        gen.setBounds(30, 210, 150, 25);
        add(gen);

        tfgender = new JTextField();
        tfgender.setBounds(220,210,150,25);
        add(tfgender);

        JLabel lblCountry = new JLabel("Country");
        lblCountry.setBounds(30,250,150,25);
        add(lblCountry);

        //Getting input from the user
        tfCountry = new JTextField();
        tfCountry.setBounds(220,250,150,25);
        tfCountry.setBorder(loweredbevel);
        add(tfCountry);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(30,290,150,25);
        add(lblAddress);

        //Getting input from the user
        tfAddress = new JTextField();
        tfAddress.setBounds(220,290,150,25);
        tfAddress.setBorder(loweredbevel);
        add(tfAddress);

        JLabel lblPhone = new JLabel("Phone Number");
        lblPhone.setBounds(30,330,150,25);
        add(lblPhone);

        //Getting input from the user
        tfPhone = new JTextField();
        tfPhone.setBounds(220,330,150,25);
        tfPhone.setBorder(loweredbevel);
        add(tfPhone);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(30,370,150,25);
        add(lblEmail);

        //Getting input from the user
        tfEmail = new JTextField();
        tfEmail.setBounds(220,370,150,25);
        tfEmail.setBorder(loweredbevel);
        add(tfEmail);

        add = new JButton("Update");
        add.setBounds(70,430,100,25);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(220,430,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/updat.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,100,400,300);
        add(image);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where Username = '"+user1+"'");
            while(rs.next())
            {
                userName.setText(rs.getString("Username"));
                lblName.setText(rs.getString("Name"));
                tfnumber.setText(rs.getString("Number"));
                tfgender.setText(rs.getString("Gender"));
                tfAddress.setText(rs.getString("Address"));
                tfEmail.setText(rs.getString("Email"));
                tfPhone.setText(rs.getString("Phone"));
                tfid.setText(rs.getString("ID"));
                tfCountry.setText(rs.getString("Country"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == add)
        {
            String user = userName.getText();
            String id = tfid.getText();
            String num = tfnumber.getText();
            String name = lblName.getText();
            String gender = tfgender.getText();
            String country = tfCountry.getText();
            String address = tfAddress.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();

            //Creating a table in the database
            //create table customer(Username varchar(50), ID varchar(30), Number varchar(30), Name varchar(50), Gender varchar(20), Country varchar(30), Address varchar(50), Phone varchar(15), Email varchar(30));
            try {
                Conn c = new Conn();
                String query = "update customer set Username='"+user+"', ID='"+id+"',Number='"+num+"',Name='"+name+"',Gender='"+gender+"',Country='"+country+"',Address='"+address+"',Phone='"+phone+"',Email='"+email+"'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Customer details updated successfully");
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

    public static void main(String[] args) {
        new UpdateCustomer("Thamboo");
    }
}

