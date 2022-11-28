package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{
    Thread t;
    JProgressBar bar;
    String user;

    public void run() {
        try{
            for(int i=1;i<=101;i++)
            {
                int max = bar.getMaximum();
                int val = bar.getValue();

                if(val < max){
                    bar.setValue(bar.getValue()+1);
                }
                else{
                    setVisible(false);
                    //new class object
                    new Dashboard(user);
                }
                Thread.sleep(50);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    Loading(String user)
    {
        this.user = user;
        t = new Thread(this);
        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Travel application");
        text.setBounds(170,20,600,40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway",Font.BOLD,35));
        add(text);

        //Component that displays the progress of some task
        bar = new JProgressBar();
        bar.setBounds(170,100,300,35);
        //Taking from 0 to 100
        bar.setStringPainted(true);
        add(bar);

        JLabel load = new JLabel("Loading...Please wait..");
        load.setBounds(200,140,300,30);
        load.setForeground(Color.RED);
        load.setFont(new Font("Raleway",Font.BOLD,22));
        add(load);

        JLabel userDisplay = new JLabel("Welcome " + user);
        userDisplay.setBounds(190,250,400,40);
        userDisplay.setForeground(new Color(13, 186, 7));
        userDisplay.setFont(new Font("Algerian",Font.CENTER_BASELINE,28));
        add(userDisplay);

        t.start();

        setVisible(true);
    }
    public static void main(String[] args){
        new Loading("");
    }


}
