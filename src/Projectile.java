import java.awt.image.BufferedImage;

public abstract class Projectile {
    protected int[] coordinates = {0,0}; //{x,y}
    protected int height;
    protected int width;
    protected BufferedImage image;
    protected boolean exists = true;

    protected int moveSpeed;
    protected char direction;
    protected String imageLink;

    public final boolean collisionDetection(int trgtx,int trgty, int trgtWidth, int trgtHeight){
        if (getX() <( trgtx+trgtWidth) && (getX()+getWidth()-1) > trgtx && getY() < (trgty+trgtHeight-1) && (getY()+getHeight()-1) > trgty){
            return true;
        }
        return false;
    }
    public final void move(){
        switch (direction) {
            case gameConstants.up -> {
                if (coordinates[1] - moveSpeed >= 0 ){
                    coordinates[1] -= moveSpeed;
                }else{
                    exists = false;
                }
            }
            case gameConstants.down ->{
            if (coordinates[1] + moveSpeed < gameConstants.screenSize.height){
                coordinates[1] += moveSpeed;
            }else{
                exists = false;
            }
        }
        default -> System.out.println("projectile could not move");
    };
    }
    public final boolean shouldDisplay() {
        return exists;
    }
    public final void hasHit() {
        exists = false;
    }
    public final int getX() {
        return coordinates[0];
    }
    public final int getY() {
        return coordinates[1];
    }
    public final BufferedImage getImage() {return image;}
    public final int getHeight() {return height;}
    public final int getWidth(){return width;}
}