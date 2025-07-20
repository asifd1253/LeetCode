class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean asce = false;
        boolean desc = false;

        for(int i=0; i<nums.length-1; i++){
            if(nums[i] < nums[i+1]){
                asce = true;
            }
            
            if(nums[i] > nums[i+1]){
                desc = true;
            }
        }

        if(asce && desc){
            return false;
        }
        return true;
    }
}