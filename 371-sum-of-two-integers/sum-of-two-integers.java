class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            // Find carry bits
            int carry = a & b;
            
            // Sum of bits where at least one is 0 (sum without carry)
            a = a ^ b;
            
            // Shift carry to the left to add it in the next iteration
            b = carry << 1;
        }
        return a;
    }
}
