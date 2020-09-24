package Day3;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Day3 {

    private static List<String> readFileToArray(String fileName, String delimiter) throws IOException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file).useDelimiter(delimiter);

        List<String> outputArray = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.next();
            outputArray.add(line);
        }
        scanner.close();
        return outputArray;
    }

    public static void main(String[] args) throws IOException {

        List<String> wireA = readFileToArray("Data/Day3_wireA.txt", ",");
        List<String> wireB = readFileToArray("Data/Day3_wireB.txt", ",");

        List<String> testA = new ArrayList<String>(List.of("R8","U5","L5","D3"));   //"R75","D30","R83","U83","L12","D49","R71","U7","L72"));
        List<String> testB = new ArrayList<String> (List.of("U7","R6","D4","L4"));        //"U62","R66","U55","R34","D71","R55","D58","R83"));

        //Set<CoordinateHolder> AllCoordinates = new HashSet<CoordinateHolder>();
        Map<CoordinateHolder, Integer> AllCoordinates = new HashMap<>();

        List<CoordinateHolder> intercepts = new ArrayList<CoordinateHolder>();

        int manhattanDistance;
        double shortestManhattanDistance = Double.POSITIVE_INFINITY;
        double shortestDistanceTravelled = Integer.MAX_VALUE;

        int x = 0;
        int y = 0;

        int distanceTravelledA =0;
        int distanceTravelledB =0;


        for (String instruction : wireA){
            char direction = instruction.charAt(0);
            int distance = Integer.parseInt(instruction.substring(1));

            for (int i =0; i<distance; i++){
                if (direction == 'R') {
                    x += 1;
                } else if (direction == 'U') {
                    y += 1;
                } else if (direction == 'L') {
                    x -= 1;
                } else if (direction == 'D') {
                    y -= 1;
                }

                distanceTravelledA += 1;

                CoordinateHolder newCoordinates = new CoordinateHolder(x,y);
                AllCoordinates.put(newCoordinates, distanceTravelledA);
            }
        }

        x=0;
        y=0;

        for (String instruction : wireB){
            char direction = instruction.charAt(0);
            int distance = Integer.parseInt(instruction.substring(1));

            for (int i =1; i<=distance; i++){
                if (direction == 'R') {
                    x += 1;
                } else if (direction == 'U') {
                    y += 1;
                } else if (direction == 'L') {
                    x -= 1;
                } else if (direction == 'D') {
                    y -= 1;
                }

                distanceTravelledB += 1;

                CoordinateHolder newCoordinates = new CoordinateHolder(x,y);
                manhattanDistance = Math.abs(x)+ Math.abs(y);

                Integer travelledA = AllCoordinates.get(newCoordinates);

                if(travelledA != null) {
                    if (manhattanDistance < shortestManhattanDistance) {
                        shortestManhattanDistance = manhattanDistance;
                    //System.out.println(newCoordinates);
                    }

                    if (travelledA + distanceTravelledB < shortestDistanceTravelled){
                        shortestDistanceTravelled = travelledA + distanceTravelledB;
                    }
                }

            }
        }

        System.out.println(shortestDistanceTravelled);
        System.out.println(shortestManhattanDistance);
    }

    private static class CoordinateHolder {
        private final int x;
        private final int y;
        //private final int distanceTravelled;


        private CoordinateHolder(int x, int y) {
            this.x = x;
            this.y = y;
            //this.distanceTravelled = distanceTravelled;

        }

//        private int totalDistance(CoordinateHolder coordinate) {
//            return this.distanceTravelled + coordinate.distanceTravelled;
//        }

        @Override
        public String toString() {
            return "(" + this.x + "," + this.y + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CoordinateHolder that = (CoordinateHolder) o;
            return x == that.x &&
                    y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}






