# Define the markdown structure of the article provided by the user

markdown_content = """

# Interview Preparation Notes

Before starting the topic let me introduce myself. I am a Mobile Developer currently working in Warsaw and spending my
free time for interview preparations. I started to prepare for interviews two years ago. At that time I should say I
could not solve the two sum problem. Easy problems seemed to me like hard ones so most of the time I had to look at
editorials and discuss section. Currently, I have solved ~800 problems and time to time participate in contests. I
usually solve 3 problems in a contest and sometimes 4 problems. Ok, lets come back to the topic.

Recently I have concentrated my attention on Dynamic Programming cause its one of the hardest topics in an interview
prep. After solving ~140 problems in DP I have noticed that there are few patterns that can be found in different
problems. So I did a research on that and find the following topics. I will not give complete ways how to solve problems
but these patterns may be helpful in solving DP.

## Patterns

- Minimum (Maximum) Path to Reach a Target
- Distinct Ways
- Merging Intervals
- DP on Strings
- Decision Making

### Minimum (Maximum) Path to Reach a Target

**Problem list:** https://leetcode.com/list/55ac4kuc

#### Generate problem statement for this pattern

**Statement**: Given a target find minimum (maximum) cost / path / sum to reach the target.

**Approach**: Choose minimum (maximum) path among all possible paths before the current state, then add value for the
current state.

```java
routes[i] = min(routes[i-1], routes[i-2], ... , routes[i-k]) + cost[i]
Generate optimal solutions for all values in the target and return the value for the target.

Top-Down
java
Always show details

Copy code
for (int j = 0; j < ways.size(); ++j) {
    result = min(result, topDown(target - ways[j]) + cost/ path / sum);
}
return memo[/*state parameters*/] = result;
Bottom-Up
java
Always show details

Copy code
for (int i = 1; i <= target; ++i) {
   for (int j = 0; j < ways.size(); ++j) {
       if (ways[j] <= i) {
           dp[i] = min(dp[i], dp[i - ways[j]] + cost / path / sum);
       }
   }
}
return dp[target]
Similar Problems
746. Min Cost Climbing Stairs Easy
Top-Down

java
Always show details

Copy code
int result = min(minCost(n-1, cost, memo), minCost(n-2, cost, memo)) + (n == cost.size() ? 0 : cost[n]);
return memo[n] = result;
Bottom-Up

java
Always show details

Copy code
for (int i = 2; i <= n; ++i) {
   dp[i] = min(dp[i-1], dp[i-2]) + (i == n ? 0 : cost[i]);
}
return dp[n]
64. Minimum Path Sum Medium
Top-Down

java
Always show details

Copy code
int result = min(pathSum(i+1, j, grid, memo), pathSum(i, j+1, grid, memo)) + grid[i][j];
return memo[i][j] = result;
Bottom-Up

java
Always show details

Copy code
for (int i = 1; i < n; ++i) {
   for (int j = 1; j < m; ++j) {
       grid[i][j] = min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
   }
}
return grid[n-1][m-1]
322. Coin Change Medium
Top-Down

java
Always show details

Copy code
for (int i = 0; i < coins.size(); ++i) {
    if (coins[i] <= target) { // check validity of a sub-problem
        result = min(ans, CoinChange(target - coins[i], coins) + 1);
    }
}
return memo[target] = result;
Bottom-Up

java
Always show details

Copy code
for (int j = 1; j <= amount; ++j) {
   for (int i = 0; i < coins.size(); ++i) {
       if (coins[i] <= j) {
           dp[j] = min(dp[j], dp[j - coins[i]] + 1);
       }
   }
}
931. Minimum Falling Path Sum Medium

983. Minimum Cost For Tickets Medium

650. 2 Keys Keyboard Medium

279. Perfect Squares Medium

1049. Last Stone Weight II Medium

120. Triangle Medium

474. Ones and Zeroes Medium

221. Maximal Square Medium

322. Coin Change Medium

1240. Tiling a Rectangle with the Fewest Squares Hard

174. Dungeon Game Hard

871. Minimum Number of Refueling Stops Hard

Distinct Ways
Problem List: https://leetcode.com/list/55ajm50i

Generate problem statement for this pattern
Statement: Given a target find a number of distinct ways to reach the target.

Approach: Sum all possible ways to reach the current state.

java
Always show details

Copy code
routes[i] = routes[i-1] + routes[i-2], ... , + routes[i-k]
Generate sum for all values in the target and return the value for the target.

Top-Down
java
Always show details

Copy code
for (int j = 0; j < ways.size(); ++j) {
    result += topDown(target - ways[j]);
}
return memo[/*state parameters*/] = result;
Bottom-Up
java
Always show details

Copy code
for (int i = 1; i <= target; ++i) {
   for (int j = 0; j < ways.size(); ++j) {
       if (ways[j] <= i) {
           dp[i] += dp[i - ways[j]];
       }
   }
}
return dp[target]
Similar Problems
70. Climbing Stairs Easy
Top-Down

java
Always show details

Copy code
int result = climbStairs(n-1, memo) + climbStairs(n-2, memo); 
return memo[n] = result;
Bottom-Up

java
Always show details

Copy code
for (int stair = 2; stair <= n; ++stair) {
   for (int step = 1; step <= 2; ++step) {
       dp[stair] += dp[stair-step];   
   }
}
62. Unique Paths Medium
Top-Down

java
Always show details

Copy code
int result = UniquePaths(x-1, y) + UniquePaths(x, y-1);
return memo[x][y] = result;
Bottom-Up

java
Always show details

Copy code
for (int i = 1; i < m; ++i) {
   for (int j = 1; j < n; ++j) {
       dp[i][j] = dp[i][j-1] + dp[i-1][j];
   }
}
1155. Number of Dice Rolls With Target Sum Medium
java
Always show details

Copy code
for (int rep = 1; rep <= d; ++rep) {
   vector<int> new_ways(target+1);
   for (int already = 0; already <= target; ++already) {
       for (int pipe = 1; pipe <= f; ++pipe) {
           if (already - pipe >= 0) {
               new_ways[already] += ways[already - pipe];
               new_ways[already] %= mod;
           }
       }
   }
   ways = new_ways;
}
688. Knight Probability in Chessboard Medium

494. Target Sum Medium

377. Combination Sum IV Medium

935. Knight Dialer Medium

1223. Dice Roll Simulation Medium

416. Partition Equal Subset Sum Medium

808. Soup Servings Medium

790. Domino and Tromino Tiling Medium

801. Minimum Swaps To Make Sequences Increasing

673. Number of Longest Increasing Subsequence Medium

63. Unique Paths II Medium

576. Out of Boundary Paths Medium

1269. Number of Ways to Stay in the Same Place After Some Steps Hard

1220. Count Vowels Permutation Hard

Merging Intervals
Problem List: https://leetcode.com/list/55aj8s16

Generate problem statement for this pattern
Statement: Given a set of numbers find an optimal solution for a problem considering the current number and the best you can get from the left and right sides.

Approach: Find all optimal solutions for every interval and return the best possible answer.

java
Always show details

Copy code
// from i to j
dp[i][j] = dp[i][k] + result[k] + dp[k+1][j]
Get the best from the left and right sides and add a solution for the current position.