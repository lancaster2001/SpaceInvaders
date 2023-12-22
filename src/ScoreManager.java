import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScoreManager {
    private int score;
    private static int highscore;
    private static ScoreManager instance;
    public static ScoreManager getInstance() {
        if(instance == null) {
            instance = new ScoreManager();
        }
        return instance;
    }

    public final void addScore(int val){
        score += val;
        System.out.println(val+" added to score\nnew score:" + score);
        saveHighscore();
    }

    public final void loadHighscore(){
        try {
            File myObj = new File("highscore.txt");
            Scanner myReader = new Scanner(myObj);
            String data = myReader.nextLine();
            System.out.println(data);
            myReader.close();
            highscore = Integer.parseInt(data);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred at highscore reader.");
        }
    }
    public final void saveHighscore(){
        try {
            if (score > highscore) {
                highscore = score;
                FileWriter myWriter = new FileWriter(gameConstants.highscore);
                myWriter.write(String.valueOf(highscore));
                myWriter.close();
                System.out.println("highscore saved\nhighscore:" + highscore);
            }else{
                System.out.println("score not saved\nscore:" + score + "\nhighscore:" + highscore);
            }
        } catch (IOException e) {
            System.out.println("An error occurred at highscore saver.");
        }
    }
    private int getHighscore(){
        return highscore;
    }
}
