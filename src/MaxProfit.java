

public class MaxProfit {

     int maxProfit(int[] prices)  {
         if (prices.length <2) return 0;
         int minPrice = prices[0];
         int profit = 0;
         for (int i = 1; i < prices.length; i++) {
             minPrice = Math.min(minPrice, prices[i]);
             profit = Math.max (profit, prices[i] - minPrice);
         }
         return profit;
    }

    public static void main(String arg[]) {

        MaxProfit maxProfit = new MaxProfit();
        int[] nums = {7,1,5,3,6,4};


        System.out.println(maxProfit.maxProfit(nums));
    }
}
