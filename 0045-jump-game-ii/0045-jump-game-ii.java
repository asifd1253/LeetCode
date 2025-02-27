class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        if(n == 1){
            return 0;
        }
        if(nums[0] == 0){
            return -1;
        }
    
        int dp[] = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n-1] = 0;
        for(int i=n-2; i>=0; i--){
            int steps = nums[i];
            int res = Integer.MAX_VALUE;
            for(int j=i+1; j<=i+steps && j<n; j++){
                if(dp[j] != Integer.MAX_VALUE){
                    res = Math.min(res, dp[j]+1);
                }
            }
            if(res != Integer.MAX_VALUE){
                dp[i] = res;
            }
        }

        return (dp[0] != Integer.MAX_VALUE)?dp[0]:-1;
    }
}