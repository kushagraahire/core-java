public class Leetcode121 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        if(n == 1) return ans;
        int min = prices[0];
        for(int i = 0; i < n; i++){
            int sell = prices[i] - min;
            ans = Math.max(ans, sell);
            min = Math.min(min, prices[i]);
        }
        return ans;
    }
}
