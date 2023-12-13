import java.awt.image.BufferedImage;

public interface DisplayObject {
    BufferedImage getImage();
    int getX();
    int getY();
    int getHeight();
    int getWidth();
    boolean shouldDisplay();

}
