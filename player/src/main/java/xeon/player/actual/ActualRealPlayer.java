package xeon.player.actual;

import xeon.player.Player;
import xeon.player.api.RealPlayer;

/**
 * User: xeon
 * Date: 12/25/12
 * Time: 2:00 PM
 */
public class ActualRealPlayer implements Player {

    private RealPlayer realPlayerAPI;

    @Override
    public void init() {
        realPlayerAPI = new RealPlayer();
    }

    @Override
    public void play() {
        realPlayerAPI.realPlay();
    }

    @Override
    public void pause() {
        realPlayerAPI.realPause();
    }

    @Override
    public void next() {
        realPlayerAPI.realNext();
    }

    @Override
    public void previous() {
        realPlayerAPI.realPrevious();
    }

    @Override
    public void load() {
        realPlayerAPI.realLoad();
    }
}
