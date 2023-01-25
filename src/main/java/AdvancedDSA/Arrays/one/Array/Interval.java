package AdvancedDSA.Arrays.one.Array;


import java.util.ArrayList;

public class Interval {
      int start;
     int end;
      Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
  }
/*     this problem has a lot of corner cases that need to be handled correctly.

        Let us first talk about the approach.
        Given all the intervals, you need to figure out the sequence of intervals that intersect with the given new interval.

        Lets see how we check if interval 1 (a,b) intersects with interval 2 (c,d):

        Overlap case :

        a---------------------b                      OR       a------b
        c-------------------d                c------------------d
        Non-overlap case:

        a--------------------b   c------------------d
        Note that if max(a,c) > min(b,d), then the intervals do not overlap. Otherwise, they overlap.

        Once we figure out the intervals ( interval[i] to the interval[j] ) which overlap with the new interval, note that we can replace all the overlapping intervals with one interval, which would be

        (min(interval[i].start, newInterval.start), max(interval[j].end, newInterval.end)).

        Do make sure you cover the other corner cases.


Have you covered the following corner cases :

1) Size of interval array as 0.

2) newInterval being an interval preceding all intervals in the array.

    Given interval (3,6),(8,10), insert and merge (1,2)
3) newInterval being an interval succeeding all intervals in the array.

    Given interval (1,2), (3,6), insert and merge (8,10)
4) newInterval not overlapping with any interval and falling in between 2 intervals in the array.

    Given interval (1,2), (8,10) insert and merge (3,6)
5) newInterval covering all given intervals.

    Given interval (3, 5), (7, 9) insert and merge (1, 10)



        */