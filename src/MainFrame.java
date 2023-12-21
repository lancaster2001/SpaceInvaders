import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public final class MainFrame extends JFrame{
    public JComponent draw = new JComponent(){};
    private static final MainPanel panelInstance = MainPanel.getInstance();//singleton instance of jpanel on the mainframe
    private static MainFrame instance;
    public static MainFrame getInstance() {
        if(instance == null) {
            instance = new MainFrame();
        }
        return instance;
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
        addKeyListener(KeyDetector.getInstance());
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        this.add(panelInstance);
        //panelInstance.setBackground(Color.red);
        this.setVisible(true);


    }


}