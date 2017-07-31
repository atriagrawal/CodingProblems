import java.util.Scanner;

public class CoinChange {
    static long[] ways = new long[251];
    
    public static long makeChange(int[] coins, int money) {
        ways[0] = 1;
        preprocess(coins, money);
        return ways[money];
    }
    
    public static long makeChange(int[] coins, int money, int index) {
        if (ways[money] > 0) 
            return ways[money];
        if (index >= coins.length)
            return 0;
        if (money < 0)
            return 0;
        
        long change = 0;
        int remainingAmount = money;
        while(remainingAmount > 0) {
            remainingAmount = remainingAmount - coins[index];
            change += makeChange(coins, remainingAmount, index+1);
            remainingAmount = remainingAmount - coins[index];
        }
        return change;
    }
    
    public static void preprocess(int[] coins, int money) {
        for (int i = 1; i <= money; i++) {
            ways[i] = makeChange(coins, i, 0);
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        System.out.println(makeChange(coins, n));
    }
}
