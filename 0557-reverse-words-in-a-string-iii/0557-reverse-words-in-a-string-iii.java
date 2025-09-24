class Solution {
    public String reverseWords(String s) {
        String words[] = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for(String word : words){
            StringBuilder curSb = new StringBuilder();
            for(int i=word.length()-1; i>=0; i--){
                curSb.append(word.charAt(i));
            }
            
            if(sb.length() == 0){
                sb.append(curSb);
            }else{
                sb.append(" ").append(curSb);
            }
            
        }

        return sb.toString();
    }
}