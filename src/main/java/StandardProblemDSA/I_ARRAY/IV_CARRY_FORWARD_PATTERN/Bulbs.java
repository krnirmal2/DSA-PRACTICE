package StandardProblemDSA.I_ARRAY.IV_CARRY_FORWARD_PATTERN;

/*
Question:
You are given an array A where A[i] represents the state of the i-th bulb:
- 0 = OFF
- 1 = ON
You have a switch that toggles the state of the current bulb and all the bulbs to its right.
Find the minimum number of switches you need to press to turn all bulbs ON.

Example:
Input: A = [0, 1, 0, 1]
Output: 4

Approach (Correct Logic):
1. Maintain a variable `state` to track how many times the bulbs have been toggled.
2. Iterate through the bulbs:
   - If `A[i]` is OFF considering the current toggle state, press the switch (`count++`),
     which toggles all bulbs to the right (flip `state`).
3. Return `count`.

**Note:**
The given implementation in the code is incorrect because it directly modifies `A[i + 1]`
and does not properly toggle the states of all subsequent bulbs.

*/

public class Bulbs {
  public int bulbs(int[] A) {
    int count = 0;
    int toggle = 0; // track the number of toggles (0 = no toggle, 1 = toggled)
    for (int bulb : A) {
      if ((bulb ^ toggle) == 0) { // bulb is OFF in the current state
        count++;
        toggle ^= 1; // flip toggle state
      }
    }
    return count;
  }
}
