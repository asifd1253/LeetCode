class Solution {
    public int findJudge(int n, int[][] trust) {
        int indegree[] = new int[n+1];
        int outdegree[] = new int[n+1];

        for(int neighbour[] : trust){
            int u = neighbour[0];
            int v = neighbour[1];

            indegree[v]++;
            outdegree[u]++;
        }

        for(int i=1; i<outdegree.length; i++){
            if(outdegree[i] == 0 && indegree[i] == n-1){
                return i;
            }
        }

        return -1;
    }
}