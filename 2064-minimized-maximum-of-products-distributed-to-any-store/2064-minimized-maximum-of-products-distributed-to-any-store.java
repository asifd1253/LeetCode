class Solution {
    boolean isDistributionPossible(int quantities[], int maxProducts, int stores){
        int storeCount = 0;

        for(int quantity : quantities){
            storeCount += (int)Math.ceil((double)quantity / maxProducts);
        }

        return (storeCount <= stores) ? true : false;
    }

    public int minimizedMaximum(int n, int[] quantities) {
        int minQuantity = 1;
        int maxQuantity = 0;
        for(int i : quantities){
            maxQuantity = Math.max(maxQuantity, i);
        }

        int ans = -1;

        while(minQuantity <= maxQuantity){
            int mid = minQuantity + (maxQuantity - minQuantity)/2;

            if(isDistributionPossible(quantities, mid, n)){
                ans = mid;
                maxQuantity = mid - 1;
            }else{
                minQuantity = mid + 1;
            }
        }

        return ans;
    }
}