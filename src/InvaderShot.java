import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class InvaderShot extends Projectile implements DisplayObject{
    public  InvaderShot(int x, int y){
        coordinates[0] = x;
        coordinates[1] = y;
        moveSpeed = gameConstants.invaderProjectileMoveSpeed;
        direction = gameConstants.down;
        imageLink = gameConstants.invaderProjectileImage;
        height = gameConstants.invaderProjectileHeight;
        width = gameConstants.invaderProjectileWidth;

        try{
            image = ImageIO.read(new File(imageLink));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}