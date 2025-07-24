/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int start = 0;
        int end = n-1;
        int mid = -1;

        while(start <= end){
            mid = start + (end - start)/2;
            int curMidEle = mountainArr.get(mid);
            if(mid != 0 && mid != n-1 && mountainArr.get(mid-1) < curMidEle && curMidEle > mountainArr.get(mid+1)){
                if(curMidEle == target){
                    return mid;
                }
                break;
            }else if(curMidEle < mountainArr.get(mid+1)){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        //search on first half
        start = 0;
        end = mid;
        while(start <= end){
            int m = start + (end - start)/2;
            int curEle = mountainArr.get(m);
            if(curEle == target){
                return m;
            }else if(target < curEle){
                end = m - 1;
            }else{
                start = m +1;
            }
        }

        //search on second half
        start = mid +1;
        end = n-1;

        while(start <= end){
            int m = start + (end - start)/2;
            int curEle = mountainArr.get(m);

            if(curEle == target){
                return m;
            }else if(target < curEle){
                start = m + 1;
            }else{
                end = m - 1;
            }
        }

        return -1;
    }
}