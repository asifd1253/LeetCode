class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : prices){
            if(price < buyPrice){
                buyPrice = price;
            }else{
                int curProfit = price - buyPrice;
                maxProfit = Math.max(maxProfit, curProfit);
            }
        }

        return maxProfit;
    }
}