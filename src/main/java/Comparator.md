Nice — I restructured and cleaned your comparator guide into a compact, interview-ready **cheat sheet** with clear
sections, copy-paste templates, and quick tips. Use this as your go-to during coding rounds.

# Comparator Cheat-Sheet — 2D / Multi-field Sorting (Java 8+)

**When to use:** sorting `int[][]`, `List<int[]>`, `List<List<Integer>>`, `List<Pair>`, `List<Object[]>`,
`PriorityQueue` etc.
**Core idea:** provide a `Comparator` that compares by the chosen column/field; chain with `thenComparing()` for
tie-breaks; use `reversed()` for descending.

---

## 1. Quick primitives / array templates

```java
// int[][] sort by column col (ascending)
Arrays.sort(arr, (a, b) -> Integer.compare(a[col], b[col]));

// descending
Arrays.sort(arr, (a, b) -> Integer.compare(b[col], a[col]));
// or
Arrays.sort(arr, Comparator.comparingInt((int[] r) -> r[col]).reversed());
```

### Multi-key (primary then secondary)

```java
Arrays.sort(arr, (a, b) -> {
    if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
    return Integer.compare(a[1], b[1]);
});
// or the comparator chain (clean)
Arrays.sort(arr, Comparator
    .comparingInt((int[] r) -> r[0])
    .thenComparingInt(r -> r[1]));
```

---

## 2. List\<int\[]> and List\<Integer\[]>

```java
// List<int[]>
list.sort(Comparator.comparingInt(a -> a[col]));            // asc
list.sort(Comparator.comparingInt((int[] a) -> a[col]).reversed()); // desc

// List<Integer[]>
list.sort(Comparator.comparing(a -> a[col]));              // asc (auto-boxed)
```

---

## 3. List\<List<Integer>> (jagged lists)

```java
// sort by index i (ensure inner lists have that index)
list.sort(Comparator.comparingInt(l -> l.get(i)));
```

---

## 4. Custom class (Pair / POJO)

```java
class Pair { int x, y; /* constructor */ }

// primary then secondary (ascending)
list.sort(Comparator.comparing((Pair p) -> p.x)
                    .thenComparing(p -> p.y));

// primary ascending, secondary descending
list.sort(Comparator.comparing((Pair p) -> p.x)
                    .thenComparing(Comparator.comparing((Pair p) -> p.y).reversed()));
```

---

## 5. Comparator.comparing variants (best practices)

* Use `comparingInt`, `thenComparingInt` for primitive fields — avoids boxing.
* `Comparator.comparing(keyExtractor)` for Comparable keys.
* `reversed()` to flip order.
* `thenComparing(...)` for tie-breakers.

Examples:

```java
list.sort(Comparator.comparingInt((Pair p) -> p.x)
                    .thenComparingInt(p -> p.y).reversed()); // reversed entire comparator
```

---

## 6. Mixed-type `Object[]` or `List<Object[]>`

```java
// sort by String at index 0
records.sort((a, b) -> ((String) a[0]).compareTo((String) b[0]));

// sort by Integer at index 1
records.sort(Comparator.comparingInt(a -> (Integer) a[1]));
```

**Tip:** explicitly cast; document assumptions (nulls, types) in code.

---

## 7. PriorityQueue with comparators

```java
// min-heap by column 1
PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

// max-heap by column 1
PriorityQueue<int[]> pqMax = new PriorityQueue<>((a,b) -> Integer.compare(b[1], a[1]));
```

Classic uses: Dijkstra, K closest points, scheduling.

---

## 8. One-line tie-break templates

```java
// inline tie-break (int[][])
Arrays.sort(arr, (a, b) -> {
    int c = Integer.compare(a[0], b[0]);
    return c != 0 ? c : Integer.compare(a[1], b[1]);
});

// comparator chain
Arrays.sort(arr, Comparator.comparingInt((int[] r) -> r[0])
                          .thenComparingInt(r -> r[1]));
```

---

## 9. Performance & pitfalls (interview talking points)

* **Prefer primitive comparators** (`comparingInt`, `thenComparingInt`) to avoid boxing overhead.
* **Check bounds** when sorting `List<List<...>>` — ensure inner lists have required indices.
* **Stable vs unstable**: `Arrays.sort` for objects is stable (TimSort), but primitives use a dual-pivot quicksort (
  check JDK spec for version). For multi-field correctness, prefer chained comparators.
* **Null handling:** specify null-safe comparators, e.g. `Comparator.nullsFirst(...)`.
* **Avoid casting at runtime** for `Object[]` unless you control the format; explain assumptions in interviews.

