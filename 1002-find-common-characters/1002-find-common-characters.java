class Solution {
    public List<String> commonChars(String[] words) {
        int csf[] = new int[26];

        String firstWord = words[0];
        for(char ch : firstWord.toCharArray()){
            int idx = ch - 'a';
            csf[idx]++;
        }

        for(int i=1; i<words.length; i++){
            String curWord = words[i];
            int curArr[] = new int[26];

            for(char ch : curWord.toCharArray()){
                int idx = ch - 'a';
                curArr[idx]++;
            }

            for(int j=0; j<26; j++){
                csf[j] = Math.min(csf[j], curArr[j]);
            }
        }

        List<String> res = new ArrayList<>();
        for(int i=0; i<26; i++){
        
            if(csf[i] != 0){
                char c = (char)(i + 'a');
                int count = csf[i];

                while(count-- > 0){
                    res.add("" + c);
                }
            }
        }

        return res;
    }
}