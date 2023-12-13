import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PlayerShot implements DisplayObject, Projectile {
    private int[] coordinates = {0,0}; //{x,y}
    private BufferedImage image;
    private boolean exists = true;

    public PlayerShot(int x, int y){
        coordinates[0] = x;
        coordinates[1] = y;

        try{
            image = ImageIO.read(new File(gameConstants.playerProjectileImage));
        } catch (IOException e){

        }
    }


    public boolean shouldDisplay() {
        return exists;
    }


    public void hasHit() {
        exists = false;
    }


    public int getX() {
        return coordinates[0];
    }


    public int getY() {
        return coordinates[1];
    }


    public void setX(int x) {
        coordinates[0] = x;
    }


    public void setY(int y) {
        coordinates[1] = y;
    }

    public void move(){
        coordinates[1] += gameConstants.playerProjectileMoveSpeed;
    }


    public BufferedImage getImage() {
        return image;
    }


    public int getHeight() {
        return gameConstants.playerProjectileHeight;
    }


    public int getWidth(){return gameConstants.playerProjectileWidth;}
}