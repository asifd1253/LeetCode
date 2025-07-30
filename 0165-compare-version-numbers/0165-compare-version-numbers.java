class Solution {
    public int compareVersion(String version1, String version2) {
        String ver1Arr[] = version1.split("\\.");
        String ver2Arr[] = version2.split("\\.");

        int n1 = ver1Arr.length;
        int n2 = ver2Arr.length;
        int p1=0,p2=0;
        while(p1 < n1 || p2 < n2){
            int num1 = (p1 < n1)?Integer.parseInt(ver1Arr[p1]) : 0;
            int num2 = (p2 < n2)?Integer.parseInt(ver2Arr[p2]) : 0;

            if(num1 != num2){
                return (num1 > num2)?1 :-1;
            }
            p1++;
            p2++;
        }
        return 0;
    }
}