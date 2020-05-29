//Find minimum number of coins to make target sum.

class DPMinMumCoinsForChange {
    public static void main(String[] args){

        int[] coins = {1,2,48};
        int sum = 49;

        int coinsCount = coinChangeProblem(coins,sum);
        System.out.println("coinsCount = " + coinsCount);
        
    }

    public static int coinChangeProblem(int[] coins, int sum){

        int totalCoins = coins.length;

        // Creating array which stores subproblems' solutions
        double[][] arr = new double[totalCoins + 1][sum + 1];

        // Initialising first row with +ve infinity
        for(int j = 0; j <= sum; j++){
            arr[0][j] = Double.POSITIVE_INFINITY;
        }

        // Initialising first column with 0
        for(int i = 1; i <= totalCoins; i++){
            arr[i][0] = 0;
        }

        for(int i = 1; i <= totalCoins; i++){
            for(int j = 1; j <= sum; j++){
                if(coins[i - 1] <= j){
                    //this coin is smaller than sum, so let's use it
                    arr[i][j] = Math.min(1 + arr[i][j - coins[i - 1]], arr[i - 1][j]);
                }
                else {
                    //this coin is bigger than sum, so can not participate, use previous value
                    arr[i][j] = arr[i - 1][j];
                }
            }
        }
        return (int)arr[totalCoins][sum];
    }


}
