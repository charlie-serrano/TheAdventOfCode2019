package Day10;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests10 {

    @Test
    public void TestReadInput() throws IOException {
        Day10 day10 = new Day10();
        day10.readInput("Data/Day10_input.txt");

        assertEquals(true, day10.asteroids.keySet().contains(new ArrayList<>(Arrays.asList(14,0))));
        assertEquals(true, day10.asteroids.keySet().contains((new ArrayList<>(Arrays.asList(16,0)))));

    }

    @Test
    public void TestCalculateGradient() throws IOException{
        Day10 day10 = new Day10();
        List<Integer> pointA = new ArrayList<>(Arrays.asList(1,1));
        List<Integer> pointB = new ArrayList<>(Arrays.asList(1,2));
        assertEquals(Double.POSITIVE_INFINITY, day10.calculateGradient(pointA, pointB), 0);

        pointA = new ArrayList<>(Arrays.asList(1,1));
        pointB = new ArrayList<>(Arrays.asList(2,1));
        assertEquals(0.0, day10.calculateGradient(pointA, pointB), 0);

        pointA = new ArrayList<>(Arrays.asList(1,1));
        pointB = new ArrayList<>(Arrays.asList(-1,1));
        assertEquals(-0.0, day10.calculateGradient(pointA, pointB), 0);



    }
}
