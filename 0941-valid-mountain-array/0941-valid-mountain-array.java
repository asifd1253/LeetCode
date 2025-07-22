class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;

        if(n <= 2){
            return false;
        }

        int idx = 0;

        while(idx < n-1){
            if(arr[idx] < arr[idx+1]){
                idx++;
            }else{
                break;
            }
        }

        if(idx == 0 || idx == n-1){
            return false;
        }

        while(idx < n-1){
            if(arr[idx] > arr[idx+1]){
                idx++;
            }else{
                break;
            }
        }

        return (idx == n-1)?true:false;
    }
}