class Solution {
    public int balancedStringSplit(String s) {
        int Lcount = 0;
        int res = 0;

        for(char ch : s.toCharArray()){
            if(ch == 'L'){
                Lcount++;
            }else{
                Lcount--;
            }

            if(Lcount == 0){
                res++;
            }
        }

        return res;
    }
}