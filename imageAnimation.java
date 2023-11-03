//import for the timer object and the timer task,
//which sets the delay
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
//import javax.imageio.ImageIO;
//imports for swing utilities such as the jFrame,jPanel
import javax.swing.*;

import java.awt.GridBagLayout;
import java.awt.Image;
//aid to the timer object, allows for signal to be sent
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
//IO exception class
import java.io.IOException;

//public class constructor
public class imageAnimation {

        JLabel jLabel;
        JFrame jFrame;
        JPanel jPanel;
        ImageIcon images;
        Timer timer; 
        JButton jButton;
        ActionListener listener;

        


    static public void main(String[] args) throws IOException, InterruptedException {
        //calls an instnce of the main function
        imageAnimation ia = new imageAnimation();

    }
    public imageAnimation() throws InterruptedException {
        //function to set up the JFrame, JLabel, and JPanel
        //which will display the animation
        jLabel = new JLabel();
        jFrame = new JFrame("Scary Cottage");
        jPanel = new JPanel(null, false);

        //setting frame location
        jPanel.setLayout(new GridBagLayout());
        jFrame.setLocation(200, 100);
        jPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel.add(jLabel);
        jFrame.setSize(600, 600);
        jFrame.add(jPanel);
 
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //calls an instance of the animation class which 
        //gives the information to the jLabel
        animation();
    
    }
    public void animation() throws InterruptedException {
       
        // delayed timer function is from https://stackoverflow.com/questions/5525176/java-simple-timertask-for-each-value-of-array
        
        final Timer utilTimer = new Timer();
        utilTimer.scheduleAtFixedRate(new TimerTask() {
            int i = 1;
            float x = .5f;
            public void run() {
                File imgFile1 = new File("/Users/elliestroke/Desktop/IS/is_possible.jpeg");
                
                imageProcessing newImage1 = new imageProcessing();
                imageSegmentation newImage = new imageSegmentation();
                //" + i + "
                    // ImageIcon imageIcon = new ImageIcon("/Users/elliestroke/Desktop/JuniorIS/Ellie_Stroke_Jr_IS/JuniorIS/animation/combofinal" +i +"-fotor"+".jpg");

                    //newGreyScale.image =
                    
                     try {
                         //getting sky pixels
                         //populating both public image and region array with arrays of pixels
                         newImage.regionalGrowth(imgFile1, 1, 100,30);
                         newImage1.ContrastMethod(newImage, x);
                    } catch (IOException e) {
                    }
                    
                    
                    //x = x + .05f;

                    ImageIcon imageIcon = new ImageIcon(newImage.image);
                    // transform it 
                    Image image = imageIcon.getImage(); // transform it 
                    Image newimg = image.getScaledInstance((newImage.image.getWidth(jButton)*2), (newImage.image.getHeight(jButton)*2),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    imageIcon = new ImageIcon(newimg);
                    jLabel.setIcon(imageIcon);
                    
                    //resets the array after the last image has been shown 
                    //for continuity
                     x = (x + .1f);
                    if (x >= 2) {
                        x = .1f;
                    }
            }
        }, 500L, 100L);
    }

}
