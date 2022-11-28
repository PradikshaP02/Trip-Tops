package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ForgotPass extends JFrame implements ActionListener {
    JTextField userText, quesText, ansText, passText;
    JButton search, ret, back;
    ForgotPass(){
        setBounds(350,200,850,380);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,70,200,200);
        add(image);

        JPanel pan1 = new JPanel();
        pan1.setLayout(null);
        pan1.setBounds(30,30,500,280);
        add(pan1);

        JLabel user = new JLabel("Username");
        user.setFont(new Font("Times New Roman",Font.BOLD,16));
        user.setBounds(50,20,130,25);
        pan1.add(user);

        userText = new JTextField();
        userText.setBounds(190,20,200,25);
        userText.setBorder(BorderFactory.createEmptyBorder());
        pan1.add(userText);

        search = new JButton("Search");
        search.setBounds(390,50,100,25);
        search.addActionListener(this);
        pan1.add(search);

        JLabel secQues = new JLabel("Security Ques.");
        secQues.setFont(new Font("Times New Roman",Font.BOLD,16));
        secQues.setBounds(50,85,130,25);
        pan1.add(secQues);

        quesText = new JTextField();
        quesText.setBounds(190,85,200,25);
        quesText.setBorder(BorderFactory.createEmptyBorder());
        pan1.add(quesText);

        JLabel secAns = new JLabel("Answer");
        secAns.setFont(new Font("Times New Roman",Font.BOLD,16));
        secAns.setBounds(50,120,130,25);
        pan1.add(secAns);

        ansText = new JTextField();
        ansText.setBounds(190,120,200,25);
        ansText.setBorder(BorderFactory.createEmptyBorder());
        pan1.add(ansText);

        ret = new JButton("Retrieve");
        ret.setBounds(390,150,100,25);
        ret.addActionListener(this);
        pan1.add(ret);

        JLabel pass = new JLabel("Password");
        pass.setFont(new Font("Times New Roman",Font.BOLD,16));
        pass.setBounds(50,185,130,25);
        pan1.add(pass);

        passText = new JTextField();
        passText.setBounds(190,185,200,25);
        passText.setBorder(BorderFactory.createEmptyBorder());
        pan1.add(passText);

        back = new JButton("Back");
        back.setBounds(230,220,100,25);
        back.addActionListener(this);
        pan1.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == search){
            try{
                //DDL Command
                String query = "select * from account where Username = '"+userText.getText()+"'";
                Conn c = new Conn();

                //To hold the result of the query
                ResultSet rs = c.s.executeQuery(query);
                //Looping through the fields
                while(rs.next()){
                    quesText.setText(rs.getString("SecQuestion"));
                }
            }
            catch(Exception e1){
                e1.printStackTrace();
            }
        }
        else if(e.getSource() == ret){
            try{
                //DDL Command
                String query = "select * from account where SecAnswer = '"+ansText.getText()+"' AND Username = '"+userText.getText()+"'";
                Conn c = new Conn();

                //To hold the result of the query
                ResultSet rs = c.s.executeQuery(query);
                //Looping through the fields
                while(rs.next()){
                    quesText.setText(rs.getString("SecQuestion"));
                }
            }
            catch(Exception e1){
                e1.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args){
        new ForgotPass();
    }
}
