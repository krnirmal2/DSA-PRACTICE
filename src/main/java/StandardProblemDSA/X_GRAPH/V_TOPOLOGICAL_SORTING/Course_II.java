package StandardProblemDSA.X_GRAPH.V_TOPOLOGICAL_SORTING;

/*Problem Statement II (Pre-requisite Tasks): There are a total of N tasks, labeled from 0 to N-1. Some tasks may have prerequisites, for example, to do task 0 you have to first complete task 1, which is expressed as a pair: [0, 1]

Given the total number of tasks N and a list of prerequisite pairs P, find if it is possible to finish all tasks.

Note: These two questions are linked. The second question asks if it is possible to finish all the tasks and the first question states to return the ordering of the tasks if it is possible to perform all the tasks, otherwise return an empty array.

Examples:

Example 1:
Input: N = 4, P = 3,  array[] = {{1,0},{2,1},{3,2}}
Output: Yes
Explanation: It is possible to finish all the tasks in the order : 3 2 1 0.
First, we will finish task 3. Then we will finish task 2, task 1, and task 0.

Example 2:
Input: N = 4, P = 4,  array[] = {{1,2},{4,3},{2,4},{4,1}}
Output: No
Explanation: It is impossible to finish all the tasks. Let’s analyze the pairs:
For pair {1, 2} -> we need to finish task 1 first and then task 2. (order : 1 2).
For pair{4, 3} -> we need to finish task 4 first and then task 3. (order: 4 3).
For pair {2, 4} -> we need to finish task 2 first and then task 4. (order: 1 2 4 3).
But for pair {4, 1} -> we need to finish task 4 first and then task 1 but this pair contradicts the previous pair. So, it is not possible to finish all the tasks.*/
public class Course_II {}
