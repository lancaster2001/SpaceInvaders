import java.awt.image.BufferedImage;

public interface Projectile {

    void setX(int x);

    void setY(int y);

    int getX();

    int getY();

    void hasHit();

    boolean shouldDisplay();

    BufferedImage getImage();

    int getWidth();
    int getHeight();
}