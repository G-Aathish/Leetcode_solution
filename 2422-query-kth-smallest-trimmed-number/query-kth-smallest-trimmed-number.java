import java.util.Arrays;

class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int[] answer = new int[m];
        
        // Process each query independently
        for (int i = 0; i < m; i++) {
            int k = queries[i][0];
            int trim = queries[i][1];
            
            // Create a custom pair structure: [trimmed_string, original_index]
            String[][] trimmedPairs = new String[n][2];
            
            for (int j = 0; j < n; j++) {
                int len = nums[j].length();
                // Get the rightmost 'trim' digits
                trimmedPairs[j][0] = nums[j].substring(len - trim);
                trimmedPairs[j][1] = String.valueOf(j);
            }
            
            // Sort based on the problem conditions
            Arrays.sort(trimmedPairs, (a, b) -> {
                // Compare the trimmed string values lexicographically
                int cmp = a[0].compareTo(b[0]);
                if (cmp != 0) {
                    return cmp;
                }
                // If values are equal, sort by original index numerically
                return Integer.compare(Integer.parseInt(a[1]), Integer.parseInt(b[1]));
            });
            
            // The kth smallest corresponds to index k - 1 after sorting
            answer[i] = Integer.parseInt(trimmedPairs[k - 1][1]);
        }
        
        return answer;
    }
}
