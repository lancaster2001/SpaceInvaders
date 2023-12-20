import java.awt.image.BufferedImage;

public abstract class Projectile {
    protected int[] coordinates = {0,0}; //{x,y}
    protected BufferedImage image;
    protected boolean exists = true;

    protected int moveSpeed;
    protected char direction;

    void setX(int x){};

    void setY(int y){};

    public int getX() {return coordinates[0];}
    public int getY() {return coordinates[1];}
    private void hasHit() {
        exists = false;
    }

    public boolean collisionDetection(int trgtx,int trgty, int trgtWidth, int trgtHeight){
        if (getX() <( trgtx+trgtWidth) && (getX()+getWidth()-1) > trgtx && getY() < (trgty+trgtHeight-1) && (getY()+getHeight()-1) > trgty){
            return true;
        }
        return false;
    }
    public void move(){
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
    public boolean shouldDisplay() {
        return exists;
    }

    public BufferedImage getImage() {return image;}

    int getWidth(){return image.getWidth();}
    int getHeight(){return image.getHeight();}
}