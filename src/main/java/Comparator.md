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
