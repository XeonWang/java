package xeon.rangerandom;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: xeon
 * Date: 12/24/12
 * Time: 10:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class RandomSevenTest {
    @Test
    public void testGen() {
        double test;
        for (int i = 0 ; i < 10 ; i++) {
            test = RandomSeven.gen();
            assert between(test, 0, 7);
        }
    }

    private boolean between(double test, double begin, double end) {
        return test > begin && test < end;
    }
}
