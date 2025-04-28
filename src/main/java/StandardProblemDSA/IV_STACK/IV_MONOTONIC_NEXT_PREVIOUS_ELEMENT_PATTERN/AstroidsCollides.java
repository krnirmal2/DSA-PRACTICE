package StandardProblemDSA.IV_STACK.IV_MONOTONIC_NEXT_PREVIOUS_ELEMENT_PATTERN;

import java.util.Stack;

public class AstroidsCollides {
  /*735. Asteroid Collision
  Attempted
  Medium
  Topics
  Companies
  Hint
  We are given an array asteroids of integers representing asteroids in a row. The indices of the asteriod in the array represent their relative position in space.

  For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

  Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.



  Example 1:

  Input: asteroids = [5,10,-5]
  Output: [5,10]
  Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
  Example 2:

  Input: asteroids = [8,-8]
  Output: []
  Explanation: The 8 and -8 collide exploding each other.
  Example 3:*/
  /*🔥 Main Idea:
  Push asteroid onto the stack if:

  No collision will happen.

  (Either both move same direction, or asteroid moves right.)

  Handle collision if:

  Stack top is moving right (positive) and

  Current asteroid is moving left (negative).

  In this case, compare sizes:

  If current asteroid (left mover) is bigger → top asteroid explodes (pop the stack) and keep checking.

  If stack top (right mover) is bigger → current asteroid explodes (do NOT push it).

  If same size → both explode (pop top and do NOT push current).

  Only push current asteroid if it survives (not exploded).

  Finally, return the stack as the result (asteroids that are still alive).*/

  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> st = new Stack<>();

    for (int a : asteroids) {
      boolean alive = true;
      // check if the stack top is posistive and array element is negative
      // then if check if st.peek is smaller than - negative of the current element then pop
      // elese  if they equal collide and not push to the stack
      // else smaller asteroid destroid and not put them to stck
      while (!st.isEmpty() && st.peek() > 0 && a < 0) {
        if (st.peek() < -a) {
          st.pop(); // Top explodes, continue checking
        } else if (st.peek() == -a) {
          st.pop(); // Both explode
          alive = false;
          break;
        } else {
          alive = false; // Current asteroid explodes
          break;
        }
      }

      if (alive) {
        st.push(a);
      }
    }

    int[] result = new int[st.size()];
    for (int i = st.size() - 1; i >= 0; i--) {
      result[i] = st.pop();
    }

    return result;
  }
}
