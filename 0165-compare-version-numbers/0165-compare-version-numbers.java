class Solution {
    public int compareVersion(String version1, String version2) {
        String var1Chars[] = version1.split("\\.");
        String var2Chars[] = version2.split("\\.");

        int p1 = 0;
        int n1 = var1Chars.length;
        int p2 = 0;
        int n2 = var2Chars.length;

        while(p1 < n1 || p2 < n2){
            int num1 = (p1 < n1)?Integer.parseInt(var1Chars[p1]):0;
            int num2 = (p2 < n2)?Integer.parseInt(var2Chars[p2]):0;

            if(num1 != num2){
                return (num1 > num2)?1:-1;
            }

            p1++;
            p2++;
        }

        return 0;
    }
}