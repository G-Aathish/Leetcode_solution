class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int n = nums.length;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for (int num : nums) {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }

        // If all elements are identical, the maximum gap is 0
        if (minVal == maxVal) {
            return 0;
        }

        // Calculate the minimum possible max gap size
        int bucketSize = (int) Math.ceil((double) (maxVal - minVal) / (n - 1));

        // Create arrays to store the min and max values of each bucket
        int[] bucketMin = new int[n];
        int[] bucketMax = new int[n];
        
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // Map each number to its corresponding bucket
        for (int num : nums) {
            int bucketIdx = (num - minVal) / bucketSize;
            bucketMin[bucketIdx] = Math.min(bucketMin[bucketIdx], num);
            bucketMax[bucketIdx] = Math.max(bucketMax[bucketIdx], num);
        }

        // Calculate the maximum gap across non-empty adjacent buckets
        int maxGap = 0;
        int previousMax = minVal;

        for (int i = 0; i < n; i++) {
            // Skip empty buckets
            if (bucketMin[i] == Integer.MAX_VALUE) {
                continue;
            }
            
            maxGap = Math.max(maxGap, bucketMin[i] - previousMax);
            previousMax = bucketMax[i];
        }

        return maxGap;
    }
}
