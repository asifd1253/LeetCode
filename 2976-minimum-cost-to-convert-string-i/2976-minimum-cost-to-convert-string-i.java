class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int dist[][] = new int[26][26];
        for(int i=0; i<26; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for(int i=0; i<original.length; i++){
            int start = original[i] - 'a';
            int end = changed[i] - 'a';
            dist[start][end] = Math.min(dist[start][end],cost[i]);
        }

        for(int via=0; via<26; via++){
            for(int i=0; i<26; i++){
                if(dist[i][via] < Integer.MAX_VALUE){
                    for(int j=0; j<26; j++){
                        if(dist[via][j] < Integer.MAX_VALUE){
                            dist[i][j] = Math.min(dist[i][j],dist[i][via]+dist[via][j]);
                        }
                    }
                }
            }
        }

        Long res = 0L;
        for(int i=0; i<source.length(); i++){
            int c1 = source.charAt(i) - 'a';
            int c2 = target.charAt(i) - 'a';
            if(dist[c1][c2] == Integer.MAX_VALUE){
                return -1L;
            }
            res += (long)dist[c1][c2];
        }

        return res;
    }
}