class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        // Total numbers in an n-bit sequence is 2^n
        int size = 1 << n; 
        
        for (int i = 0; i < size; i++) {
            // Apply the Gray code formula: i XOR (i divided by 2)
            result.add(i ^ (i >> 1));
        }
        
        return result;
    }
}
