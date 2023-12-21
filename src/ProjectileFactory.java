import java.util.ArrayList;
import java.util.Properties;

public class ProjectileFactory {
    public ProjectileFactory(){
        System.out.println("make sure you only print this once for projectile factory");
    }
    private static ProjectileFactory instance;
    public static ProjectileFactory getInstance() {
        if(instance == null) {
            instance = new ProjectileFactory();
        }
        return instance;
    }
    public final Projectile makeProjectile(String type, int x, int y){
        return switch (type) {
            case gameConstants.playerProjectileID -> new PlayerShot(x, y);
            case gameConstants.invaderProjectileID -> new InvaderShot(x, y);
            default -> null;
        };
    }

}