---

## 10. Copy-paste Interview Templates (ready)

### int\[]\[] sort by col1 asc, col2 desc

```java
Arrays.sort(arr, Comparator
    .comparingInt((int[] r) -> r[0])
    .thenComparing((int[] r) -> r[1], Comparator.reverseOrder()));
```

### List<Pair> primary then secondary asc

```java
list.sort(Comparator.comparing((Pair p) -> p.x)
                    .thenComparingInt(p -> p.y));
```

### List\<List<Integer>> sort by index i desc

```java
list.sort(Comparator.comparingInt((List<Integer> l) -> l.get(i)).reversed());
```

---

## Final tips (what to say in interviews)

* Start by **naming types**: `int[][]`, `List<int[]>`, `List<Pair>`, etc. — interviewer likes clarity.
* State **ordering** (asc/desc) and **tie-break rules** before writing code.
* Use `Comparator.comparingInt` for primitives and `thenComparing` for tie-breaks.
* Mention **edge cases**: nulls, differing inner lengths, performance (boxing).

---

If you want, I can:

* Convert this into a single **one-page PDF** for quick revision, or
* Produce a **small Java utility class** that implements all templates and examples (copy-paste ready). Which one would
  you like?
  Perfect! 🔥 Here’s your **Ultimate Comparator Template** — a **one-page cheat sheet** for Strings, Integers, Objects, Arrays, 2D arrays, and PriorityQueue. This covers **all common interview scenarios**.

---

# 💎 Ultimate Comparator Template for Interviews

## 1️⃣ Strings

| Task                                    | Code                                                                                                                        |
| --------------------------------------- | --------------------------------------------------------------------------------------------------------------------------- |
| Sort by length ascending                | `list.stream().sorted(Comparator.comparingInt(String::length)).collect(toList());`                                          |
| Sort by length descending               | `list.stream().sorted(Comparator.comparingInt(String::length).reversed()).collect(toList());`                               |
| Sort by length → alphabetically         | `list.stream().sorted(Comparator.comparingInt(String::length).thenComparing(String::compareTo)).collect(toList());`         |
| Sort by length → reverse alphabetically | `list.stream().sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.reverseOrder())).collect(toList());` |

---

## 2️⃣ Integers

| Task                              | Code                                                                                                                |
| --------------------------------- | ------------------------------------------------------------------------------------------------------------------- |
| Natural order                     | `list.stream().sorted().collect(toList());`                                                                         |
| Reverse order                     | `list.stream().sorted(Comparator.reverseOrder()).collect(toList());`                                                |
| Custom: modulo 10 → natural order | `list.stream().sorted(Comparator.comparingInt((Integer x) -> x % 10).thenComparingInt(x -> x)).collect(toList());`  |
| Descending with tie-breakers      | `list.stream().sorted(Comparator.comparingInt(x -> x % 10).reversed().thenComparingInt(x -> x)).collect(toList());` |

---

## 3️⃣ Custom Objects

**Example:** Employee (department, salary, name)

| Task                                            | Code                                                                                                                                                                                                     |
| ----------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Primary: department                             | `employees.stream().sorted(Comparator.comparing(Employee::getDepartment)).collect(toList());`                                                                                                            |
| Department → salary descending                  | `employees.stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed())).collect(toList());`                                  |
| Department → salary descending → name ascending | `employees.stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed()).thenComparing(Employee::getName)).collect(toList());` |

---

## 4️⃣ Arrays & 2D Arrays

**int\[]\[] arr = { {5, 20}, {2, 10}, {8, 15} }**

| Task                  | Code                                                                                                    |
| --------------------- | ------------------------------------------------------------------------------------------------------- |
| Sort by 1st column    | `Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));`                                                 |
| Sort by 2nd column    | `Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));`                                                 |
| Sort by 1st → 2nd     | `Arrays.sort(arr, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));` |
| Descending 2nd column | `Arrays.sort(arr, (a,b) -> Integer.compare(b[1], a[1]));`                                               |

---

## 5️⃣ List\<int\[]> or List\<Integer\[]>

| Task                       | Code                                                                                    |
| -------------------------- | --------------------------------------------------------------------------------------- |
| Sort by index 0            | `list.sort(Comparator.comparingInt(a -> a[0]));`                                        |
| Sort by index 1 descending | `list.sort((a,b) -> Integer.compare(b[1], a[1]));`                                      |
| Multiple conditions        | `list.sort((a,b) -> a[0]==b[0]?Integer.compare(a[1],b[1]):Integer.compare(a[0],b[0]));` |

