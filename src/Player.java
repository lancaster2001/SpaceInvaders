import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public final class Player implements DisplayObject {
    private static Player instance;
    private static Integer lives = 3;
    private int score = 0;
    private BufferedImage image;

    private int[] coordinates = {(gameConstants.screenSize.width/2),gameConstants.killHeight};
    //private int[] coordinates = {(gameConstants.screenSize.width/2),(gameConstants.screenSize.height-(gameConstants.screenSize.height/20))};//{x,y}
    private static final ProjectileManager ProjectileManagerInstance = ProjectileManager.getInstance();

    private Player() {
        System.out.println("make sure you only print this once for player");
        image = null;
        try {
            image = ImageIO.read(new File(gameConstants.playerImage));
            AudioPlayer.playAudio(gameConstants.playerShootAudio);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Player getInstance() {
        if(instance == null) {
            instance = new Player();
        }
        return instance;
    }
    public void hit(){
        lives -= 1;
        if(lives == 0){
            //todo
        }
    }
    
    public void shoot(){
        ProjectileManagerInstance.createProjectile(gameConstants.playerProjectileID, coordinates[0], coordinates[1]);
    }

    public void addScore(int points){
        score += points;
    }
    public int getScore(){
        return score;
    }

    public void move(char direction){

        if (direction == gameConstants.left){
            if ((coordinates[0] - gameConstants.playerMoveSpeed) > 0){
                coordinates[0] -= gameConstants.playerMoveSpeed;
            }else{
                AudioPlayer.playAudio(gameConstants.bumpaudio);
            }
        } else if (direction == gameConstants.right) {
            if ((coordinates[0] + gameConstants.playerWidth + gameConstants.playerMoveSpeed) < gameConstants.screenSize.width){
                coordinates[0] += gameConstants.playerMoveSpeed;
            }else{
                AudioPlayer.playAudio(gameConstants.bumpaudio);
            }
        }

    }


    @Override
    public BufferedImage getImage() {
        return image;
    }

    @Override
    public int getX() {
        return coordinates[0];
    }

    @Override
    public int getY() {
        return coordinates[1];
    }

    @Override
    public int getHeight() {
        return gameConstants.playerHeight;
    }

    @Override
    public int getWidth() {
        return gameConstants.playerWidth;
    }

    @Override
    public boolean shouldDisplay() {
        return lives>0;
    }

}
