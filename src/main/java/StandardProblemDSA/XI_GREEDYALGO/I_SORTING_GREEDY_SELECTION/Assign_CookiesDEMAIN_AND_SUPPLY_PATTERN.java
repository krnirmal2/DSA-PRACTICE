package StandardProblemDSA.XI_GREEDYALGO.I_SORTING_GREEDY_SELECTION;

import java.util.Arrays;

/*
* Pattern Summary:
* - Two sorted arrays: one represents DEMAND (e.g., greed, tasks, people),
*   the other SUPPLY (e.g., resources, cookies, boats, rooms).
* - Goal: Maximize the number of matches (or minimize cost/waste).
* - step:
*      1. Sort both arrays.
*      2. Use two pointers to greedily match the smallest supply with
*         the smallest demand.
*      3. Move pointers forward when a match is made.

*/
/*
* =========================================================
* Common Questions Using This Pattern:
* =========================================================
* 1. Assign Cookies (LeetCode 455) done
* 2. Boats to Save People (LeetCode 881) done
* 3. Minimum Number of Arrows to Burst Balloons (LeetCode 452) done
* 4. Meeting Rooms Allocation
* 5. Campus Bikes (LeetCode 1057)
* 6. Activity Selection Problem done
* 7. Job Scheduling with Deadlines and Profits done
* 8. Gas Station Fueling Optimization

*
* Pattern Recognition:
* - Two arrays, one demand and one supply.
* - Need to maximize satisfaction or minimize resource usage.
* - Sort + two pointers is the standard greedy approach.
*/
public class Assign_CookiesDEMAIN_AND_SUPPLY_PATTERN {
  /*
  Problem Statement: Given two arrays representing children’s green factor and cookie sizes, the goal is to maximise the number of content children.
  Each child i has a greed factor of g[i], which is the minimum size of a cookie that will make the child content.
  Each cookie j has a size of cookies[j]. If cookies[j] >= greed[i], we can assign cookie j to child i, making the child content. Each child can only receive one cookie.
  Examples
                  Example 1:
                  Input:greed = [1, 2, 3], cookies = [1, 1]
                  Output: 1
                  Explanation:  We have 3 children and 2 cookies. The greed factors of the 3 children are 1, 2, 3.
                  The sizes of the 2 cookies are both 1. We can only make the child with greed factor 1 content.
                  Hence, the output is 1.

                  Example 2:
                  Input:g = [1, 5, 3, 3, 4], s = [4, 2, 1, 2, 1, 3]
                  Output: 3
                  Explanation: You have 5 children and 6 cookies. The greed factors of the 5 children are 1, 5, 3, 3, and 4.
                  The sizes of the 6 cookies are 4, 2, 1, 2, 1, and 3.
                        Child with greed 1 → gets cookie 1 ✅
                        Child with greed 3 → next cookie 1 ❌ (too small), 2 ❌, 2 ❌, 3 ✅ → gets 3
                        Child with greed 3 → next cookie 4 ✅
                        Child with greed 4 → no cookies left (we used up all 6 cookies) ❌
                        Child with greed 5 → no cookies left ❌


  The child with greed factor 1 can be satisfied with the cookie of size 1.
  One child with greed factor 3 can be satisfied with the cookie of size 3.
  One child with greed factor 4 can be satisfied with the cookie of size 4.*/
  public static int findContentChildren(int[] greed, int[] cookieSize) {
    int contentChildren = 0;
    if (cookieSize.length == 0) return contentChildren;

    Arrays.sort(greed);
    Arrays.sort(cookieSize);

    int child = 0, cookie = 0;
    while (child < greed.length && cookie < cookieSize.length) {
      if (cookieSize[cookie] >= greed[child]) {
        contentChildren++;
        child++;
        cookie++;
      } else {
        cookie++; // try next bigger cookie
      }
    }

    return contentChildren;
  }

  public static void main(String[] args) {
    int[] greed = {1, 5, 3, 3, 4};
    int[] cookiesSize = {4, 2, 1, 2, 1, 3};
    System.out.println(findContentChildren(greed, cookiesSize));
  }
}
