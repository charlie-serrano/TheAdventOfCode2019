package Day1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Day1 {

    private static List<Integer> readFileToArray(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        List<Integer> outputArray = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            outputArray.add(Integer.parseInt(line));
        }
        scanner.close();
        return outputArray;
    }

    private static int calculateFuelRequirement(int mass) {
        // To find the fuel required for a module, take its mass, divide by three, round down, and subtract 2.
        int fuelRequirement;
        fuelRequirement = mass / 3 - 2;
        return fuelRequirement;
    }

    private static int calculateTotalFuelRequirement(List<Integer> listOfModules) {
        int totalFuelRequirement = 0;

        for (Integer mass : listOfModules) {
            int fuelRequirement;
            fuelRequirement = calculateFuelRequirement(mass);

            while (fuelRequirement > 0) {
                totalFuelRequirement += fuelRequirement;
                fuelRequirement = calculateFuelRequirement(fuelRequirement);
            }
        }
        return totalFuelRequirement;
    }

    public static void main(String[] args) throws IOException {
        List<Integer> listOfModules;
        listOfModules = readFileToArray("Data/Day1_fuelInput.txt");
        System.out.println(calculateTotalFuelRequirement(listOfModules));
    }
}

