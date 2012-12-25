package xeon.player;

import xeon.player.actual.ActualRealPlayer;
import xeon.player.actual.ActualWMP;
import xeon.player.api.Wmp;

/**
 * User: xeon
 * Date: 12/25/12
 * Time: 2:18 PM
 */
public class PlayerFactory {
    public static Player choosePlayer(String type) {
        if ("wmp".equalsIgnoreCase(type)) {
            return new ActualWMP();
        } else if ("realplayer".equalsIgnoreCase(type)) {
            return new ActualRealPlayer();
        }
        return null;
    }
}
