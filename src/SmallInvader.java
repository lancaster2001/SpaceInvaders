import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SmallInvader extends invader{
    private BufferedImage image;
    private int value = gameConstants.smallInvaderValue;
    public SmallInvader() {
        try{
            image = ImageIO.read(new File(gameConstants.smallInvaderImage));
        } catch (IOException e){
            System.out.println("error getting small invader image");
        }
    }
    @Override
    public BufferedImage getImage() {
        return image;
    }

}
