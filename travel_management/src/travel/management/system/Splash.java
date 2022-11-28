package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    Splash()
    {
        //Specifying the location of the component in the window and sizing

        Thread thread;

        //ImageIcon Creates an ImageIcon from an array of bytes which were read from an image file containing a supported image format, such as GIF, JPEG, or (as of 1.3) PNG.
        //ClassLoader.getSystemResource - find a resource of the specified name from the search path used to load classes.
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));

        //getImage() method that returns the object of Image
        //Resizing or scaling the image
        Image i2 = i1.getImage().getScaledInstance(1200,600,Image.SCALE_DEFAULT);

        //Only image icons can be passed to JLabel class
        ImageIcon i3 = new ImageIcon(i2);

        //JLabel is used to display short strings or image icons
        JLabel image = new JLabel(i3);

        //Placing the image in the container
        add(image);

        //To control whether to hide or show the window
        setVisible(true);

        thread = new Thread(this);
        thread.start();
    }

    public void run()
    {
        try{
            //The image will be displayed for 7s and it will get closed
            Thread.sleep(7000);
            //new Login();
            setVisible(false);
        }
        catch(Exception e){

        }
    }
    public static void main(String[] args) {
        Splash frame = new Splash();
        int x = 1;

        //This for loop is basically for making the image appear from the center and expand
        for (int i = 1; i <= 500; x += 7, i += 6) {
            frame.setLocation(750 - (x + i) / 2, 400 - (i / 2));
            frame.setSize(x + i, i);
            try {
                Thread.sleep(10);
            }
            catch (Exception e) {
            }
        }
    }
}
