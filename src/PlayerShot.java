import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class PlayerShot extends Projectile implements DisplayObject{
    public PlayerShot(int x, int y){
        coordinates[0] = x;
        coordinates[1] = y;
        moveSpeed = gameConstants.playerProjectileMoveSpeed;
        direction = gameConstants.up;
        imageLink = gameConstants.playerProjectileImage;
        height = gameConstants.playerProjectileHeight;
        width = gameConstants.playerProjectileWidth;

        try{
            image = ImageIO.read(new File(imageLink));
        } catch (IOException e){
            System.out.println("there was an error in reading the player projectile image");
        }
    }
}