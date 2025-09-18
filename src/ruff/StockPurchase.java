package ruff;

public class StockPurchase {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public static int maxProfit(int[] prices) {
        int intervalProfit = 0, left = 0, right = 1;
        while(right < prices.length) {
            if(prices[right] > prices[left]) {
                int profit = prices[right] - prices[left];
                intervalProfit = Math.max(intervalProfit, profit);
            } else {
                left = right;
            }
            right++;
        }
        return intervalProfit;
    }
}
