class Solution {
    public int balancedStringSplit(String s) {
        int countR = 0;
        int countL = 0;
        int res = 0;

        for(char ch : s.toCharArray()){
            if(ch == 'R'){
                countR++;
            }else{
                countL++;
            }

            if(countR == countL){
                res++;

                countR = 0;
                countL = 0;
            }
        }

        return res;
    }
}