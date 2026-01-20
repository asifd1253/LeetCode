class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());

        Double totSum = 0.0;

        for(int i : nums){
            totSum += Double.valueOf(i);
            pq.offer(Double.valueOf(i));
        }

        Double firstHalf = totSum/2.0;

        int oper = 0;

        while(totSum > firstHalf){
            Double curVal = pq.poll();

            Double curHalf = curVal/2.0;

            totSum = totSum - curHalf;

            pq.offer(curHalf);

            oper++;
        }

        return oper;
    }
}