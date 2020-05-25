import java.util.Arrays;

public class FindSubArrayForGivenSum {

    public static void main(String args[]) {
        System.out.println("SubArrayForSum.main");
        int[] a = {10,-9,1,2,3,10,20,100,-55,40};
        int findSum = 60;
        int i=0;
        int j =0;
        boolean found = false;
        int startI=0, endI=0;
        int currentSum = 0;
        for(i=0; i<=a.length-1; i++) {
            currentSum = 0;
            for(j=i; j<=a.length-1; j++) {
                //System.out.println("i = " + i + " and j is " + j + " and currentSUm is " + currentSum);
                currentSum = currentSum + a[j];
                if(currentSum == findSum) {
                    found = true;
                    startI = i;
                    endI = j;
                    break;
                }
            }
            if(found) break;
        }

        System.out.println("found is " + found + " startI = " + startI + " and endI is " + endI);
    }
}
