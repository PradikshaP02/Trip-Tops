package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {
    JLabel user,pass;
    JTextField userText;
    JPasswordField passText;
    JButton log,sign,forPass,back;
    Login(){
        setBackground(Color.white);
        setBounds(350,200,700,360);
        setSize(900,400);
        setLocation(350,200);

        //FlowLayout is the default layout manager for every JPanel . It simply lays out components in a single row, starting a new row if its container is not sufficiently wide
        //We are building our own layout
        setLayout(null);

        //In Java Swing, the layer that is used to hold objects is called the content pane
        //The getContentPane() method retrieves the content pane layer so that you can add an object to it.
        getContentPane().setBackground(Color.white);

        //To divide the frame into two parts
        //JFrame represents a framed window and a JPanel represents some area in which controls (e.g., buttons, checkboxes, and textfields) and visuals (e.g., figures, pictures, and even text) can appear.
        JPanel pan = new JPanel();
        pan.setBackground(Color.white);

        //The first two arguments are x and y coordinates of the top-left corner of the component, the third argument is the width of the component and the fourth argument is the height of the component.
        pan.setBounds(0,0,380,400);

        //If the below line os not given, setbounds func. below will not work
        pan.setLayout(null);
        add(pan);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/profile.png"));
        Image img2 = img.getImage().getScaledInstance(220,200,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(100,100,230,200);

        //Placing the image on top of the panel
        pan.add(image);

        //Building another panel
        JPanel pan2 = new JPanel();
        pan2.setLayout(null);
        pan2.setBounds(400,30,430,300);
        add(pan2);

        //Adding content on the right side

        //Adding "Username" using JLabel and setting the font
        user = new JLabel("Username");
        user.setBounds(190,20,100,25);
        user.setFont(new Font("Times New Roman",Font.BOLD,18));
        pan2.add(user);

        //Creating the text field below username with empty border
        userText = new JTextField();
        userText.setBounds(80,60,280,30);
        userText.setBorder(BorderFactory.createEmptyBorder());
        pan2.add(userText);

        //The same procedure for password
        pass = new JLabel("Password");
        pass.setBounds(190,110,100,25);
        pass.setFont(new Font("Times New Roman",Font.BOLD,18));
        pan2.add(pass);

        passText = new JPasswordField();
        passText.setBounds(80,150,280,30);
        passText.setBorder(BorderFactory.createEmptyBorder());
        pan2.add(passText);

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
        showPass.setBounds(170,185,130,20);
        pan2.add(showPass);

        //Creating the required buttons
        log = new JButton("Login");
        log.setBounds(85,220,110,30);
        log.addActionListener(this);
        pan2.add(log);

        sign = new JButton("Sign Up");
        sign.setBounds(245,220,110,30);
        sign.addActionListener(this);
        pan2.add(sign);

        forPass = new JButton("Forgot password");
        forPass.setBounds(155,265,130,30);
        forPass.addActionListener(this);
        pan2.add(forPass);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(log)){
            //System.out.println("Hi");
            try{
                String user = userText.getText();
                String pass = new String(passText.getPassword());

                String query = "select * from account where Username = '"+user+"' AND Password = '"+pass+"'";
                Conn c = new Conn();

                ResultSet rs = c.s.executeQuery(query);
                //Returns True/False
                if(rs.next())
                {
                    setVisible(false);
                    new Loading(user);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect username or password");
                }

            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource().equals(forPass) ){
            setVisible(false);
            new ForgotPass();
        }
        else if(ae.getSource().equals(sign)){
            SignUp su = new SignUp();
            su.setVisible(true);
        }
        else{
            new ForgotPass();
        }

    }
    //Frame is independent window that is resizable whereas panel is an internal region to a frame
    public static void main(String[] args)
    {
        Login log = new Login();
    }
}
