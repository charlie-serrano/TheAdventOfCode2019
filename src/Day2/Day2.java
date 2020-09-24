package Day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {

    public List<String> readFileToArray(String fileName, String delimiter) throws IOException {
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

    private String runIntCode(List<String> code) {
        int arrayLength = code.size();
        int opCode;
        int index1;
        int index2;
        int index3;
        int valueAtIndex1;
        int valueAtIndex2;
        int iteration = 0;

        // 1","9","10","3","2","3","11","0","99","30","40","50
        for (int i = 0; i <= arrayLength - 4; i += 4) {
            iteration++;

            opCode = Integer.parseInt(code.get(i));
            index1 = Integer.parseInt(code.get(i + 1));
            index2 = Integer.parseInt(code.get(i + 2));
            index3 = Integer.parseInt(code.get(i + 3));

            if (opCode == 99) {
                //System.out.println("Code exited on iteration " + iteration + ". Index " + i + ".");
                break;
            }

//            if (index1 >= arrayLength || index2>= arrayLength || index3>= arrayLength){
//                return "-1";
//            }


            valueAtIndex1 = Integer.parseInt(code.get(index1));
            valueAtIndex2 = Integer.parseInt(code.get(index2));



            if (opCode == 1) {
                int sum = valueAtIndex1 + valueAtIndex2;
                code.set(index3, "" + sum);

            } else if (opCode == 2) {
                int product = valueAtIndex1 * valueAtIndex2;
                code.set(index3, "" + product);

            }
        }

        return code.get(0);
    }

    private void determineInput(String desiredOutput, List<String> memory) {
        String output;

        outerLoop :{
                for (int i = 0; i < 100; i++) {
                    for (int j = 0; j < 100; j++) {
                        List<String> input = new ArrayList<>(memory);
                        input.set(1, "" + i);
                        input.set(2, "" + j);

                        output = runIntCode(input);
                        System.out.println(output + " " + i + " " + j);
                        if (output.equals(desiredOutput)) {
                            System.out.println("noun: " + i);
                            System.out.println("verb: " + j);
                            break outerLoop;
                        }
                    }
                } }
            }

    public static void main(String[] args) throws IOException {
        Day2 day2 = new Day2();
        List<String> memory = day2.readFileToArray("Data/Day2__IntCode.txt", ",");
        // example data: new ArrayList(Arrays.asList("1","9","10","3","2","3","11","0","99","30","40","50"));

        memory.set(1,"12");
        memory.set(2, "2");
        System.out.println(day2.runIntCode(memory));
        //day2.determineInput("19690720", memory);

    }
}