package xeon.player;

/**
 * User: xeon
 * Date: 12/25/12
 * Time: 2:17 PM
 */
public class Custom {
    public static void main(String args[]) {
        Player player = PlayerFactory.choosePlayer("realplayer");
        player.init();
        player.load();
        player.play();
        player.pause();
    }
}
