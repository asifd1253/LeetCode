class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));

        int res = 1;

        int lastEnd = pairs[0][1];
        for(int pair[] : pairs){
            if(lastEnd < pair[0]){
                res++;
                lastEnd = pair[1];
            }
        }

        return res;
    }
}