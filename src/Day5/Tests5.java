package Day5;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class Tests5 {

    @Test
    public void testSimpleChain(){
        Day5 day5 = new Day5();

        day5.allDirectOrbits.put("AAA", new ArrayList<String>(Arrays.asList("BBB")));
        day5.allDirectOrbits.put("BBB", new ArrayList<String>(Arrays.asList("CCC")));
        day5.allDirectOrbits.put("CCC", new ArrayList<String>(Arrays.asList("DDD")));

        assertEquals(day5.countDirectOrbits("AAA"), 3);
        assertEquals(day5.countDirectOrbits("BBB"), 2);
        assertEquals(day5.countDirectOrbits("CCC"), 1);
        assertEquals(day5.countDirectOrbits("DDD"), 0);
    }

    @Test
    public void testBranchedChain(){
        Day5 day5 = new Day5();

        day5.allDirectOrbits.put("AAA", new ArrayList<String>(Arrays.asList("BBB", "CCC")));
        day5.allDirectOrbits.put("BBB", new ArrayList<String>(Arrays.asList("EEE", "DDD")));
        day5.allDirectOrbits.put("CCC", new ArrayList<String>(Arrays.asList("FFF")));
        day5.allDirectOrbits.put("DDD", new ArrayList<String>(Arrays.asList("GGG")));

        assertEquals(day5.countDirectOrbits("AAA"), 6);
        assertEquals(day5.countDirectOrbits("BBB"), 3);
        assertEquals(day5.countDirectOrbits("CCC"), 1);
        assertEquals(day5.countDirectOrbits("DDD"), 1);
        assertEquals(day5.countDirectOrbits("EEE"), 0);
        assertEquals(day5.countDirectOrbits("FFF"), 0);
        assertEquals(day5.countDirectOrbits("GGG"), 0);
    }

    @Test
    public void testFindSmallestTransfers(){
        Day5 day5 = new Day5();

        day5.allDirectOrbiters.put("YYY", "ZZZ");
        day5.allDirectOrbiters.put("XXX", "YYY");
        day5.allDirectOrbiters.put("AAA", "XXX");
        day5.allDirectOrbiters.put("BBB", "AAA");
        day5.allDirectOrbiters.put("YOU", "BBB");
        day5.allDirectOrbiters.put("CCC", "XXX");
        day5.allDirectOrbiters.put("DDD", "CCC");
        day5.allDirectOrbiters.put("EEE", "DDD");
        day5.allDirectOrbiters.put("SAN", "EEE");

        assertEquals(day5.findSmallestTransfers("YOU","SAN"), 5);
    }
}



