
---

## ✅ **How to Know a Problem is Greedy?**

Look for these **greedy signals**:

| 🔍 Greedy Clue                                                          | ✅ What It Means                                           |
| ----------------------------------------------------------------------- | --------------------------------------------------------- |
| **"Maximum"/"Minimum" sum/value/cost**                                  | You're optimizing something (e.g., max profit, min jumps) |
| **"At each step" or "one choice per step"**                             | You need to make repeated local decisions                 |
| **No backtracking allowed**                                             | Can't undo previous decisions → ideal for greedy          |
| **Order matters** (e.g., sorted jobs, deadlines, earliest/latest first) | Sorting is often the first step in greedy                 |
| **You can prove** that a local choice won't hurt global outcome         | Optimal substructure exists                               |

---

## 🧠 **Mental Tricks to Detect Greedy**

1. **Can I sort something to simplify?**

    * Greedy often starts with sorting by value, deadline, or ratio.
    * Example: Sort jobs by profit or deadlines.

2. **If I always pick the best choice now, will it hurt future?**

    * If answer is “No”, it’s likely greedy.
    * Tip: Try **proving** greedy using exchange arguments.

3. **Do I need the optimal result or just any valid one?**

    * If optimal is needed but only one decision per step is allowed → suspect greedy.

---

## 🧪 **Test if Greedy Will Work (Tricks)**

| Trick/Test                  | Explanation                                                                         | Example                               |
| --------------------------- | ----------------------------------------------------------------------------------- | ------------------------------------- |
| 🔁 **Counterexample check** | Try a brute-force and greedy on small input (3–4 elements) and compare results      | Can help eliminate wrong greedy logic |
| 🔃 **Greedy vs DP**         | Ask: If I store choices to avoid recomputation → DP. If not needed → Greedy is fine | Jump Game = Greedy; Coin Change = DP  |
| 🔢 **Sort and Simulate**    | Sorting then making greedy choices usually works in interval and task problems      | Activity Selection, Task Scheduler    |
| 📈 **Ratio-based sorting**  | If task has weight & cost, try sorting by `value/weight` or other ratios            | Fractional Knapsack                   |

---

## 🔥 Common Greedy Problem Types

| Type                              | Greedy Strategy                        | Classic Problem                      |
| --------------------------------- | -------------------------------------- | ------------------------------------ |
| **Interval Scheduling**           | Sort by end time, pick non-overlapping | Activity Selection                   |
| **Minimum Number of Something**   | Make biggest reduction first           | Jump Game II, Gas Station            |
| **Maximize Profit or Value**      | Sort by profit/value per unit          | Fractional Knapsack                  |
| **Job Scheduling / Tasks**        | Sort by deadline or greedy profit      | Job Sequencing                       |
| **String / Digit Manipulation**   | Stack, greedy selection                | Remove K Digits                      |
| **Huffman Encoding / Merge Cost** | Greedy pairwise merge (min heap)       | Optimal Merge Pattern                |
| **Greedy with Constraints**       | Sort & simulate with counter           | Candy Distribution, Partition Labels |

---

## 🧩 Sample Questions that Are Greedy

| Problem                | Why Greedy Works                                          |
| ---------------------- | --------------------------------------------------------- |
| **Activity Selection** | Pick interval that ends earliest → leaves room            |
| **Jump Game (I)**      | Maximize farthest reachable at each index                 |
| **Minimum Platforms**  | Sort arrivals/departures → allocate efficiently           |
| **Gas Station**        | Always accumulate as much gas as needed minimally         |
| **Lemonade Change**    | Always give higher denomination first if possible         |
| **Assign Cookies**     | Sort greed factors & cookie sizes, give smallest possible |

---

## ✅ Greedy Proof Tips (For Interviews)

* **Exchange Argument**: Assume another solution, then swap greedy choice with it and show no harm.
* **Staying Ahead**: Track greedy vs optimal and prove greedy is always equal or better at every step.

---


Great — you're asking about a **fundamental and powerful algorithmic paradigm**: the **Sweep Line Algorithm**.

Let me break down everything you need to know — from basic intuition to advanced usage — so you can confidently apply it in online assessments and interviews.

---

# 🧹 Sweep Line Algorithm — Master Guide

---

## 🧠 **What Is the Sweep Line Algorithm?**

The **Sweep Line Algorithm** is a powerful **event-based algorithm** used to solve **interval-related problems efficiently**.

