class Solution {
    public String reverseWords(String s) {
        String arr[] = s.split(" ");
        StringBuilder res = new StringBuilder();

        for(String str : arr){
            for(int i=str.length()-1; i>=0; i--){
                res.append(str.charAt(i));
            }
            res.append(" ");
        }

        return res.toString().trim();
    }
}