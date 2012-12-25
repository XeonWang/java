package xeon.player.actual;

import xeon.player.Player;
import xeon.player.api.Wmp;

/**
 * User: xeon
 * Date: 12/25/12
 * Time: 1:54 PM
 */
public class ActualWMP implements Player{

    private Wmp wmpAPI;

    @Override
    public void init() {
        wmpAPI = new Wmp();
    }

    @Override
    public void play() {
        wmpAPI.wmpPlay();
    }

    @Override
    public void pause() {
        wmpAPI.wmpPause();
    }

    @Override
    public void next() {
        wmpAPI.wmpNext();
    }

    @Override
    public void previous() {
        wmpAPI.wmpPrevious();
    }

    @Override
    public void load() {
        wmpAPI.wmpPrevious();
    }
}
