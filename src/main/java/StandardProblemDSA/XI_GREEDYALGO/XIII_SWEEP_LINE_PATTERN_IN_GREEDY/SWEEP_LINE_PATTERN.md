**Sweep Line Pattern** (also called **Chronological Order Pattern**).

### Why Sweep Line?

* You treat **arrivals and departures as "events"** happening on a timeline.
* Sweep from the earliest event to the latest, keeping track of:

    * **+1** when a train arrives (need one more platform).
    * **-1** when a train departs (a platform is freed).
* The **maximum number of active trains at any point** is the answer.

---

### Key Characteristics of the Sweep Line Pattern

1. **Events are independent of pairs** — only their time matters.
2. **Sort events by time** (either separately or combined into one list with arrival/departure flags).
3. **Keep a running count** of ongoing intervals.
4. **Track the maximum** during the process.

---

### Other Problems Using Sweep Line

* Meeting Rooms II (minimum conference rooms required)
* Maximum number of overlapping intervals
* Number of airplanes in the sky at a time
* CPU load / active processes at a given time
* Find peak number of guests at a hotel
* Determine busy periods in logs

---
No, the **Sweep Line Pattern** is not only for greedy problems.

### Where is it used?

Sweep Line is a **general algorithmic technique** for solving problems that involve **events over a timeline or a line
in 1D/2D space**.

* **In greedy:**

    * Meeting Rooms II
    * Minimum number of platforms
    * Maximum guests in hotel

* **In computational geometry:**

    * Find intersection points of line segments.
    * Find the closest pair of points.
    * Rectangle union area problems.

* **In counting and interval problems:**

    * Active processes in CPU scheduling.
    * Number of overlapping intervals at any point.
    * Log analysis – active users over time.

---

### How to decide if Sweep Line applies?

Ask yourself:

1. **Does the problem involve intervals, events, or timelines?**
2. **Do we need to know the number of “active” events at any moment?**
3. **Can we treat arrivals/departures (start/end) as +1/-1 events?**
4. **Is the maximum/minimum/total overlap required?**

If most answers are **yes**, then a Sweep Line approach is often best.

---

Would you like me to make a **decision table** (5–6 questions) that helps you quickly check *“Does Sweep Line apply
here?”* during interviews?
I can give it in a compact format so you can **copy directly into IntelliJ**. Should I proceed?
