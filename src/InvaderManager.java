import java.util.ArrayList;

public class InvaderManager {
        private static ArrayList<invader>  invaderArray = new ArrayList<invader>();
    private static final invaderFactory invaderFactoryInstance = invaderFactory.getInstance();//singleton instance of invader factory
    private boolean invadersGoingRight = true; //true for going right
    private static InvaderManager instance;
    public InvaderManager(){

        System.out.println("make sure you only print this once for invader manager");
    }
    public static InvaderManager getInstance() {
        if(instance == null) {
            instance = new InvaderManager();
        }
        return instance;
    }
    public void moveInvaders(){

    }
    public void createInvaders(){
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
    public void doCycle(){
        int rowLength = (gameConstants.numberOfInvaders/gameConstants.invaderOrder.length);
        if (((invaderArray.get(rowLength-1).getX() + gameConstants.invaderWidth + gameConstants.invaderMoveSpeed) <= gameConstants.screenSize.width)&& invadersGoingRight == true){
            for (int i = 0; i < gameConstants.numberOfInvaders; i++){
                invaderArray.get(i).move(gameConstants.right);
            }
        }else if (((invaderArray.get(0).getX() - gameConstants.invaderMoveSpeed) >= 0 ) && !invadersGoingRight){
            for (int i = 0; i < gameConstants.numberOfInvaders; i++){
                invaderArray.get(i).move(gameConstants.left);
            }
        }else{
            if (invadersGoingRight){
                invadersGoingRight = false;
            }else{
                invadersGoingRight = true;
            }
            boolean killCheck = false;
            for (int i = gameConstants.numberOfInvaders-1; i >= 0; i--){
                if ((!killCheck)&&(invaderArray.get(i).shouldDisplay())){
                    if (invaderArray.get(i).getY() + gameConstants.invaderHeight >= gameConstants.killHeight){
                        //todo endGame();

                    }
                    killCheck = true;
                }
                invaderArray.get(i).move(gameConstants.down);

            }
        }
    }

    public ArrayList<invader> getInvaderArray() {
        return invaderArray;
    }
}
