import java.util.ArrayList;

public class ProjectileManager {
    private static final ProjectileFactory projectileFactoryInstance = ProjectileFactory.getInstance();//singleton instance of projectile factory
    private ArrayList<Projectile> projectilesArray = new ArrayList<Projectile>();;
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
    public void createProjectile(String type, int x, int y){
        projectilesArray.add(projectilesArray.size(), projectileFactoryInstance.makeProjectile(type, x, y));
        if(type.equals(gameConstants.playerProjectileID)){
            AudioPlayer.playAudio(gameConstants.playerShootAudio);
        }
    }

    public void doCycle(){

        projectilesArray.forEach(p -> {
            if (p.shouldDisplay()){
                p.move();
            }
        });
    }


    public ArrayList<Projectile> getProjectiles(){
        return projectilesArray;
    }
}
