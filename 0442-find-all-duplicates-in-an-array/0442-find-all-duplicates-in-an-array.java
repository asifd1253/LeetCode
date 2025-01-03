class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        List<Integer> duplicates = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();

        for(int i : arr){
            if(set.contains(i)){
                duplicates.add(i);
            }else{
                set.add(i);
            }
        }
        return duplicates;
    }
}