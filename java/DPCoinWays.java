//Coin change problem: finding the number of ways to make a sum

import java.util.Arrays;

public class DPCoinWays {

    public static void main(String[] args) {

        System.out.println("DPCoinWays.main");

        int[] coins = {1,2,3,5,8,13,21,34};
        Arrays.sort(coins);
        int target = 5;
        int[][] dp;
        dp = new int[coins.length+1][target+1];

        //there is only one way to make sum as 0, don't pick any coin
        for(int i=0;i<=coins.length;i++) {
            dp[i][0] = 1;
        }
        
        //coins[1] => 1st coin and coins[n] = nth coin. So, outer loop 1...coins.length
        // j loop is for all sums 1 to target. So, j is 1...target

        for(int i=1; i<=coins.length; i++) {
            for(int j=1; j<=target; j++) {
                if(coins[i-1] > j) {
                    //coin is greater than target, so this coin can not participate.
                    //pick the ways value from last biggest coin so far
                    dp[i][j] = dp[i-1][j];
                } else {
                    //ways = ways till last biggest coin(exclude) + including this coin
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }

        System.out.println("ways = " + dp[coins.length][target]);
    }
}
