class Solution {
    public String reverseWords(String s) {
        String words[] = s.split(" ");

        StringBuilder res = new StringBuilder();

        boolean firstTime = true;

        for(String word : words){
            StringBuilder sb = new StringBuilder();

            for(int i=word.length()-1; i>=0; i--){
                sb.append(word.charAt(i));
            }

            if(firstTime == true){
                res.append(sb);
                firstTime = false;
            }else{
                res.append(" ").append(sb);
            }
        }

        return res.toString();
    }
}