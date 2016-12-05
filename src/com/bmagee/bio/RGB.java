package com.bmagee.bio;

/**
 * Created by Ben Magee on 05/12/2016.
 * Contact me: ben@bmagee.com
 */
public class RGB {


    private static char nextCharacter(char currentOne, char currentTwo) {
        // If the current character in the row above is the same as its next neighbour,
        // this is also the character to use in the row below
        // Eg:
        // RR
        // R
        if(currentOne == currentTwo) {
            return currentOne;
        }

        // RG | GR
        // B  | B
        if((currentOne == 'R' && currentTwo == 'G') || (currentOne == 'G' && currentTwo == 'R')) {
            return 'B';
        }

        // BG | GB
        // R  | R
        if((currentOne == 'B' && currentTwo == 'G') || (currentOne == 'G' && currentTwo == 'B')) {
            return 'R';
        }

        // BR | RB
        // G  | G
        if((currentOne == 'B' && currentTwo == 'R') || (currentOne == 'R' && currentTwo == 'B')) {
            return 'G';
        }

        // Default to R for no particular reason
        return 'R';
    }

    private static String calculate(String row) {
        String nextRow = "";
        char[] currentRowAsArray = row.toCharArray();

        if(row.length() == 2) {
            for(int i = 0; i < row.length() - 1; i++) {
                nextRow += nextCharacter(currentRowAsArray[i], currentRowAsArray[i+1]);
            }

            return nextRow;
        }

        for(int i = 0; i < row.length() - 1; i++) {
            nextRow += nextCharacter(currentRowAsArray[i], currentRowAsArray[i+1]);
        }

        return calculate(nextRow);
    }

    public static void main(String[] args) {
        System.out.println("RR Output: ");
        System.out.println(calculate("RR"));
        System.out.println();
        System.out.println();
        System.out.println("RG Output:");
        System.out.println(calculate("RG"));
        System.out.println();
        System.out.println();
        System.out.println("RGBRGBRGBR Output: ");
        System.out.println(calculate("RGBRGBRGBR"));
    }
}
