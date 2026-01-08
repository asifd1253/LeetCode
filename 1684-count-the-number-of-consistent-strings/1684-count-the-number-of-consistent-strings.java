class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> set = new HashSet<>();

        for(char c : allowed.toCharArray()){
            set.add(c);
        }

        int res = 0;

        for(String curWord : words){
            boolean flag = true;
            for(char c : curWord.toCharArray()){
                if(set.contains(c)){
                    continue;
                }else{
                    flag = false;
                    break;
                }
            }

            if(flag == true){
                res++;
            }
        }

        return res;
    }
}