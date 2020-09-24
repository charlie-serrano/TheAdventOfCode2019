package Day4;

import java.util.ArrayList;
import java.util.List;

public class Day4 {

    public int calculatePasswords(int lowerBound, int upperBound) {
        int count =0;

        for (int i = lowerBound; i <= upperBound; i++){
            if (has2RepeatingDigits(i) && hasNoDecreasingDigits(i)) {
                count++;
            }
        }
        return count;
    }

    public boolean has2RepeatingDigits(int number){
        int x = number % 10;
        int match = 0;
        List<Integer> matches = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            number = number/10;
            int y = number % 10;
            if(x == y) {
                match++;
            } else {
                matches.add(match);
                match = 0;
            }
            x = y;
        }
        matches.add(match);

        if (matches.contains(1)) return true;
        else return false;

    }

    public boolean hasNoDecreasingDigits(int number){
        int x = number % 10;

        for(int i = 0; i < 5; i++) {
            number = number/10;
            int y = number % 10;
            if(x < y) return false;
            x = y;
        }
        return true;

    }

    public static void main(String[] args) {
        Day4 answer = new Day4();

        System.out.println(answer.calculatePasswords(240298, 784956));
    }
}
