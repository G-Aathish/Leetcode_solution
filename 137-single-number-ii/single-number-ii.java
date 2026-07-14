class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        
        for (int num : nums) {
            // Update 'twos' if the bit is already in 'ones'
            twos |= (ones & num);
            
            // Update 'ones' using XOR
            ones ^= num;
            
            // Common bits in 'ones' and 'twos' have appeared 3 times
            int threes = ones & twos;
            
            // Clear the bits that appeared 3 times from 'ones' and 'twos'
            ones &= ~threes;
            twos &= ~threes;
        }
        
        return ones;
    }
}
