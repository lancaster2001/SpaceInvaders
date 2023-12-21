import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyDetector implements KeyListener {
    private final Player playerInstance = Player.getInstance();
    private static final MainPanel panelInstance = MainPanel.getInstance();//singleton instance of jpanel on the mainframe
    private static KeyDetector instance;
    public static KeyDetector getInstance() {
        if(instance == null) {
            instance = new KeyDetector();
        }
        return instance;
    }
    public void keyPressed(KeyEvent e) {
        if((e.getKeyChar() == gameConstants.left) || (e.getKeyChar() == gameConstants.right)){
            playerInstance.move(e.getKeyChar());
        }else if(e.getKeyChar() == gameConstants.shoot){
            playerInstance.shoot();
        }
        panelInstance.repaint();
    }

    public void keyReleased(KeyEvent e) {

    }
    public void keyTyped(KeyEvent e) {

    }
}
