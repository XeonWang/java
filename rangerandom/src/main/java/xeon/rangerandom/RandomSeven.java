package xeon.rangerandom;

/**
 * Created with IntelliJ IDEA.
 * User: xeon
 * Date: 12/24/12
 * Time: 10:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class RandomSeven {
    public static double gen() {
        double numLessThanFive = RandomFive.gen();
        return numLessThanFive / 5 * 7;
    }
}
