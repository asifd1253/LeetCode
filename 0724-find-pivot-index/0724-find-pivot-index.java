class Solution {
    public int pivotIndex(int[] arr) {
        int totalSum = 0;
        for(int i : arr){
            totalSum += i;
        }

        int leftSum = 0;
        int rightSum = 0;

        for(int i=0; i<arr.length; i++){
            rightSum = totalSum - leftSum - arr[i];

            if(leftSum == rightSum){
                return i;
            }

            leftSum += arr[i];
        }

        return -1;
    }
}