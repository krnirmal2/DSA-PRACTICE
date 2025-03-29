package StandardProblemDSA.II_STRING.VII_STRING_COMPRESSION_AND_DECOMPRESSION;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/*Huffman coding is a lossless data compression algorithm that uses variable-length codes to represent characters, where more frequent characters have shorter codes and less frequent ones have longer codes. It is based on a greedy algorithm approach and constructs an optimal prefix code (no code is a prefix of another).

Steps to Implement Huffman Coding
Frequency Calculation:

Determine the frequency of each character in the input data.

Build a Priority Queue (Min-Heap):

Create a min-heap where each node represents a character and its frequency.

The node with the lowest frequency has the highest priority.

Construct the Huffman Tree:

While there is more than one node in the heap:

Extract the two nodes with the smallest frequencies.

Create a new internal node with a frequency equal to the sum of the two nodes.

Make the first extracted node the left child and the second the right child.

Insert the new node back into the heap.

The remaining node becomes the root of the Huffman tree.

Assign Codes:

Traverse the tree from root to leaves, assigning:

        0 for left edges.

        1 for right edges.

The path from root to leaf determines the Huffman code for that character.

Generate Encoded Output:

Replace each character in the input with its corresponding Huffman code.

        Example
Input: "ABRACADABRA"
Step 1: Frequency Table

Char	Frequency
A	5
B	2
R	2
C	1
D	1
Step 2: Build Huffman Tree

Combine C (1) and D (1) → New node (2)

Combine B (2) and R (2) → New node (4)

Combine (C+D=2) and (B+R=4) → New node (6)

Combine A (5) and (6) → Root (11)

Step 3: Assign Codes

Char	Code
A	0
B	100
R	101
C	1100
D	1101
Step 4: Encode "ABRACADABRA"
        → 0 100 101 0 1100 0 1101 0 100 101 0
        → Compressed output: 0100101011000110101001010

Key Properties
✅ Prefix-Free: No code is a prefix of another (ensures unambiguous decoding).
        ✅ Optimal: Produces the smallest possible average code length for given frequencies.
        ✅ Time Complexity:

Building heap: O(n)

Extracting min & inserting: O(n log n)*/
public class HuffmanCoding {
  // Step 1: Calculate character frequencies
  private static Map<Character, Integer> getFrequencyMap(String data) {
    return data.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.toMap(c -> c, c -> 1, Integer::sum));
  }

  // Step 2: Build Huffman Tree
  private static HuffmanNode buildHuffmanTree(Map<Character, Integer> freqMap) {
    PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<>();

    // Add all characters to the min-heap
    freqMap.forEach((character, frequency) -> minHeap.add(new HuffmanNode(character, frequency)));

    // Build the tree
    while (minHeap.size() > 1) {
      HuffmanNode left = minHeap.poll();
      HuffmanNode right = minHeap.poll();
      HuffmanNode merged = new HuffmanNode('\0', left.frequency + right.frequency, left, right);
      minHeap.add(merged);
    }

    return minHeap.poll(); // Root of the Huffman tree
  }

  // Step 3: Generate Huffman Codes (DFS traversal)
  private static void generateCodes(
      HuffmanNode root, String code, Map<Character, String> huffmanCodes) {
    if (root == null) return;

    if (root.isLeaf()) {
      huffmanCodes.put(root.character, code);
    }

    generateCodes(root.left, code + "0", huffmanCodes);
    generateCodes(root.right, code + "1", huffmanCodes);
  }

  // Step 4: Encode the input string
  public static String encode(String data) {
    if (data.isEmpty()) return "";

    Map<Character, Integer> freqMap = getFrequencyMap(data);
    HuffmanNode root = buildHuffmanTree(freqMap);
    Map<Character, String> huffmanCodes = new HashMap<>();
    generateCodes(root, "", huffmanCodes);

    // Encode each character
    StringBuilder encoded = new StringBuilder();
    for (char c : data.toCharArray()) {
      encoded.append(huffmanCodes.get(c));
    }

    return encoded.toString();
  }

  // Step 5: Decode the encoded string
  public static String decode(String encoded, HuffmanNode root) {
    if (encoded.isEmpty()) return "";

    StringBuilder decoded = new StringBuilder();
    HuffmanNode current = root;

    for (char bit : encoded.toCharArray()) {
      current = (bit == '0') ? current.left : current.right;

      if (current.isLeaf()) {
        decoded.append(current.character);
        current = root; // Reset to root for next character
      }
    }

    return decoded.toString();
  }

  // Main method (Example Usage)
  public static void main(String[] args) {
    String data = "ABRACADABRA";
    System.out.println("Original: " + data);

    // Encode
    String encoded = encode(data);
    System.out.println("Encoded: " + encoded);

    // Decode (requires the Huffman tree, so we rebuild it here)
    Map<Character, Integer> freqMap = getFrequencyMap(data);
    HuffmanNode root = buildHuffmanTree(freqMap);
    String decoded = decode(encoded, root);
    System.out.println("Decoded: " + decoded);
  }
}