* You imagine a **line (sweeping)** across a timeline or plane
* You process **events** (like start or end of intervals, points, etc.) **in sorted order**
* At each event, you **update a data structure** that tracks "active" items (e.g., how many are overlapping)
* You answer the query as you sweep: like max overlap, conflicts, or coverage

---

## 📦 **Classic Problems Solved with Sweep Line**

| Problem Type                       | Example                                           |
| ---------------------------------- | ------------------------------------------------- |
| Intervals overlap                  | **Minimum platforms for trains**, merge intervals |
| Points in plane                    | Line segment intersection                         |
| Range coverage                     | Max events in range                               |
| Meeting rooms                      | Find if a person can attend all meetings          |
| Maximum number of people in a room | Based on entry/exit logs                          |
| Skyline problem                    | From building height silhouettes                  |

---

## 🧮 **Core Idea Behind Sweep Line**

Let’s say we have intervals (start, end), like:

```
Train Arrivals:   [900, 940, 950, 1100, 1500, 1800]
Train Departures: [910,1200,1120,1130,1900,2000]
```

### Steps:

1. Treat each start time as `(+1)` event (train arrived)
2. Treat each end time as `(-1)` event (train left)
3. Combine all times as events:

   ```
   (900, +1), (910, -1), (940, +1), ...
   ```
4. Sort events by time, and for ties, **departure before arrival**
5. Traverse linearly, keeping track of `currentTrains += eventType`
6. Track `maxTrainsSeenSoFar`

### Why it works?

The **timeline tells us everything**. We only need to process change points (not iterate across all minutes).

---

## ⏱️ **Time Complexity**

* Sort events: `O(n log n)`
* Sweep events: `O(n)`

➡️ Total: **O(n log n)** — very efficient for large `n`

---

## ⚙️ **Key Template (Java)**

```java
public int findMinimumPlatforms(int[] arrival, int[] departure) {
    int n = arrival.length;

    int[][] events = new int[n * 2][2];

    for (int i = 0; i < n; i++) {
        events[2 * i] = new int[]{arrival[i], +1};   // Arrival
        events[2 * i + 1] = new int[]{departure[i], -1}; // Departure
    }

    Arrays.sort(events, (a, b) -> {
        if (a[0] != b[0]) return a[0] - b[0];
        return a[1] - b[1]; // Depart (-1) before arrive (+1) if tie
    });

    int maxPlatforms = 0, current = 0;

    for (int[] e : events) {
        current += e[1];
        maxPlatforms = Math.max(maxPlatforms, current);
    }

    return maxPlatforms;
}
```

---

## 🔎 **Important Sorting Tie-break**

For same time `t`, we must ensure:

* **Departure (-1) is processed before Arrival (+1)**

Why?
If a train departs at 10:00 and another arrives at 10:00, **no new platform is needed** if we process departure first.

---

## 🧠 When to Think of Sweep Line?

Ask these questions:

* ❓ Are you given intervals or time ranges?
* ❓ Do you need to find *max overlap*, *conflicts*, or *coverage*?
* ❓ Can events be represented as `(+1)` and `(-1)`?
* ❓ Do events need to be processed in chronological order?

If yes ➝ **Sweep Line** is a strong fit!

---

## 🛠️ Variants and Extensions

| Variant                     | Use Case                                     |
| --------------------------- | -------------------------------------------- |
| With segment trees          | Count overlaps in ranges                     |
| With ordered maps (TreeMap) | Count events dynamically                     |
| With Priority Queue         | Track end times (used in "Meeting Rooms II") |

---

## 📘 Famous Interview Problems Using Sweep Line

1. **Minimum Number of Platforms (Train Problem)**
2. **Meeting Rooms / Can Attend All Meetings**
3. **Merge Intervals / Interval Overlap Count**
4. **Skyline Problem** (Hard - Leetcode)
5. **My Calendar I/II/III (Booking System)**
6. **Employee Free Time**

---

## ✅ Summary

| Feature | Description                                      |
| ------- | ------------------------------------------------ |
| Input   | Intervals or events with time                    |
| Process | Convert to (+1) and (–1) events                  |
| Sort    | By time, then by type (-1 before +1)             |
| Track   | Active count during the sweep                    |
| Output  | Max active count / conflict detection / coverage |

---

Would you like:

* 📊 A visual diagram explaining sweep line steps?
* 💻 A list of curated Leetcode problems for practicing sweep line?
