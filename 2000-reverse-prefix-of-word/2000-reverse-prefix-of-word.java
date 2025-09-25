class Solution {
    public String reversePrefix(String word, char ch) {
        int idx = -1;
        boolean flag = false;

        for(char c : word.toCharArray()){
            idx++;
            if(c == ch && flag == false){
                flag = true;
                break;
            }
        }

        if(flag == false){
            return word;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=idx; i>=0; i--){
            sb.append(word.charAt(i));
        }

        for(int i=idx+1; i<word.length(); i++){
            sb.append(word.charAt(i));
        }

        return sb.toString();
    }
}