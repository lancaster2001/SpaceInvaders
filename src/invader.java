import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class invader implements DisplayObject {
    private int[] coordinates = {0,0};// {x,y}
    private boolean alive = true;
    protected BufferedImage image;
    protected String imageLink;
    protected int value = 0;


    public final BufferedImage getImage() {
        return image;
    }


    public final int getX() {
        return coordinates[0];
    }


    public final int getY() {
        return coordinates[1];
    }


    public final int getHeight() {
        return gameConstants.invaderHeight;
    }


    public final int getWidth() {
        return gameConstants.invaderWidth;
    }


    public final boolean shouldDisplay() {
        return alive;
    }

    public final void setX(int X){
        coordinates[0] = X;
    }
    public final void setY(int Y){
        coordinates[1] = Y;
    }

    public final void move(char direction){
        if (direction == gameConstants.left){
            coordinates[0] -= gameConstants.invaderMoveSpeed;
        } else if (direction == gameConstants.right) {
            coordinates[0] += gameConstants.invaderMoveSpeed;
        }else if (direction == gameConstants.down){
            coordinates[1] += gameConstants.invaderHeight;
        }

    }
    protected final void loadImage(){
        try{image = ImageIO.read(new File(imageLink));} catch (IOException e){
            System.out.println("error getting small invader image");
        }
    }
    public final int Kill(){
        alive = false;
        return value;
    }





    
} 
