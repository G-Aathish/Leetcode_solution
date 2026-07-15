import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        // Base edge case check
        if (nums == null || nums.length < 2 || indexDiff <= 0 || valueDiff < 0) {
            return false;
        }

        // Map to store bucket ID -> element value
        Map<Long, Long> buckets = new HashMap<>();
        // Width of each bucket
        long width = (long) valueDiff + 1;

        for (int i = 0; i < nums.length; i++) {
            long val = (long) nums[i];
            long bucketId = getBucketId(val, width);

            // Condition 1: Same bucket contains an element -> Difference is <= valueDiff
            if (buckets.containsKey(bucketId)) {
                return true;
            }

            // Condition 2: Check the left adjacent bucket
            if (buckets.containsKey(bucketId - 1) && Math.abs(val - buckets.get(bucketId - 1)) <= valueDiff) {
                return true;
            }

            // Condition 3: Check the right adjacent bucket
            if (buckets.containsKey(bucketId + 1) && Math.abs(val - buckets.get(bucketId + 1)) <= valueDiff) {
                return true;
            }

            // Add current element to its bucket
            buckets.put(bucketId, val);

            // Maintain sliding window size of indexDiff
            if (i >= indexDiff) {
                long oldestBucketId = getBucketId((long) nums[i - indexDiff], width);
                buckets.remove(oldestBucketId);
            }
        }

        return false;
    }

    // Helper method to safely compute bucket ID for both positive and negative numbers
    private long getBucketId(long val, long width) {
        if (val >= 0) {
            return val / width;
        } else {
            return (val + 1) / width - 1;
        }
    }
}
