class Solution {
    public int scoreOfString(String s) {
        int res = 0;

        for(int i=0; i<s.length()-1; i++){
            int curChar = s.charAt(i);
            int nextChar = s.charAt(i+1);
            res += Math.abs(curChar - nextChar);
        }

        return res;
    }
}