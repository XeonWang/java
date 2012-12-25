package xeon.player.api;

/**
 * User: xeon
 * Date: 12/25/12
 * Time: 1:46 PM
 */
public class RealPlayer {

    public void realPlay() {
        System.out.println("Music sounding ... (Title: RealPlayer)");
    }

    public void realPause() {
        System.out.println("Music paused ... (Title: RealPlayer)");
    }

    public void realNext() {
        System.out.println("Next song sounding ... (Title: RealPlayer)");
    }

    public void realPrevious() {
        System.out.println("Previous song sounding ... (Title: RealPlayer)");
    }

    public void realLoad(){
        System.out.println("One song is loaded ... (Title: RealPlayer)");
    }

}
