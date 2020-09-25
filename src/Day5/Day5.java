package Day5;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Day5 {

    public Map<String, ArrayList<String>> allDirectOrbits = new HashMap<>();

    public void readDirectOrbits(String fileName, String delimiter) throws IOException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file).useDelimiter(delimiter);

        while (scanner.hasNextLine()) {
            String line = scanner.next();
            allDirectOrbits.computeIfAbsent(line.substring(0,3), k -> new ArrayList<>()).add(line.substring(4));
        }
        scanner.close();
    }

    public int countDirectOrbits(String target){
            ArrayList<String> directOrbiters = allDirectOrbits.get(target);

            if (directOrbiters == null) return 0;
            int numberOfOrbits = directOrbiters.size();

            for (String orbiter : directOrbiters) {
                int result = countDirectOrbits(orbiter);
                numberOfOrbits += result;
            }

            return numberOfOrbits;
    }

    public int countAllOrbits() {
        int allOrbits = 0;

        for (String target : allDirectOrbits.keySet()){
           allOrbits += countDirectOrbits(target);
        }

        return allOrbits;
    }

    public static void main(String[] args) throws IOException {
        Day5 day5 = new Day5();
        day5.readDirectOrbits("Data/Day5-input.txt", "\\s");
        System.out.println(day5.countAllOrbits());
    }

}
