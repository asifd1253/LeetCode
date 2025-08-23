
class Solution {
    public String minWindow(String s, String t) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        int ucc = map.size();   // ucc == uniqueCharCount
        int winStart = 0;
        int winEnd = 0;
        int startIdx = -1;
        int minLen = Integer.MAX_VALUE;
        int curLen = 0;
        
        int n = s.length();
        
        while(winEnd < n){
            //Expansion
            char ch = s.charAt(winEnd);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) == 0){
                    ucc--;
                }
            }
            
            //Shrinking
            while(ucc == 0){
                curLen = winEnd - winStart+1;
                if(curLen < minLen){
                    minLen = curLen;
                    startIdx = winStart;
                }
                
                ch = s.charAt(winStart);
                if(map.containsKey(ch)){
                    map.put(ch, map.get(ch)+1); //again we get already t char in map
                    if(map.get(ch) > 0){
                        ucc++;
                    }
                }
                winStart++;
            }
            winEnd++;
        }
        
        if(startIdx == -1){
            return "";
        }
        
        return s.substring(startIdx, startIdx+minLen);
    }
}
