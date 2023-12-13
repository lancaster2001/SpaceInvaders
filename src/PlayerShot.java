import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PlayerShot extends Projectile implements DisplayObject {

    public PlayerShot(int x, int y){
        coordinates[0] = x;
        coordinates[1] = y;
        moveSpeed = gameConstants.playerProjectileMoveSpeed;
        direction = gameConstants.up;



        try{
            image = ImageIO.read(new File(gameConstants.playerProjectileImage));
        } catch (IOException e){
            System.out.println("there was an error in reading the player projectile image");
        }
    }


    private void collisionDetection(){

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


    public BufferedImage getImage() {
        return image;
    }


    public int getHeight() {
        return gameConstants.playerProjectileHeight;
    }


    public int getWidth(){return gameConstants.playerProjectileWidth;}
}