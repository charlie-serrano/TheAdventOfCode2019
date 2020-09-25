package Day4;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class Tests4 {
    @Test
    public void testHasRepeatingDigits() {
        Day4 x = new Day4();
        assertEquals(x.has2RepeatingDigits(112345),true);
        assertEquals(x.has2RepeatingDigits(123245),false);
        assertEquals(x.has2RepeatingDigits(111111),false);
    }

    @Test
    public void testHasNoDecreasingDigits() {
        Day4 x = new Day4();

        assertEquals(x.hasNoDecreasingDigits(111111), true);
        assertEquals(x.hasNoDecreasingDigits(123456), true);
        assertEquals(x.hasNoDecreasingDigits(222122), false);

    }








}
