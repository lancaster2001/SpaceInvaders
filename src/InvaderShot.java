import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class InvaderShot extends Projectile implements DisplayObject {
    private int[] coordinates = {0,0}; //{x,y}
    private BufferedImage image;
    private boolean exists = true;

    public InvaderShot(int x, int y){
        coordinates[0] = x;
        coordinates[1] = y;

        try{
            image = ImageIO.read(new File(gameConstants.invaderProjectileImage));
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
        coordinates[1] += gameConstants.invaderProjectileMoveSpeed;
    }


    public BufferedImage getImage() {
        return image;
    }


    public int getHeight() {
        return gameConstants.invaderProjectileHeight;
    }


    public int getWidth(){return gameConstants.invaderProjectileWidth;}
}