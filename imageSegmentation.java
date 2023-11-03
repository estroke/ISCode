import java.awt.Color;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.util.ArrayList;
import java.util.List;

public class imageSegmentation {

    
    public BufferedImage image;
    public List<int[]> region = new ArrayList<>();

    static public void main(String[] args) throws IOException {
        //create new instance of class here and add file call. can call to image animation class to test

        imageSegmentation newSegmentation = new imageSegmentation();
        
        
    }
    public void populateImage(File file) throws IOException {
        image = ImageIO.read(file);
    }
    public void regionalGrowth(File file, int xPixel, int yPixel, int threshold) throws IOException {

        image = ImageIO.read(file);
             
        int width = image.getWidth();
        int height = image.getHeight();
        
        int seedPixel = image.getRGB(xPixel, yPixel);
        Color c1 = new Color(seedPixel);
        int red1 = c1.getRed();
        int green1 = c1.getGreen();
        int blue1 = c1.getBlue();
        int grey1 = (red1 + blue1 + green1) / 3;
        
        //System.out.println(grey1);

        //List<int[]> seedPixels = new ArrayList<>();
        //seedPixels.add(new int[] {xPixel, yPixel});
        

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x,y);
                Color c = new Color(pixel);
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                //int grey = (red + blue + green) / 3;
                //System.out.println(grey);
                

                //checking if the red, blue and green values are near the threshold value (precision)
                if (Math.abs((red) - (red1)) < threshold && Math.abs((green) - (green1)) < threshold && Math.abs((blue) - (blue1)) < threshold) {
                    //int rgb = new Color(255,234,0).getRGB();
                    region.add(new int [] {x,y});
                    //System.out.println(x + ", " + y);
                    //image.setRGB(x, y, rgb);
                }
            }
        }

    }
}
