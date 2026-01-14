class Solution {
    public int pivotIndex(int[] nums) {
        int totSum = 0;

        for(int i : nums){
            totSum += i;
        }

        int leftSum = 0;
        int rightSum = 0;

        for(int i=0; i<nums.length; i++){
            rightSum = totSum - leftSum - nums[i];

            if(leftSum == rightSum) return i;

            leftSum += nums[i];
        }

        return -1;
    }
}