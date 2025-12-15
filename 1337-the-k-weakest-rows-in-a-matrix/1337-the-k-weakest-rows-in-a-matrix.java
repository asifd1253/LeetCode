class Solution {
    public class Row implements Comparable<Row>{
        int soldiers ;
        int idx ;

        public Row(int soldiers,int idx){
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2){
            if(this.soldiers == r2.soldiers){
                return this.idx - r2.idx;
            }else{
                return this.soldiers - r2.soldiers;
            }
        }
    }
    public int[] kWeakestRows(int[][] army, int k) {
        PriorityQueue<Row> pq = new PriorityQueue<>();

        for(int i=0; i<army.length; i++){          //for row
            int count = 0;
            for(int j=0; j<army[0].length; j++){     //for column
                // count = count + army[i][j] == 1?1:0;
                // count = count + army[i][j];
                if(army[i][j] == 1){
                    count += 1;
                }
            }
            pq.add(new Row(count,i));
        }

        int arr[] = new int[k];
        for(int i=0; i<k; i++){
            arr[i] = pq.remove().idx;
        }

        return arr;
    }
}