import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String frequencySort(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        // Step 1: Count frequency of each character
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        // Step 2: Create buckets where index = frequency
        // Maximum frequency possible is s.length()
        List<Character>[] buckets = new List[s.length() + 1];
        for (char c : counts.keySet()) {
            int frequency = counts.get(c);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(c);
        }

        // Step 3: Build the result string from highest frequency to lowest
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    // Append character 'c', 'i' times
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }
}
