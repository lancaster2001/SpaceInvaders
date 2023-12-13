import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public final class MainFrame extends JFrame implements KeyListener{
    public JComponent draw = new JComponent(){};
    private final Player playerInstance = Player.getInstance();
    private static final MainPanel panelInstance = MainPanel.getInstance();//singleton instance of jpanel on the mainframe
    private static MainFrame instance;
    public static MainFrame getInstance() {
        if(instance == null) {
            instance = new MainFrame();
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

    private MainFrame(){
        this.setTitle("Space Invaders Assignment 1");
        this.setResizable(false);
        this.setSize(gameConstants.screenSize.width, gameConstants.screenSize.height);
        this.setMinimumSize(new Dimension(gameConstants.screenSize.width, gameConstants.screenSize.height));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(this.draw);
        this.pack();
        this.setVisible(true);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        this.add(panelInstance);
        //panelInstance.setBackground(Color.red);
        this.setVisible(true);


    }


}