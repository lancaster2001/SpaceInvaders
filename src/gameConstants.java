import java.awt.*;
import java.awt.event.KeyEvent;

public interface gameConstants{
        //save
        String highscore = "highscore.txt";
        int tickLength = 1000;
        //screen values
        Dimension screenSize = new Dimension(1920,1080);

        //audio links
        String playerShootAudio = "src/audio/shoot.wav";
        String bumpaudio = "src/audio/bump.wav";


        //invader values
        int killHeight = 700;
        String[] invaderOrder = {"SMALL","MEDIUM","LARGE"};
        double invaderMoveTimer = 3.0;
        int invaderMoveSpeed = 200;
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
        int invaderProjectileMoveSpeed = 100;//must be smaller than player height

        //Player values
        int playerMoveSpeed = 10;
        String playerImage = "src/images/player.png";
        int playerWidth = 100;
        int playerHeight = 100;
        String playerProjectileImage = "src/images/playerProjectile.png";
        String playerProjectileID = "yep this sure is a player shot";
        int playerProjectileHeight = 50;
        int playerProjectileWidth = 20;
        int playerProjectileMoveSpeed = 100;//must be smaller than invader height


        //controls
        char left = 'a';
        char right = 'd';
        char shoot = ' ';
        char down = 's';
}
