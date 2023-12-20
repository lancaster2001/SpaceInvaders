import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;

public final class MainPanel extends JPanel {
    private static MainPanel instance;
    private final Player playerInstance = Player.getInstance();



    public static MainPanel getInstance() {
        if (instance == null) {
            instance = new MainPanel();
        }
        return instance;
    }
    private MainPanel(){
        this.setSize(gameConstants.screenSize.width, gameConstants.screenSize.height);
        this.setMinimumSize(new Dimension(600, 600));
        this.setVisible(true);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        final GameState gameInstance = GameState.getInstance();
        ArrayList<invader> invaderArray = gameInstance.getInvaderArray();
        ArrayList<Projectile> projectiles = gameInstance.getProjectiles();
        drawPlayer(g);
        drawInvaders(g, invaderArray);
        drawProjectiles(g, projectiles);
    }

    private void drawPlayer(Graphics g) {
        if (playerInstance.shouldDisplay()) {
            g.drawImage(playerInstance.getImage(), playerInstance.getX(), playerInstance.getY(), playerInstance.getWidth(), playerInstance.getHeight(), null);
            System.out.println(playerInstance.getX()+","+ playerInstance.getY()+","+ playerInstance.getWidth()+","+ playerInstance.getHeight());
        }
    }
    private void drawInvaders(Graphics g,ArrayList<invader> invaderArray){

        if (invaderArray != null){
            for (invader sprites : invaderArray){
                if ((sprites.getImage() != null)&&(sprites.shouldDisplay())){
                    g.drawImage(sprites.getImage(), sprites.getX(), sprites.getY(), sprites.getWidth(), sprites.getHeight(), this);
                }
            }
        }
    }

    private void drawProjectiles(Graphics g,ArrayList<Projectile> projectiles) {
        //ArrayList<Projectile> projectiles = gameInstance.getProjectiles();
        if (projectiles != null){
            for (Projectile sprites : projectiles){
                if ((sprites.getImage() != null)&&(sprites.shouldDisplay())){
                    g.drawImage(sprites.getImage(), sprites.getX(), sprites.getY(), sprites.getWidth(), sprites.getHeight(), this);
                }
            }
        }
    }
}
