package Day7;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Day7 {

    private String readInput(String fileName) throws IOException {
        String data;
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data.trim();
    }

    public int compute(String input, int imageX, int imageY) {
        int layerSize = imageX * imageY;
        int numberOfLayers = input.length() / layerSize;

        if (input.length() % layerSize != 0){
            System.out.println("Layers must be the same size");
            return -1;
        }

        int numberOfZeros;
        int numberOfOnes;
        int numberOfTwos;

        int smallestNumberOfZeros = Integer.MAX_VALUE ;
        int onesTimesTwos = 0;

        for(int i = 0; i < numberOfLayers; i++){
            numberOfZeros = 0;
            numberOfOnes = 0;
            numberOfTwos = 0;

            for(int j = 0; j < layerSize; j++){
                char value = input.charAt(j + layerSize * i);
                switch(Character.getNumericValue(value)){
                    case 0: numberOfZeros++; break;
                    case 1: numberOfOnes++; break;
                    case 2: numberOfTwos++; break;
                }
            }

            if(numberOfZeros < smallestNumberOfZeros){
                smallestNumberOfZeros = numberOfZeros;
                onesTimesTwos = numberOfOnes * numberOfTwos;
            }
        }

        return onesTimesTwos;
    }

    public void createImage(String input, int imageX, int imageY, String outputFile) throws IOException {
        int layerSize = imageX * imageY;
        int numberOfLayers = input.length() / layerSize;

        FileWriter fileWriter = new FileWriter(outputFile);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        List<String> resultingImageArray = new ArrayList<>(Collections.nCopies(layerSize, "2"));
        String outputLine;
        String outputValue = "" ;

        for (int i = 0; i < layerSize; i++){
            for(int j = 0; j < numberOfLayers; j++){
                String value = Character.toString(input.charAt(j * layerSize + i));
                if (value.equals("0") || value.equals("1")){
                    resultingImageArray.set(i, value);
                    break;
                }
            }
        }

        for(int y = 0; y < imageY; y++){
            outputLine = "";
            for(int x = 0; x < imageX; x++){
                outputLine += resultingImageArray.get(y * imageX + x);
            }
            printWriter.println(outputLine);
            outputValue += outputLine;
        }
        System.out.println(outputValue);
        printWriter.close();
    }

    public static void main(String[] args) throws IOException {
        Day7 day7 = new Day7();

        String data = day7.readInput("Data/Day7_input.txt");
        System.out.println(day7.compute(data, 25, 6));
        day7.createImage(data, 25, 6, "Output/Day7.txt");


    }
}

