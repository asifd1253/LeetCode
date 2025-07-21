class Solution {
    public int mostFrequent(int[] arr, int key) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] == key){
                map.put(arr[i+1], map.getOrDefault(arr[i+1], 0)+1);
            }
        }

        int max = Integer.MIN_VALUE;
        int ans = 0;
        for(int i : map.keySet()){
            if(map.get(i) > max){
                max = map.get(i);
                ans = i;
            }
        }

        return ans;
    }
}