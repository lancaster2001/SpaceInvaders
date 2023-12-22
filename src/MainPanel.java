import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
        System.out.println("make sure you only print this once for mainPanel");
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
           // System.out.println(playerInstance.getX()+","+ playerInstance.getY()+","+ playerInstance.getWidth()+","+ playerInstance.getHeight());
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
