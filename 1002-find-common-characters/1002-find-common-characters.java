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
            int curFreq[] = new int[26];
            for(char ch : curWord.toCharArray()){
                int idx = ch - 'a';
                curFreq[idx]++;
            }

            //update the common so far with min of chars in 2 strings
            for(int j=0; j<26; j++){
                csf[j] = Math.min(csf[j], curFreq[j]);
            }
        }

        List<String> res = new ArrayList<>();
        for(int i=0; i<26; i++){
            int count = csf[i];
            char ch = (char)(i + 'a');
            while(count-- > 0){
                res.add("" + ch);
            }
        }

        return res;
    }
}
