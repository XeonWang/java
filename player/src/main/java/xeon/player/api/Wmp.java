package xeon.player.api;

/**
 * User: xeon
 * Date: 12/25/12
 * Time: 1:41 PM
 */
public class Wmp {

    public void wmpPlay() {
        System.out.println("Music sounding ... (Title: Windows Media Player)");
    }

    public void wmpPause() {
        System.out.println("Music paused ... (Title: Windows Media Player)");
    }

    public void wmpNext() {
        System.out.println("Next song sounding ... (Title: Windows Media Player)");
    }

    public void wmpPrevious() {
        System.out.println("Previous song sounding ... (Title: Windows Media Player)");
    }

    public void wmpLoad(){
        System.out.println("One song is loaded ... (Title: Windows Media Player)");
    }

}
