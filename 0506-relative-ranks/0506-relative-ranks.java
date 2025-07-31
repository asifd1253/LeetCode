class Solution {
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer, String> map = new HashMap<>();

        int temp[] = score.clone();
        Arrays.sort(temp);
        int left = 0;
        int right = temp.length-1;
        while(left < right){
            int a = temp[left];
            temp[left] = temp[right];
            temp[right] = a;
            left++;
            right--;
        }

        for(int i=1; i<=temp.length; i++){
            if(i == 1){
                map.put(temp[i-1], "Gold Medal");
            }else if(i == 2){
                map.put(temp[i-1], "Silver Medal");
            }else if(i == 3){
                map.put(temp[i-1], "Bronze Medal");
            }else{
                map.put(temp[i-1], String.valueOf(i));
            }
        }

        String res[] = new String[score.length];
        for(int i=0; i<res.length; i++){
            res[i] = map.get(score[i]);
        }

        return res;
    }
}