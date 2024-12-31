class Solution {
    public int[]  dijikstra(int src,int n,ArrayList<ArrayList<int[]>> adj){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{src,0});

        int time[] = new int[n];
        Arrays.fill(time,Integer.MAX_VALUE);
        time[src] = 0;

        while(!pq.isEmpty()){
            int pair[] = pq.remove();
            int u = pair[0];
            int w = pair[1];

            // base case
            if(w < time[u]){
                continue;
            }

            for(int[] neighbour : adj.get(u)){
                int v = neighbour[0];
                int d = neighbour[1];

                if(time[u]+d < time[v]){
                    time[v]= time[u]+d;
                    pq.add(new int[]{v,time[v]});
                }
            }
        }

        return time;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] neighbour : times){
            int u = neighbour[0]-1;
            int v = neighbour[1]-1;
            int w = neighbour[2];

            adj.get(u).add(new int[]{v,w});
        }

        int minTime[] = dijikstra(k-1,n,adj);
        int res = Integer.MIN_VALUE;

        for(int min : minTime){
            res = Math.max(res,min);
        }

        return (res==Integer.MAX_VALUE)?-1:res;
    }
}