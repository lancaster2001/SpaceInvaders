import java.awt.*;


public interface gameConstants{
        //save
        String highscore = "highscore.txt";
        int tickLength = 800;
        //screen values
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenWidth = gd.getDisplayMode().getWidth();
        int screenHeight = gd.getDisplayMode().getHeight();
        Dimension screenSize = new Dimension(screenWidth,screenHeight);

        //audio links
        String playerShootAudio = "src/audio/shoot.wav";
        String bumpaudio = "src/audio/bump.wav";
        String gameOver = "src/audio/gameOver.wav";
        String playerDeath = "src/audio/playerDeath.wav";
        String invaderDeath = "src/audio/invaderkilled.wav";


        //invader values
        String[] invaderOrder = {"SMALL","MEDIUM","LARGE"};
        double invaderMoveTimer = 3.0;
        int invaderMoveSpeed = screenWidth/10-1;
        int numberOfInvaders = 30;
        int smallInvaderValue = 100;
        int mediumInvaderValue = 300;
        int largeInvaderValue = 500;
        int invaderWidth = 70;
        int invaderHeight = 70;
        String smallInvaderImage = "src/images/smallInvader.png";
        String mediumInvaderImage = "src/images/mediumInvader.png";
        String largeInvaderImage = "src/images/largeInvader.png";
        String invaderProjectileImage = "src/images/invaderProjectile.png";
        String invaderProjectileID = "yep this sure is an invader shot";
        int invaderProjectileHeight = 50;
        int invaderProjectileWidth = 20;
        int invaderProjectileMoveSpeed = screenHeight/20;//must be smaller than player height else projectile may skip over some invaders

        //Player values
        int playerMoveSpeed = 10;
        String playerImage = "src/images/player.png";
        int playerWidth = 100;
        int playerHeight = 100;
        String playerProjectileImage = "src/images/test.png";
        String playerProjectileID = "yep this sure is a player shot";
        int playerProjectileHeight = 50;
        int playerProjectileWidth = 20;
        int playerProjectileMoveSpeed = screenHeight/20;//must be smaller than invader height
        int killHeight = screenSize.height-playerHeight-100;


        //controls
        char left = 'a';
        char right = 'd';
        char shoot = ' ';
        char down = 's';
        char up = 'w';
}
