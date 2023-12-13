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

    private void collisionDetection(){}
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
    collisionDetection();
    }

    public boolean shouldDisplay() {
        return exists;
    }

    public BufferedImage getImage() {return image;}

    int getWidth(){return image.getWidth();}
    int getHeight(){return image.getHeight();}
}