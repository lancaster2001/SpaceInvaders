import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LargeInvader extends invader{
    private BufferedImage image;
    private int value = gameConstants.largeInvaderValue;
    public LargeInvader() {
        try{image = ImageIO.read(new File(gameConstants.largeInvaderImage));} catch (IOException e){
            System.out.println("error getting small invader image");
        }
    }
    @Override
    public BufferedImage getImage() {
        return image;
    }
}
