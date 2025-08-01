class Solution {
    public int scoreOfString(String s) {
        char arr[] = s.toCharArray();

        int result = 0;

        for(int i=0; i<arr.length-1; i++){
            char char1 = arr[i];
            char char2 = arr[i+1];
            result += Math.abs(char1 - char2);
        }

        return result;
    }
}