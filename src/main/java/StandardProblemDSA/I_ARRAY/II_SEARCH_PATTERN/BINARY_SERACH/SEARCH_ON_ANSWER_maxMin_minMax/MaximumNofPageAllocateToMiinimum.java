package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.SEARCH_ON_ANSWER_maxMin_minMax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaximumNofPageAllocateToMiinimum {
  /*  Problem Statement:
   Given an array ‘arr of integer numbers, ‘ar[i]’ represents the number of pages in the ‘i-th’ book.
   There are a ‘m’ number of students, and the task is to allocate all the books to the students.
  Allocate books in such a way that:

  Each student gets at least one book.
  Each book should be allocated to only one student.
  Book allocation should be in a contiguous manner.
  You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum. If the allocation of books is not possible. return -1

  Examples

  Example 1:
  Input Format: n = 4, m = 2, arr[] = {12, 34, 67, 90}
  Result: 113
  Explanation: The allocation of books will be 12, 34, 67 | 90. One student will get the first 3 books and the other will get the last one.

          Example 2:
  Input Format: n = 5, m = 4, arr[] = {25, 46, 28, 49, 24}
  Result: 71
  Explanation: The allocation of books will be 25, 46 | 28 | 49 | 24.

  We can allocate books in several ways but it is clearly said in the question that we have to allocate the books in such a way that the maximum number of pages received by a student should be minimum.


  Assume the given array is {25 46 28 49 24} and number of students, M = 4. Now, we can allocate these books in different ways. Some of them are the following:


          25 | 46 | 28 | 49, 24  → Maximum no. of pages a student receive = 73
          25 | 46 | 28, 49 | 24  → Maximum no. of pages a student receive = 77
          25 | 46, 28 | 49 | 24  → Maximum no. of pages a student receive = 74
          25, 46 | 28 | 49 | 24  → Maximum no. of pages a student receive = 71

  From the above allocations, we can clearly observe that the minimum possible maximum number of pages is 71.


  When it is impossible to allocate books:


  When the number of books is lesser than the number of students, we cannot allocate books to all the students even
  if we give only a single book to each student. So, if m > n, we should return -1.*/
  /*Optimal Approach:
    We are going to use the Binary Search algorithm to optimize the approach.

    The primary objective of the Binary Search algorithm is to efficiently determine the appropriate half to eliminate, thereby reducing the search space by half. It does this by determining a specific condition that ensures that the target is not present in that half.

    Upon closer observation, we can recognize that our answer space, represented as [max(arr[]), sum(arr[])], is actually sorted. Additionally, we can identify a pattern that allows us to divide this space into two halves: one consisting of potential answers and the other of non-viable options. So, we will apply binary search on the answer space.

    --
  Approach:
  ---------
  We need to minimize the "maximum pages" assigned.
      - Minimum possible = max(arr) (no student gets fewer pages than the largest book).
      - Maximum possible = sum(arr) (one student gets all books).
  Use **Binary Search on Answer**:
      1. Low = max(arr), High = sum(arr).
      2. Check mid (potential max pages) → count how many students needed if no student exceeds `mid`.
      3. If students > m → mid is too low (increase low).
         Else → mid might work; try smaller (decrease high).
      4. Return low (minimum feasible max).

  Helper `countStudents`:
      - Simulate allocation using current capacity `pages`.
      - If adding book exceeds `pages`, allocate to next student.

  Pattern:
  --------
  - **Binary Search on Answer (Minimize the Maximum)**.
  - Classic for partition problems where the solution space is numeric and monotonic.
  Complexity:
  -----------
  - Time: O(n * log(sum(arr) - max(arr)))
  - Space: O(1)

  Related LeetCode Problems:
  --------------------------
  - 410. Split Array Largest Sum (exactly this problem)
  - 1011. Capacity To Ship Packages Within D Days
  - 875. Koko Eating Bananas
  - 1482. Minimum Number of Days to Make m Bouquets

  Follow-ups:
  ------------
  1. What if books are not contiguous? (Use greedy + binary search without contiguity constraint)
  2. What if each student has a minimum or maximum limit? (Modify countStudents function)
  3. Can we print the actual allocation? (Need to backtrack with the final `low` value).*/
  public static int countStudents(ArrayList<Integer> arr, int pages) {
    int n = arr.size(); // size of array
    int students = 1;
    long pagesStudent = 0;
    for (int i = 0; i < n; i++) {
      if (pagesStudent + arr.get(i) <= pages) {
        // add pages to current student
        pagesStudent += arr.get(i);
      } else {
        // add pages to next student
        students++;
        pagesStudent = arr.get(i);
      }
    }
    return students;
  }

  public static int findPages(ArrayList<Integer> arr, int n, int m) {
    // book allocation impossible
    if (m > n) return -1;

    int low = Collections.max(arr);
    int high = arr.stream().mapToInt(Integer::intValue).sum();
    while (low <= high) {
      int mid = (low + high) / 2;
      int students = countStudents(arr, mid);
      if (students > m) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24));
    int n = 5;
    int m = 4;
    int ans = findPages(arr, n, m);
    System.out.println("The answer is: " + ans);
  }
}
