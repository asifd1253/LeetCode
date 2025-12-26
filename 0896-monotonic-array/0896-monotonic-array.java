class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean asceFlag = false;
        boolean descFlag = false;

        for(int i=0; i<nums.length-1; i++){
            if(nums[i] < nums[i+1]){
                asceFlag = true;
            }else if(nums[i] > nums[i+1]){
                descFlag = true;
            }
        }

        if(asceFlag && descFlag) return false;

        return true;
    }
}