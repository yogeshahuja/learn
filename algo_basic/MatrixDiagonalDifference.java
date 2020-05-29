//Given a square matrix, calculate the absolute difference between the sums of its diagonals.
/**
*Given a square matrix, calculate the absolute difference between the sums of its diagonals.

*For example, the square matrix  arr is shown below:

1  2  3
4  5  6
9  8  9

*The left-to-right diagonal = 1+5+9=15 . The right to left diagonal =3+5+9=17 . Their absolute difference is |15-17| = 2
**/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class MatrixDiagonalDifference {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
    // Write your code here
    int sum1 = 0;
    int sum2 = 0;

    //take to column variable, one for left diagonal and another for right one.
    int column1 = 0; //for left one, starts from 1st column
    int column2 = arr.size()-1; // for right one, starts from last column
    for(int i=0; i<=arr.size()-1; i++) {
            sum1 = sum1 + arr.get(i).get(column1++);
            sum2 = sum2 + arr.get(i).get(column2--);
    }
    int diff = Math.abs(sum1-sum2);
    return diff;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
