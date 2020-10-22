package Day10;

import javax.print.attribute.DocAttribute;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Day10 {

    public Map<List<Integer>, Integer> asteroids = new HashMap<>();

    public void readInput(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file).useDelimiter("\\Z");
        String dataString = scanner.next();
        scanner.close();
        dataString = dataString.replace("\n", "|");

        String character;
        int xIndex = 0;
        int yIndex = 0;

        for(int i=0; i < dataString.length(); i++){
            character = Character.toString(dataString.charAt(i));

            if(character.equals("#")){
                List<Integer> coordinates = new ArrayList<>();
                coordinates.add(xIndex);
                coordinates.add(yIndex);
                this.asteroids.put(coordinates, 0);
                xIndex++;
            } else if(character.equals("|")){
                xIndex = 0;
                yIndex++;
            } else {
                xIndex++;
            }
        }
    }



    public double calculateGradient(List<Integer> pointA, List<Integer> pointB){
        double changeInY = pointB.get(1) - pointA.get(1);
        double changeInX = pointB.get(0) - pointA.get(0);

        return changeInY / changeInX;
    }

    public double calculateDistance(List<Integer> pointA, List<Integer> pointB){
        double changeInY = pointB.get(1) - pointA.get(1);
        double changeInX = pointB.get(0) - pointA.get(0);

        return Math.sqrt(Math.pow(changeInX, 2) + Math.pow(changeInY, 2));
    }

    public void bestAsteroid(){
        for (List<Integer> asteroidA : this.asteroids.keySet()){
            Map<Double, List<Integer>> gradients = new HashMap<>();

            for (List<Integer> asteroidB : this.asteroids.keySet()) {
                double gradient = calculateGradient(asteroidA, asteroidB);

                if (gradients.containsKey(gradient) && calculateDistance(asteroidA, asteroidB) < calculateDistance(asteroidA, gradients.get(gradient))) {
                    gradients.replace(gradient, asteroidB);
                } else if (!gradients.containsKey(gradient)) {
                    gradients.put(gradient, asteroidB);
                }
            }
            this.asteroids.replace(asteroidA, gradients.size());
        }

        List<Integer> bestAsteroid = null;
        int maxValue = 0;

        for(Map.Entry<List<Integer>, Integer> entry : this.asteroids.entrySet()){
            if(entry.getValue() > maxValue){
                maxValue = entry.getValue();
                bestAsteroid = entry.getKey();
            }
        }

        System.out.println(this.asteroids);
        System.out.println(bestAsteroid);
        System.out.println(maxValue);
    }


    public static void main(String[] args) throws IOException {
        Day10 day10 = new Day10();

        day10.readInput("Data/Day10_input.txt");
        day10.bestAsteroid();
    }


}
