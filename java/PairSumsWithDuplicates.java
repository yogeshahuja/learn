import java.io.*;
import java.util.*;
// Add any extra import statements you may need here
class PairSumsWithDuplicates {

    // Add any helper functions you may need here
    int numberOfWays(int[] arr, int k) {
        // Write your code here
        //Brute Force
        int count = 0;
        for(int i=0; i<= arr.length-2; i++) {
            for(int j=i+1;j<=arr.length-1;j++) {
                if(arr[i] + arr[j]==k) {
                    count++;
                }
            }
        }

        //Optimal using HashMap
        count =0;
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();

        for(int i=0; i<=arr.length-1;i++) {
            //populate hm with freq
            if(hm.containsKey(arr[i])) {
                int freq = hm.get(arr[i]);
                hm.put(arr[i],freq+1);
            } else {
                //first time
                hm.put(arr[i],1);
            }
        }
        Set<Integer> ss = hm.keySet();

        for(int s:ss) {
            int target = k - s;
            if(hm.containsKey(target)) {
                int f1 = hm.get(s);
                int f2 = hm.get(target);

                int combi = 0;
                if (s == target) {
                    //get nc2 of value and multiply by 2, as it's same number.
                    combi = 2*(factorial(f1) / (factorial(2)* factorial(f1-2)));
                }
                else {
                    combi = f1 * f2;
                }
                count = count + combi;
            }
        }

        return count/2;

    }
    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }
    int factorial(int n) {
        if (n==1) return 1;
        int fact =1;
        for (int i=1; i<=n; i++) {
            fact = fact *i;
        }
        return fact;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    //A B => AB =1
    //ABC => AB AC BC 3
    //ABCD => AB AC AD BC BD CD 6
    //A1 A2 B1 A1B1 A2B1 2
    //A1A2 B1 B2 = A1B1 A1B2 A2B1 A2B2 4

    public void run() {
        int k_1 = 6;
        int[] arr_1 = {1, 2, 3, 4, 3};
        int expected_1 = 2;
        int output_1 = numberOfWays(arr_1, k_1);
        check(expected_1, output_1);

        int k_2 = 6;
        int[] arr_2 = {1, 5, 3, 3, 3};
        int expected_2 = 4;
        int output_2 = numberOfWays(arr_2, k_2);
        check(expected_2, output_2);

        int k_3 = 6;
        int[] arr_3 = {1, 5, 3, 3, 3,3,2,4};
        int expected_3 = 8;
        int output_3 = numberOfWays(arr_3, k_3);
        check(expected_3, output_3);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new PairSumsWithDuplicates().run();
    }
}
