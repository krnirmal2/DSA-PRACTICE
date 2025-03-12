package StandardProblemDSA.STACK.MONOTONIC_PATTERN;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 If there is no future day for which this is possible, keep answer[i] == 0 instead


Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]


Constraints:

1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100
*/
public class DailyTemperature {

    public static void main(String[] args) {
        ArrayList<Integer> dailyTemp = new ArrayList<>(List.of(73, 74, 75, 71, 69, 72, 76, 73));
        // can  be solved in brute force by two loop and arraylist
        ArrayList<Integer> waitingList = nextWarmDay(dailyTemp);
        waitingList.stream().forEach(System.out::println);
        /*
        Example Run
Input:
dailyTemp = [73, 74, 75, 71, 69, 72, 76, 73]

Execution Flow:
Initialize waitingList = [0, 0, 0, 0, 0, 0, 0, 0].

Process indices with the stack:
Index 0 (73): Push to stack.
Index 1 (74): Warmer than 73, set waitingList[0] = 1, then push 1.
Index 2 (75): Warmer than 74, set waitingList[1] = 1, then push 2.
Continue processing similarly for all indices.

Output:
[1, 1, 4, 2, 1, 1, 0, 0]*/
    }

    private static ArrayList<Integer> nextWarmDay(ArrayList<Integer> dailyTemp) {
        ArrayList<Integer> waitingList = new ArrayList<>();
        Stack<Integer> indexStack = new Stack<>();
// Initialize waitingList:
//The list waitingList must be initialized with 0 for all indices since the problem specifies 0 as the default value when no warmer temperature is found.
//Added a loop to populate waitingList with default values.
        for (int i = 0; i < dailyTemp.size(); i++) {
            waitingList.add(0);
        }

        // loop through each element and then check
        for (int arrayIndex = 0; arrayIndex < dailyTemp.size(); arrayIndex++) {
            while (!indexStack.isEmpty() && dailyTemp.get(arrayIndex) > dailyTemp.get(indexStack.peek())) {
                int stackIndex = indexStack.pop();
                waitingList.set(stackIndex, arrayIndex - stackIndex);
            }
            indexStack.push(arrayIndex);

        }

        //
        return waitingList;

    }

}
