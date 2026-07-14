class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        // Loop through all elements in the array
        for (int num : nums) {
            result ^= num; // Apply bitwise XOR operation
        }
        
        return result;
    }
}
