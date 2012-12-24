package xeon.rangerandom;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: xeon
 * Date: 12/23/12
 * Time: 10:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class RandomFiveTest {
    @Test
    public void testGen() {
        for (int i = 0; i < 5; i++) {
            double test = RandomFive.gen();
            assert between(test, 0, 5);
        }
    }

    private boolean between(double test, double begin, double end) {
        return test > begin && test < end;
    }
}
