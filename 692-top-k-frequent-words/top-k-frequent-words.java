import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Count frequency of each word
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }
        
        // Step 2: Build a Min-Heap with custom comparator
        PriorityQueue<String> minHeap = new PriorityQueue<>(
            (w1, w2) -> {
                int freq1 = countMap.get(w1);
                int freq2 = countMap.get(w2);
                if (freq1 != freq2) {
                    return Integer.compare(freq1, freq2); // Min-heap by frequency
                }
                return w2.compareTo(w1); // Reverse alphabetical order for tie-breaking
            }
        );
        
        // Step 3: Keep the heap size bounded to k
        for (String word : countMap.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent / alphabetically later word
            }
        }
        
        // Step 4: Populate the result list in correct order
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        Collections.reverse(result); // Reverse because min-heap gave smallest elements first
        
        return result;
    }
}