---

## 6️⃣ PriorityQueue with Comparator

| Task                    | Code                                                                                                                            |
| ----------------------- | ------------------------------------------------------------------------------------------------------------------------------- |
| Min-heap by 2nd element | `PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));`                                            |
| Max-heap by 2nd element | `PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[1], a[1]));`                                          |
| Custom tie-breakers     | `PriorityQueue<Employee> pq = new PriorityQueue<>(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName));` |

---

## 7️⃣ General Tips for Interviews

1. **Always start with primary key** → then tie-breakers.
2. **Use method references** whenever possible (`String::toUpperCase`, `Employee::getSalary`).
3. **Reverse order** → `.reversed()` on the comparator, not by swapping variables.
4. **2D arrays & Lists** → use `Comparator.comparingInt` or custom lambda `(a,b)->...`.
5. **PriorityQueue** → same comparator logic as `sorted`.
6. **Chaining multiple tie-breakers** → `.thenComparing(...)` repeatedly.

---

💡 **Shortcut for interviews:**

> “I usually start with `Comparator.comparing` for the primary key, then chain `.thenComparing` for tie-breakers. For descending order, I just use `.reversed()`. This works for objects, arrays, 2D arrays, and priority queues.”

---

If you want, I can **also create a one-page “Stream + Comparator + Collectors + Tie-breakers” combined template** — **everything in one place** for interview prep.

Do you want me to do that next?
Perfect! 🔥 Here’s your **Ultimate Comparator Template** — a **one-page cheat sheet** for Strings, Integers, Objects, Arrays, 2D arrays, and PriorityQueue. This covers **all common interview scenarios**.

---

# 💎 Ultimate Comparator Template for Interviews

## 1️⃣ Strings

| Task                                    | Code                                                                                                                        |
| --------------------------------------- | --------------------------------------------------------------------------------------------------------------------------- |
| Sort by length ascending                | `list.stream().sorted(Comparator.comparingInt(String::length)).collect(toList());`                                          |
| Sort by length descending               | `list.stream().sorted(Comparator.comparingInt(String::length).reversed()).collect(toList());`                               |
| Sort by length → alphabetically         | `list.stream().sorted(Comparator.comparingInt(String::length).thenComparing(String::compareTo)).collect(toList());`         |
| Sort by length → reverse alphabetically | `list.stream().sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.reverseOrder())).collect(toList());` |

---

## 2️⃣ Integers

| Task                              | Code                                                                                                                |
| --------------------------------- | ------------------------------------------------------------------------------------------------------------------- |
| Natural order                     | `list.stream().sorted().collect(toList());`                                                                         |
| Reverse order                     | `list.stream().sorted(Comparator.reverseOrder()).collect(toList());`                                                |
| Custom: modulo 10 → natural order | `list.stream().sorted(Comparator.comparingInt((Integer x) -> x % 10).thenComparingInt(x -> x)).collect(toList());`  |
| Descending with tie-breakers      | `list.stream().sorted(Comparator.comparingInt(x -> x % 10).reversed().thenComparingInt(x -> x)).collect(toList());` |

---

## 3️⃣ Custom Objects

**Example:** Employee (department, salary, name)

| Task                                            | Code                                                                                                                                                                                                     |
| ----------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Primary: department                             | `employees.stream().sorted(Comparator.comparing(Employee::getDepartment)).collect(toList());`                                                                                                            |
| Department → salary descending                  | `employees.stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed())).collect(toList());`                                  |
| Department → salary descending → name ascending | `employees.stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed()).thenComparing(Employee::getName)).collect(toList());` |

---

## 4️⃣ Arrays & 2D Arrays

**int\[]\[] arr = { {5, 20}, {2, 10}, {8, 15} }**

| Task                  | Code                                                                                                    |
| --------------------- | ------------------------------------------------------------------------------------------------------- |
| Sort by 1st column    | `Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));`                                                 |
| Sort by 2nd column    | `Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));`                                                 |
| Sort by 1st → 2nd     | `Arrays.sort(arr, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));` |
| Descending 2nd column | `Arrays.sort(arr, (a,b) -> Integer.compare(b[1], a[1]));`                                               |

---

## 5️⃣ List\<int\[]> or List\<Integer\[]>

