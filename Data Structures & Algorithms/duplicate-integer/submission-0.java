class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for(int num: nums){
            if(uniqueNumbers.contains(num)){
                return true;
            }
            uniqueNumbers.add(num);
        }

        return false;
    }
}