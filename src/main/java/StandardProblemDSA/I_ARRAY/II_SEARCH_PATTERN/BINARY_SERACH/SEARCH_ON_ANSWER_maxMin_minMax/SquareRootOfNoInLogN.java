package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.SEARCH_ON_ANSWER_maxMin_minMax;

public class SquareRootOfNoInLogN {
  /* Algorithm / Intuition
  Optimal Approach(Using binary search):
  We are going to use the Binary Search algorithm to optimize the approach.
  The primary objective of the Binary Search algorithm is to efficiently determine the appropriate half to eliminate, thereby reducing the search space by half. It does this by determining a specific condition that ensures that the target is not present in that half.
  Now, we are not given any sorted array on which we can apply binary search. But, if we observe closely, we can notice that our answer space i.e. [1, n] is sorted. So, we will apply binary search on the answer space.
          Algorithm:
  The steps are as follows:
  We will declare a variable called ‘ans’.
  Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to 1 and the high will point to n.
  Calculate the ‘mid’: Now, inside a loop, we will calculate the value of ‘mid’ using the following formula:
  mid = (low+high) // 2 ( ‘//’ refers to integer division)
  Eliminate the halves accordingly:
  If mid*mid <= n: On satisfying this condition, we can conclude that the number ‘mid’ is one of the possible answers. So, we will store ‘mid’ in the variable ‘ans’. But we want the maximum number that holds this condition. So, we will eliminate the left half and consider the right half(i.e. low = mid+1).
  Otherwise, the value mid is larger than the number we want. This means the numbers greater than ‘mid’ will not be our answers and the right half of ‘mid’ consists of such numbers. So, we will eliminate the right half and consider the left half(i.e. high = mid-1).
  Finally, the ‘ans’ variable will be storing our answer. In addition to that, the high pointer will also point to the same number i.e. our answer. So, we can return either of the ‘ans’ or ‘high’.
  The steps from 2-3 will be inside a loop and the loop will continue until low crosses high.

  Dry-run: Please refer to the video for the dry-run.

          Note: In this case, the 'high' pointer serves as our answer, eliminating the need for an additional 'ans' variable. Therefore, it is perfectly acceptable to omit the use of an extra variable to store the answer. Consequently, in the following code, no additional variable is utilized for storing the answer*/
  public static int floorSqrt(int n) {
    int low = 1, high = n;
    // Binary search on the answers:
    while (low <= high) {
      long mid = (low + high) / 2;
      long val = mid * mid;
      if (val <= (long) (n)) {
        // eliminate the left half:
        low = (int) (mid + 1);
      } else {
        // eliminate the right half:
        high = (int) (mid - 1);
      }
    }
    return high;
  }

  public static void main(String[] args) {
    int n = 28;
    int ans = floorSqrt(n);
    System.out.println("The floor of square root of " + n + " is: " + ans);
  }
}
