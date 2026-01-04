class RowDetails implements Comparable<RowDetails>{
    int totalSoldiers;
    int rowIdx;

    RowDetails(int totalSoldiers, int rowIdx){
        this.totalSoldiers = totalSoldiers;
        this.rowIdx = rowIdx;
    }

    @Override
    public int compareTo(RowDetails row2){
        if(this.totalSoldiers == row2.totalSoldiers){
            return this.rowIdx - row2.rowIdx;
        }else{
            return this.totalSoldiers - row2.totalSoldiers;
        }
    }
}

class Solution {
    public int[] kWeakestRows(int[][] army, int k) {
        PriorityQueue<RowDetails> pq = new PriorityQueue<>();

        for(int row=0; row<army.length; row++){
            int counter = 0;
            for(int col=0; col<army[0].length; col++){
                if(army[row][col]== 1) counter++;
            }

            pq.offer(new RowDetails(counter, row));
        }

        int res[] = new int[k];
        for(int i=0; i<k; i++){
            res[i] = pq.remove().rowIdx;
        }

        return res;
    }
}