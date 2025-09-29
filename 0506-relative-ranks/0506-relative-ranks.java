class Solution {
    public String[] findRelativeRanks(int[] score) {
        int temp[] = score.clone();

        Arrays.sort(temp);

        int left = 0;
        int right = temp.length-1;
        while(left < right){
            int cur = temp[left];
            temp[left] = temp[right];
            temp[right] = cur;

            left++;
            right--;
        }

        HashMap<Integer, String> map = new HashMap<>();
        for(int i=1; i<=temp.length; i++){
            if(i == 1) map.put(temp[i-1], "Gold Medal");
            else if(i == 2) map.put(temp[i-1], "Silver Medal");
            else if(i == 3) map.put(temp[i-1], "Bronze Medal");
            else map.put(temp[i-1], String.valueOf(i));
        }

        String res[] = new String[temp.length];

        int idx = 0;
        for(int i : score){
            res[idx++] = map.get(i);
        }

        return res;
    }
}