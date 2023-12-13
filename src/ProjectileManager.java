import java.util.ArrayList;

public class ProjectileManager {
    private static final ProjectileFactory projectileFactoryInstance = ProjectileFactory.getInstance();//singleton instance of projectile factory
    private final MainPanel panelInstance = MainPanel.getInstance();//singleton instance of jpanel
    private ArrayList<Projectile> projectilesArray;
    public ProjectileManager(){
        System.out.println("make sure you only print this once for projectile manager");
    }
    private static ProjectileManager instance;
    public static ProjectileManager getInstance() {
        if(instance == null) {
            instance = new ProjectileManager();
        }
        return instance;
    }
    public void createProjectile(String type, int x, int y) {
        projectilesArray.add(projectileFactoryInstance.makeProjectile(type, x, y));
        if(type.equals(gameConstants.playerProjectileID)){
            AudioPlayer.playAudio(gameConstants.playerShootAudio);
        }
    }

    public ArrayList<Projectile> getProjectiles(){
        return projectilesArray;
    }
}
