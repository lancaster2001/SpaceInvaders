
import java.io.FileWriter;
import java.io.IOException;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Timer;
import java.util.TimerTask;


public class GameState {
    private static GameState instance;
    private int score;
    private static int highscore;
    private Timer gameTimer;
    private static final Player playerInstance = Player.getInstance();//singleton instance of Player
    private final MainPanel panelInstance = MainPanel.getInstance();
    private final InvaderManager invaderManagerInstance = InvaderManager.getInstance();
    private static final ProjectileManager ProjectileManagerInstance = ProjectileManager.getInstance();
    private final MainFrame frameInstance = MainFrame.getInstance();//needed so that frame generates


    public static GameState getInstance() {
        if(instance == null) {
            instance = new GameState();
        }
        return instance;
    }

    public static void main(String[] args){
        new GameState();
    }
    public GameState(){
        setup();
    }
    private void setup(){

        highscore = getHighscore();
        gameTimer = new Timer();

        invaderManagerInstance.createInvaders();

        panelInstance.repaint();
        doGameCycle();
    }
    private void doGameCycle(){

        invaderManagerInstance.doCycle();
        ProjectileManagerInstance.doCycle();

        TimerTask task = new TimerTask() {
            public static int i = 0;
            @Override
            public void run() {
                System.out.println("Timer ran " + ++i);
                doGameCycle();
                panelInstance.repaint();
            }
        };
        gameTimer.schedule(task,gameConstants.tickLength );


    }


    public void endGame(){
        gameTimer.purge();
                try {
                    FileWriter myWriter = new FileWriter(gameConstants.highscore);
                    myWriter.write(String.valueOf(playerInstance.getScore()));
                    myWriter.close();
                    System.out.println("highscore saved");
                } catch (IOException e) {
                    System.out.println("An error occurred at highscore saver.");
                }


        System.out.println("Game Over");
        AudioPlayer.playAudio("game over audio");
        System.exit(0);
    }

    //stubs
    static int getHighscore(){
        try {
            File myObj = new File("highscore.txt");
            Scanner myReader = new Scanner(myObj);
            String data = myReader.nextLine();
            System.out.println(data);
            myReader.close();
            return Integer.parseInt(data);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred at highscore reader.");

        }
        return 99999;
    }
}
