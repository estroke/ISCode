import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class image {

    public BufferedImage originalImage;
    public BufferedImage image;
    public BufferedImage newImage;

    static public void main(String[] args) throws IOException {
        
        image img = new image();
        
    }
    public void populateImage(File file) throws IOException {
        originalImage = ImageIO.read(file);
        AffineTransform at = new AffineTransform();
        at.scale(.3,.3);
        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        image = scaleOp.filter(originalImage, image);
    }

    public void scaleImage() {
        AffineTransform at = new AffineTransform();
        at.scale(.3,.3);
        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        image = scaleOp.filter(originalImage, image);
    }
}
