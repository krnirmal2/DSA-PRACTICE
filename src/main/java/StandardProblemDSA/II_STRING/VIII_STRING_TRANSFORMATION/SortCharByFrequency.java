package StandardProblemDSA.II_STRING.VIII_STRING_TRANSFORMATION;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharByFrequency {
  
    /**
     * Problem: Sort Characters By Frequency
     *
     * Given a string s, sort it in decreasing order based on the frequency of the characters.
     * The frequency of a character is the number of times it appears in the string.
     * Return the sorted string. If there are multiple valid answers, return any of them.
     *
     * Examples:
     *   Input:  s = "tree"
     *   Output: "eert"
     *   Explanation: 'e' appears twice while 'r' and 't' both appear once. So 'e' must appear before both 'r' and 't'.
     *
     *   Input:  s = "cccaaa"
     *   Output: "cccaaa" or "aaaccc"
     *   Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
     *
     *   Input:  s = "Aabb"
     *   Output: "bbAa" or "bbaA"
     *   Explanation: 'b' appears twice, 'A' and 'a' once each. 'A' and 'a' are treated as different characters.
     *
     * Constraints:
     *   1 <= s.length <= 5 * 10^5
     *   s consists of uppercase and lowercase English letters and digits.
     */
    public String frequencySort(String s) {
        /*
    Approach:
    - Count the frequency of each character in the string using a HashMap.
    - Use a max-heap (PriorityQueue with custom comparator) to sort characters by their frequency in descending order.
    - Repeatedly poll the heap and append each character to the result as many times as its frequency.

    Time Complexity:
    - Counting frequencies: O(n), where n = length of the string
    - Building the heap: O(k log k), where k = number of unique characters
    - Polling from the heap and building the result: O(n + k log k)
    - Total: O(n + k log k)

    Space Complexity:
    - O(n + k): O(n) for the output string, O(k) for the frequency map and heap
    */
        Map<Character, Integer > charFreq = new HashMap<>();
        for(int ch= 0;ch<s.length();ch++){
           charFreq.put(s.charAt(ch), charFreq.getOrDefault(s.charAt(ch),0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue() -a.getValue());

        for(Map.Entry<Character,Integer> ele : charFreq.entrySet()){
            maxHeap.offer(ele);

        }
        StringBuilder result = new StringBuilder();
        for(Map.Entry<Character, Integer> ele : maxHeap){
            for(int i=0;i<ele.getValue();i++){
            result.append(ele.getKey());

            }
        }
        System.out.println(result.toString());
    return result.toString();

        
    }
    
    public static void main(String[] args) {
        SortCharByFrequency sorter = new SortCharByFrequency();
        String[] testCases = {"raaeaedere", "cccaaa", "Aabb"};
        for (String test : testCases) {
            String sorted = sorter.frequencySort(test);
            System.out.println("Input: " + test + " | Output: " + sorted);
        }
    }
}