| Task                       | Code                                                                                    |
| -------------------------- | --------------------------------------------------------------------------------------- |
| Sort by index 0            | `list.sort(Comparator.comparingInt(a -> a[0]));`                                        |
| Sort by index 1 descending | `list.sort((a,b) -> Integer.compare(b[1], a[1]));`                                      |
| Multiple conditions        | `list.sort((a,b) -> a[0]==b[0]?Integer.compare(a[1],b[1]):Integer.compare(a[0],b[0]));` |

---

## 6️⃣ PriorityQueue with Comparator

| Task                    | Code                                                                                                                            |
| ----------------------- | ------------------------------------------------------------------------------------------------------------------------------- |
| Min-heap by 2nd element | `PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));`                                            |
| Max-heap by 2nd element | `PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[1], a[1]));`                                          |
| Custom tie-breakers     | `PriorityQueue<Employee> pq = new PriorityQueue<>(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName));` |

---

## 7️⃣ General Tips for Interviews

1. **Always start with primary key** → then tie-breakers.
2. **Use method references** whenever possible (`String::toUpperCase`, `Employee::getSalary`).
3. **Reverse order** → `.reversed()` on the comparator, not by swapping variables.
4. **2D arrays & Lists** → use `Comparator.comparingInt` or custom lambda `(a,b)->...`.
5. **PriorityQueue** → same comparator logic as `sorted`.
6. **Chaining multiple tie-breakers** → `.thenComparing(...)` repeatedly.

---

💡 **Shortcut for interviews:**

> “I usually start with `Comparator.comparing` for the primary key, then chain `.thenComparing` for tie-breakers. For descending order, I just use `.reversed()`. This works for objects, arrays, 2D arrays, and priority queues.”

---
Perfect! 🔥 Here’s a **generalized, interview-ready template** for **grouping → aggregation → filtering → mapping** using Java Streams. You can reuse it for **any object, number, or string**.

---

# 💎 General Template: Group → Aggregate → Filter → Map

```java
// Generic Stream Template
Map<KeyType, AggregatedType> resultMap = list.stream()
    // 1️⃣ Optional: Filter items before grouping
    .filter(item -> /* condition on item */ true)
    
    // 2️⃣ Group by key
    .collect(Collectors.groupingBy(
        item -> /* key extractor, e.g., item.getCategory() */,
        
        // 3️⃣ Aggregate values per key
        Collectors.summingDouble(item -> /* numeric value to sum */ 0)
        // OR Collectors.counting() for count
        // OR Collectors.averagingDouble(item -> value)
        // OR Collectors.mapping(..., Collectors.toList()) for lists
    ))
    
    // 4️⃣ Optional: Filter aggregated results
    .entrySet().stream()
    .filter(entry -> /* condition on aggregated value, e.g., entry.getValue() > 200 */ true)
    
    // 5️⃣ Collect as final Map
    .collect(Collectors.toMap(
        Map.Entry::getKey,
        Map.Entry::getValue
    ));
```

---

## 🔹 Example 1: Orders

```java
Map<String, Double> totalCompletedAmount = orders.stream()
    .filter(o -> o.getStatus().equals("completed"))  // only completed
    .collect(Collectors.groupingBy(
        Order::getCustomer,
        Collectors.summingDouble(Order::getAmount)    // sum amount per customer
    ))
    .entrySet().stream()
    .filter(e -> e.getValue() > 200)                 // only totals > 200
    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
```

---

## 🔹 Example 2: Students & Scores

```java
Map<String, Double> topStudents = students.stream()
    .filter(s -> s.getScore() > 50)                // only passing scores
    .collect(Collectors.groupingBy(
        Student::getClassName,
        Collectors.averagingDouble(Student::getScore) // average per class
    ))
    .entrySet().stream()
    .filter(e -> e.getValue() > 75)                // classes with avg > 75
    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
```

---

## 🔹 Tips for Interviews

1. **Step 1:** Decide if filtering happens **before or after aggregation**.
2. **Step 2:** Use appropriate aggregation collector:

  * `summingDouble()` → sum
  * `counting()` → count
  * `averagingDouble()` → average
  * `mapping(..., toList())` → collect items
3. **Step 3:** Post-filter **entrySet** if the condition depends on the aggregated value.
4. **Step 4:** Always return as `Map<KeyType, AggregatedType>` for clarity.
5. **Step 5:** Combine with `sorted()` on entrySet if you want **top N results**.

---

If you want, I can **continue this stream-interview series** with **next-level challenge**:

* **Nested grouping** + **aggregations** + **top-N selection** in one stream — extremely common in **FAANG-level interviews**.

Do you want me to continue with that next?



