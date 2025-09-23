class Solution {
    public String getSmallestString(int n, int k) {
        char res[] = new char[n];
        Arrays.fill(res, 'a');
        k = k - n;  // in above we fill the aa...'s in the array

        for(int i=n-1; i>=0 && k>0 ; i--){
            int sum = Math.min(25, k);
            res[i] = (char)(sum+'a');

            k = k-sum;
        }

        return new String(res);
    }
}