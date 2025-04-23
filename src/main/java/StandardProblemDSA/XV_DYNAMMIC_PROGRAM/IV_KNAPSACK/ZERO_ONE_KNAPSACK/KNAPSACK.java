package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.IV_KNAPSACK.ZERO_ONE_KNAPSACK;

public class KNAPSACK {
  // so we need to think either take or not take
  // edge case will be
  private int knapSack(int index, int capacity, int[] weight, int[] value) {
    // Edge case
    if (capacity <= 0 || index == 0) // means no item to left
    {
      return 0;
    }
    // induction
    if (weight[index] > capacity) {
      // if element can't be fit in the bag
      // just go to the next element and chechh
      return knapSack(index - 1, capacity, weight, value);
    }
    // include and exclude
    int exclude = knapSack(index - 1, capacity, weight, value);
    int include = knapSack(index - 1, capacity - weight[index], weight, value) + value[index];
    return Math.max(exclude, include);
  }
}
