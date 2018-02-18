package saddlePoints
import java.util.Random;
import java.util.Arrays;

/**
 * Creates a number of random arrays, and checks each array to see
 * if it contains a saddle point. Prints the arrays and the results.
 *
 * @Haroon Shinwari
 */
public class Demo {
    /**
     * Creates arrays various sizes (including some 2x2 arrays and some larger),
     * fills them with random values, and prints each array and information about
     * it. Keeps generating arrays until it has printed at least one with and
     * one without a saddle point.
     */

    void run() {

        int trueCount = 0;
        int falseCount = 0;

        while (trueCount == 0 || falseCount == 0){
            int numberOfRows = randomNumGenColxRow();
            int numberOfColumns = randomNumGenColxRow();
            int minValue = -5;
            int maxValue = 5;
            int randomArray [][]  = createRandomArray(numberOfRows, numberOfColumns, minValue, maxValue);
            printTwoDArray(randomArray);
            System.out.println();

            boolean sadPoint = hasSaddlePoint(randomArray);
            System.out.println("this array has");
            if (sadPoint == true){
                trueCount = trueCount + 1;
                int sadPointRow = saddlePointRow(randomArray);
                int sadPointColumn = saddlePointColumn(randomArray);
            }
            else {
                System.out.println("no saddle points");
                falseCount = falseCount + 1;
            }
        }
    }


    int randomNumGenColxRow() {
        Random randomNum = new Random();
        int randomNumber = 2 + (randomNum.nextInt((5 - 2) + 1));
        return randomNumber;
    }


    /**
     * Prints the array.
     *
     * @param array The array to be printed.
     */
    void printTwoDArray(int[][] array) {
        System.out.println(Arrays.deepToString(array).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
    }

    void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }


    /**
     * Creates and returns an array of the given size and fills it with random
     * values in the specified range.
     *
     * @param numberOfRows    The number of rows desired.  [random range 2 to 5]
     * @param numberOfColumns The number of columns desired.[random range 2 to 5]
     * @param minValue        The smallest number allowable in the array. [random range -20 to 20]
     * @param maxValue        The largest number allowable in the array.  [random range -20 to 20]
     * @return
     */
    int[][] createRandomArray(int numberOfRows, int numberOfColumns, int minValue, int maxValue)
    {
        int [][] randomArray = new int[numberOfRows][numberOfColumns];
        for (int i = 0; i < randomArray.length; i++) {
            for (int j = 0; j < randomArray[i].length; j++) {
                randomArray[i][j] = randomArrayFill(minValue, maxValue);
            }
        }
        return randomArray;
    }

    int randomArrayFill(int minValue, int maxValue) {
        Random randomNum = new Random();
        int randomNumber = minValue + randomNum.nextInt((maxValue - minValue) + 1);
        return randomNumber;
    }

    /**
     * Returns an array containing the largest values in each column of the given array.
     *
     * @param array The array to be searched.
     * @return An array of the largest values in each column.
     */
    int[] largestValues(int[][] array) {
        int [] largestColArray = new int[array[0].length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array[0].length; i++) { // i should be your column
            max = array[0][i];// assign 1st value of the column as max
            for (int j = 0; j < array.length; j++){ // j is your row
                if (array[j][i] > max){ // check the column elements instead of row elements
                    max = array[j][i];// get the column
                }
            }
            largestColArray[i] = max;
        }
        return largestColArray;
    }

    int[] smallestValues(int[][] array) {
        int [] smallestRowArray = new int[array.length];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) { // i should be your row
            min = array[i][0];
            for (int j = 0; j < array[0].length; j++){ // j is your col
                if (min > array[i][j]){ // check the column elements instead of row elements
                    min = array[i][j];// get the column
                }
            }
            smallestRowArray[i] = min;
        }
        return smallestRowArray;
    }

    int largest(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0;i<array.length;i++){
            if (array[i] > max)
            {
                max = array[i];
            }
        }
        return max;
    }

    int smallest(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i = 0;i<array.length;i++){
            if (array[i] < min)
            {
                min = array[i];
            }
        }
        return min;
    }

    boolean hasSaddlePoint(int[][] array){
        int largeArray [] = largestValues(array);
        int smallArray [] = smallestValues(array);
        int largestNum = largest(smallArray);
        int smallestNum = smallest(largeArray);
        if (largestNum == smallestNum) {
            return true;
        }
        return false;
    }

    int saddlePointRow(int[][] array){
        int sadPointRow = 0;
        int smallArray [] = smallestValues(array);
        int largestNum = largest(smallArray);
        for (int i = 0; i<smallArray.length;i++){
            if (smallArray[i] == largestNum){
                System.out.println("saddle point on row " + i);
            }
            sadPointRow = i;
        }
        return sadPointRow;
    }

    int saddlePointColumn(int[][] array){
        int sadPointCol = 0;
        int largeArray [] = largestValues(array);
        int smallestNum = smallest(largeArray);
        for (int i = 0; i<largeArray.length;i++){
            if (largeArray[i] == smallestNum){
                System.out.println("saddle point on column " + i);
            }
            sadPointCol = i;
        }
        return sadPointCol;
    }
}