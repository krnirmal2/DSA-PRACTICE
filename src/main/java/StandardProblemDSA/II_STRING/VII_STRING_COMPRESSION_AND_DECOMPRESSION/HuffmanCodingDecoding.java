package StandardProblemDSA.II_STRING.VII_STRING_COMPRESSION_AND_DECOMPRESSION;

import java.util.*;

// Huffman Node class
class HuffmanNode implements Comparable<HuffmanNode> {
  char character;
  int frequency;
  HuffmanNode left, right;

  public HuffmanNode(char character, int frequency) {
    this.character = character;
    this.frequency = frequency;
    this.left = null;
    this.right = null;
  }

  public HuffmanNode(char character, int frequency, HuffmanNode left, HuffmanNode right) {
    this.character = character;
    this.frequency = frequency;
    this.left = left;
    this.right = right;
  }

  // Check if node is a leaf
  public boolean isLeaf() {
    return left == null && right == null;
  }

  // For PriorityQueue ordering (min-heap)
  @Override
  public int compareTo(HuffmanNode other) {
    return this.frequency - other.frequency;
  }
}
