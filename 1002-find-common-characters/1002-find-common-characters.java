class Solution {
    public List<String> commonChars(String[] words) {
        ArrayList<String> res = new ArrayList<>();

        //common so far
        int csf[] = new int[26];

        for(char ch : words[0].toCharArray()){
            csf[ch-'a']++;
        }

        for(int i=1; i<words.length; i++){
            //current in String
            int cis[] = new int[26];
            for(char ch : words[i].toCharArray()){
                cis[ch-'a']++;
            }

            for(int j=0; j<26; j++){
                csf[j] = Math.min(csf[j], cis[j]);
            }
        }

        for(int i=0; i<26; i++){
            while(csf[i] > 0){
                res.add(Character.toString((char)i+'a'));
                csf[i]--;
            }
        }
        return res;
    }
}