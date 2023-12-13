import java.awt.image.BufferedImage;

public abstract class invader implements DisplayObject {
    private int[] coordinates = {0,0};// {x,y}
    private boolean alive = true;
    private BufferedImage image;
    private String imageLink;
    private int value = 0;


    public BufferedImage getImage() {
        return image;
    }


    public int getX() {
        return coordinates[0];
    }


    public int getY() {
        return coordinates[1];
    }


    public int getHeight() {
        return gameConstants.invaderHeight;
    }


    public int getWidth() {
        return gameConstants.invaderWidth;
    }


    public boolean shouldDisplay() {
        return alive;
    }

    public void setX(int X){
        coordinates[0] = X;
    }
    public void setY(int Y){
        coordinates[1] = Y;
    }

    public void move(char direction){
        if (direction == gameConstants.left){
            coordinates[0] -= gameConstants.invaderMoveSpeed;
        } else if (direction == gameConstants.right) {
            coordinates[0] += gameConstants.invaderMoveSpeed;
        }else if (direction == gameConstants.down){
            coordinates[1] += gameConstants.invaderHeight;
        }

    }



    
} 
