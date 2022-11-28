package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//On licking the create button, all the user info. should be stored in the DB
//For the above reason, using ActionListener interface
//We are trying to trigger an event with the help of this interface
public class SignUp extends JFrame implements ActionListener {
    //If the below are defined inside the constructor, they cannot be used inside the actionPerformed
    JButton create, back;
    JTextField nameText, userText;
    JPasswordField passText,ansText;
    Choice sec;
    SignUp(){
        //Following the same procedure as login page
        setBackground(Color.white);
        setBounds(350,200,700,400);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JPanel pan1 = new JPanel();
        //pan1.setBackground(Color.white);
        pan1.setBounds(20,20,400,320);
        pan1.setLayout(null);
        add(pan1);

        JLabel user = new JLabel("Username");
        user.setFont(new Font("Times New Roman",Font.BOLD,16));
        user.setBounds(50,20,125,20);
        pan1.add(user);

        userText = new JTextField();
        userText.setBounds(190,20,180,20);
        userText.setBorder(BorderFactory.createEmptyBorder());
        pan1.add(userText);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Times New Roman",Font.BOLD,16));
        name.setBounds(50,50,125,20);
        pan1.add(name);

        nameText = new JTextField();
        nameText.setBounds(190,50,180,20);
        nameText.setBorder(BorderFactory.createEmptyBorder());
        pan1.add(nameText);

        JLabel pass = new JLabel("Password");
        pass.setFont(new Font("Times New Roman",Font.BOLD,16));
        pass.setBounds(50,80,125,20);
        pan1.add(pass);

        passText = new JPasswordField();
        passText.setBounds(190,80,180,20);
        passText.setBorder(BorderFactory.createEmptyBorder());
        pan1.add(passText);

        JCheckBox showPass = new JCheckBox("Show Password");
        showPass.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(showPass.isSelected())
                {
                    //Wishing to see the text as it is typed
                    passText.setEchoChar((char)0);
                }
                else {
                    passText.setEchoChar('*');
                }
            }
        });
        showPass.setBounds(190,115,130,20);
        pan1.add(showPass);


        JLabel secQues = new JLabel("Security Ques.");
        secQues.setFont(new Font("Times New Roman",Font.BOLD,16));
        secQues.setBounds(50,145,130,20);
        pan1.add(secQues);

        //For the purpose of choice of security question
        sec = new Choice();
        sec.add("Favourite marvel superhero");
        sec.add("Greatest childhood fear");
        sec.add("Go-to place");
        sec.add("Your birth place");
        sec.setBounds(190,145,185,20);
        pan1.add(sec);

        JLabel ans = new JLabel("Your answer");
        ans.setFont(new Font("Times New Roman",Font.BOLD,16));
        ans.setBounds(50,175,125,20);
        pan1.add(ans);

        ansText = new JPasswordField();
        ansText.setBounds(190,175,180,20);
        ansText.setBorder(BorderFactory.createEmptyBorder());
        pan1.add(ansText);

        JCheckBox showAns = new JCheckBox("Show Answer");
        showAns.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(showAns.isSelected())
                {
                    //Wishing to see the text as it is typed
                    ansText.setEchoChar((char)0);
                }
                else {
                    ansText.setEchoChar('*');
                }
            }
        });

        showAns.setBounds(190,200,110,20);
        pan1.add(showAns);

        create = new JButton("Create Account");
        create.setBounds(190,240,180,30);
        create.addActionListener(this);
        //addActionListener internally calls actionPerformed
        pan1.add(create);

        back = new JButton("Go Back to Login Page");
        back.setBounds(190,280,180,30);
        back.addActionListener(this);
        pan1.add(back);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/sign.png"));
        Image img2 = img.getImage().getScaledInstance(200,220,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(450,50,220,220);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        //To differentiate between the buttons
        if(ae.getSource() == create)
        {
            //Getting the entered details
            String userName = userText.getText();
            String nameEntered = nameText.getText();
            String passwd = new String(passText.getPassword());
            String secChoice = sec.getSelectedItem();
            String secAns = new String(ansText.getPassword());

            //Creating a table
            //create table account(Username varchar(50), Name varchar(50),Password varchar(20),SecQuestion varchar(120), SecAnswer varchar(60));
            //Inserting into the table
            String query = "insert into account values('"+userName+"','"+nameEntered+"','"+passwd+"','"+secChoice+"','"+secAns+"')";

            //MySQL is an external entity and there is a possibility of exception
            try
            {
                Conn c = new Conn();
                //DML command
                //Used when we are using insert,update/delete queries
                c.s.executeUpdate(query);

                //For the purpose of pop-up
                JOptionPane.showMessageDialog(null,"Account Creation Successful");
                setVisible(false);
                new Login();
            }
            catch(Exception e)
            {
                e.printStackTrace();
                //Prints this throwable and its backtrace
            }
        }
        else if(ae.getSource() == back)
        {
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args){
        new SignUp();
    }
}
