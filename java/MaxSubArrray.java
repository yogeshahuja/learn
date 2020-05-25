import java.util.Arrays;

public class MaxSubArray {

    public static void main(String args[]) {
        System.out.println("SubArrayForSum.main");
        int[] a = {10,-9,1,2,3,10,20,100,-55,40};
        int maxSum = 0;
        int i=0;
        int j =0;
        int maxI=0, maxJ=0;
        int currentSum = 0;
        for(i=0; i<=a.length-1; i++) {
            currentSum = 0;
            for(j=i; j<=a.length-1; j++) {
                //System.out.println("i = " + i + " and j is " + j + " and currentSUm is " + currentSum);
                currentSum = currentSum + a[j];
                if(currentSum > maxSum) {
                    maxSum = currentSum;
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        System.out.println("maxI = " + maxI + " and maxJ is " + maxJ + " maxSum is " + maxSum);
    }
}
