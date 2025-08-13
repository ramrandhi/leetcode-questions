package ruff;

public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int left = 0, maxProfitWindow = 0;
        for(int right = 1;right<prices.length;right++) {
            if(prices[right] < prices[right - 1]) {
                left = right;
            } else {
                maxProfitWindow = maxProfitWindow + prices[right] - prices[left];
            }
        }
        return maxProfitWindow;
    }
}
