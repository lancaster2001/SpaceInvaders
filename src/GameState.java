import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors


public class GameState extends State {
    public State nextState = endGameState.getInstance();
    private int score;
    private int round = 1;
    private static int highscore;
    private final ArrayList<invader>  invaderArray = new ArrayList<>();
    private final ArrayList<Projectile> projectilesArray = new ArrayList<>();
    private boolean invadersGoingRight = true; //true for going right
    private Timer gameTimer;
    private static final Player playerInstance = Player.getInstance();//singleton instance of Player
    private static final invaderFactory invaderFactoryInstance = invaderFactory.getInstance();//singleton instance of invader factory
    private final MainPanel panelInstance = MainPanel.getInstance();
    private final MainFrame frameInstance = MainFrame.getInstance();//needed so that frame generates
    private static final ProjectileFactory projectileFactoryInstance = ProjectileFactory.getInstance();//singleton instance of projectile factory
    private static GameState instance;



    public static GameState getInstance() {
        if(instance == null) {
            instance = new GameState();
        }
        return instance;
    }

    public static void main(String[] args){
        getInstance();
        instance.setup();

    }
    public GameState(){
    }

    private void setup(){
        loadHighscore();
        gameTimer = new Timer();
        invaderSetup();
        panelInstance.repaint();
        doGameCycle();
    }
    private void newRound(){
        round += 1;
        setup();
    }

    public final void invaderSetup(){
        //build array of invaders with each line being a different type of invader
        for (int i = 0; i < gameConstants.numberOfInvaders; i++){
            //creates new object for invaders assigns tier of invader based on rows
            invaderArray.add(invaderFactoryInstance.getInvader(gameConstants.invaderOrder[i/(gameConstants.numberOfInvaders/gameConstants.invaderOrder.length)]));
        }

        int rowLength = (gameConstants.numberOfInvaders/gameConstants.invaderOrder.length);

        for (int i = 0; i < gameConstants.numberOfInvaders; i++){
            int currentRow = ((i)/rowLength);
            invaderArray.get(i).setX((i*gameConstants.invaderWidth)-(rowLength*gameConstants.invaderWidth*currentRow));
            invaderArray.get(i).setY(currentRow*gameConstants.invaderHeight);
        }
    }
    private void doGameCycle(){

        invaderDoCycle();
        projectileDoCycle();

        TimerTask task = new TimerTask() {
            public static int i = 0;
            @Override
            public void run() {
                System.out.println("Timer ran " + ++i);
                doGameCycle();
            }
        };


        panelInstance.repaint();
        gameTimer.schedule(task,gameConstants.tickLength );
    }

    public final void invaderDoCycle(){
        int rowLength = (gameConstants.numberOfInvaders/gameConstants.invaderOrder.length);
        if (((invaderArray.get(rowLength-1).getX() + gameConstants.invaderWidth + gameConstants.invaderMoveSpeed) <= gameConstants.screenSize.width)&& invadersGoingRight){
            for (int i = 0; i < gameConstants.numberOfInvaders; i++){
                invaderArray.get(i).move(gameConstants.right);
            }
        }else if (((invaderArray.get(0).getX() - gameConstants.invaderMoveSpeed) >= 0 ) && !invadersGoingRight){
            for (int i = 0; i < gameConstants.numberOfInvaders; i++){
                invaderArray.get(i).move(gameConstants.left);
            }
        }else{
            invadersGoingRight = !invadersGoingRight;
            boolean killCheck = false;
            for (int i = gameConstants.numberOfInvaders-1; i >= 0; i--){
                if ((!killCheck)&&(invaderArray.get(i).shouldDisplay())){
                    if (invaderArray.get(i).getY() + gameConstants.invaderHeight >= gameConstants.killHeight){
                        newRound();
                    }
                    killCheck = true;
                }
                invaderArray.get(i).move(gameConstants.down);

            }
        }
    }
    public final void projectileDoCycle(){

        projectilesArray.forEach(p -> {
            if (p.shouldDisplay()){
                p.move();
            }
        });
        projectilesArray.forEach(p -> invaderArray.forEach(i ->{
            if (p.shouldDisplay()&&i.shouldDisplay()) {
                if ((p.getClass() == PlayerShot.class) && (p.collisionDetection(i.getX(), i.getY(), i.getWidth(), i.getHeight()))) {
                    addScore(i.Kill());
                    p.hasHit();
                }
            }
        }));
    }

    public final void createProjectile(String type, int x, int y){
        projectilesArray.add(projectilesArray.size(), projectileFactoryInstance.makeProjectile(type, x, y));
        if(type.equals(gameConstants.playerProjectileID)){
            AudioPlayer.playAudio(gameConstants.playerShootAudio);
        }
    }

    public final void endGame(){
        gameTimer.purge();
        saveHighscore();
        System.out.println("Game Over");
        AudioPlayer.playAudio(gameConstants.gameOver);
        System.exit(0);
    }

    private void saveHighscore(){
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
    private void addScore(int val){
        score += val;
        System.out.println(val+" added to score\nnew score:" + score);
        saveHighscore();
    }

    private void loadHighscore(){
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
    private int getHighscore(){
        return highscore;
    }
    public final ArrayList<invader> getInvaderArray() {
        return invaderArray;
    }
    public final ArrayList<Projectile> getProjectiles(){
        return projectilesArray;
    }
}
