package xeon.tank.abs;

/**
 * User: xeon
 * Date: 1/5/13
 * Time: 4:34 PM
 */
public interface Manager <T extends AbstractComponent> {
    public void destroyItem(T item);
}
