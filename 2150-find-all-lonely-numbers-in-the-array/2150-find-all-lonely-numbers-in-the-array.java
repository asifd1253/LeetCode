class Solution {
    public List<Integer> findLonely(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : arr){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        for(int i : map.keySet()){
            int currEle = i;
            if(map.containsKey(currEle - 1) || map.containsKey(currEle + 1)){
                continue;
            }else if(map.get(currEle) > 1){
                continue;
            }else{
                res.add(currEle);
            }
        }

        return res;
    }
}