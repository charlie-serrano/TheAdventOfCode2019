package Day7;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests7 {
    @Test
    public void testCompute() throws IOException {
        Day7 day7 = new Day7();
        String testData = "000111222000000000000000000";
        int testResult = 9;

        assertEquals(testResult, day7.compute(testData,3,30));
    }

    @Test
    public void testCreateImage() throws IOException {
        Day7 day7 = new Day7();
        day7.createImage("222222222000111222111111111", 3, 3, "Output/Day7_test.txt");
    }

    @Test
    public void testCreateImage2() throws IOException {
        Day7 day7 = new Day7();
        day7.createImage("0222112222120000", 2, 2, "Output/Day7_test2.txt");
    }

    @Test
    public void testCreateImage3() throws IOException {
        Day7 day7 = new Day7();
        day7.createImage("222211112121111100001010", 4, 3, "Output/Day7_test3.txt");
    }
}
