public class endGameState extends State{
    private static endGameState instance;
    public static endGameState getInstance() {
        if(instance == null) {
            instance = new endGameState();
        }
        return instance;
    }
}
