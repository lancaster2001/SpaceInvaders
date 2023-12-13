import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class AudioPlayer {
    static void playAudio(String audioLinkString){

            try
            {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new File(audioLinkString)));
                clip.start();
                System.out.println("audio played");
            }
            catch (Exception e)
            {
                System.out.println("error at audio Player");
            }


    }
}
