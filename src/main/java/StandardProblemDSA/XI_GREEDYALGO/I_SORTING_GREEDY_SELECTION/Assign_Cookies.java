package StandardProblemDSA.XI_GREEDYALGO.I_SORTING_GREEDY_SELECTION;

import java.util.Arrays;

public class Assign_Cookies {
  /*Problem Statement: Given two arrays representing children’s green factor and cookie sizes, the goal is to maximise the number of content children.
  Each child i has a greed factor of g[i], which is the minimum size of a cookie that will make the child content.
  Each cookie j has a size of s[j]. If s[j] >= g[i], we can assign cookie j to child i, making the child content. Each child can only receive one cookie.
  Examples
                  Example 1:
                  Input:g = [1, 2, 3], s = [1, 1]
                  Output: 1
                  Explanation:  We have 3 children and 2 cookies. The greed factors of the 3 children are 1, 2, 3.
                  The sizes of the 2 cookies are both 1. We can only make the child with greed factor 1 content. Hence, the output is 1.
                  Example 2:
                  Input:g = [1, 5, 3, 3, 4], s = [4, 2, 1, 2, 1, 3]
                  Output: 0
                  Explanation: You have 5 children and 6 cookies. The greed factors of the 5 children are 1, 5, 3, 3, and 4.
                  The sizes of the 6 cookies are 4, 2, 1, 2, 1, and 3.

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
}
