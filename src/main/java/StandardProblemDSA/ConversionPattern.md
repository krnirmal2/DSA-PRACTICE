**Java Collections Conversion Cheat Sheet**

---

### **1. Array → List**

```java
// For Integer[] (wrapper types)
Integer[] arr = {1, 2, 3};
List<Integer> list = Arrays.asList(arr); // fixed-size list (backed by array)
List<Integer> list2 = new ArrayList<>(Arrays.asList(arr)); // fully mutable

// For int[] (primitive types)
int[] arr2 = {1, 2, 3};
List<Integer> list3 = Arrays.stream(arr2) // convert to IntStream
                            .boxed()      // box to Integer
                            .collect(Collectors.toList());
```

---

### **2. List → Array**

```java
List<String> list = Arrays.asList("A", "B", "C");
String[] array = list.toArray(new String[0]); // returns ["A", "B", "C"]
```

---

### **3. Array → Set**

```java
String[] arr = {"A", "B", "C"};
Set<String> set = new HashSet<>(Arrays.asList(arr));
```

---

### **4. Set → Array**

```java
Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3));
Integer[] array = set.toArray(new Integer[0]);
```

---

### **5. List → Set**

```java
List<String> list = Arrays.asList("A", "B", "C");
Set<String> set = new HashSet<>(list); // removes duplicates
```

---

### **6. Set → List**

```java
Set<String> set = new HashSet<>(Arrays.asList("A", "B", "C"));
List<String> list = new ArrayList<>(set);
```

---

### **7. Array ↔ Stream**

```java
// Array → Stream
int[] arr = {1, 2, 3};
IntStream stream = Arrays.stream(arr);

// Stream → Array
int[] arr2 = stream.toArray();
```

---

### **8. List ↔ Stream**

```java
// List → Stream
List<String> list = Arrays.asList("A", "B", "C");
Stream<String> stream = list.stream();

// Stream → List
List<String> list2 = stream.collect(Collectors.toList());
```

---

### **Tip:**

* `Arrays.asList()` for **wrapper arrays** (Integer\[], String\[], etc.)
* For **primitive arrays (int\[], double\[], etc.)**, always use `Arrays.stream(arr).boxed()`.

---
Iteration allows you to **traverse elements** in a data structure. The method and behavior of iteration vary depending
on the **type of data structure**.

Here's a detailed overview with examples in Java:

---

## ✅ **1. Array**

### 🔸 Iteration Techniques:

* **For loop**
* **Enhanced for loop (for-each)**
* **Streams (Java 8+)**

```java
int[] arr = {1, 2, 3, 4};

for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}

for (int num : arr) {
    System.out.println(num);
}

Arrays.stream(arr).forEach(System.out::println);
```

---

## ✅ **2. ArrayList**

### 🔸 Iteration Techniques:

* For loop (index-based)
* Enhanced for loop
* Iterator
* ListIterator
* Streams

```java
ArrayList<String> list = new ArrayList<>();
list.add("A"); list.add("B");

for (int i = 0; i < list.size(); i++) {
    System.out.println(list.get(i));
}

for (String s : list) {
    System.out.println(s);
}

Iterator<String> it = list.iterator();
while (it.hasNext()) {
    System.out.println(it.next());
}

ListIterator<String> lit = list.listIterator();
while (lit.hasNext()) {
    System.out.println(lit.next());
}

list.stream().forEach(System.out::println);
```

---

## ✅ **3. LinkedList**

(Same as `ArrayList` but also supports **bidirectional** traversal)

```java
LinkedList<Integer> ll = new LinkedList<>();
ll.add(10); ll.add(20);

ListIterator<Integer> itr = ll.listIterator();
while (itr.hasNext()) {
    System.out.println(itr.next());
}

while (itr.hasPrevious()) {
    System.out.println(itr.previous());
}
```

---

## ✅ **4. HashSet**

### 🔸 No order guarantee.

```java
HashSet<String> set = new HashSet<>();
set.add("X"); set.add("Y");

for (String val : set) {
    System.out.println(val);
}

Iterator<String> it = set.iterator();
while (it.hasNext()) {
    System.out.println(it.next());
}
```

---

## ✅ **5. TreeSet**

* Elements in **sorted order**.

```java
TreeSet<Integer> ts = new TreeSet<>();
ts.add(5); ts.add(2); ts.add(8);

for (int val : ts) {
    System.out.println(val); // prints 2,5,8
}
```

---

## ✅ **6. HashMap**

* Use `.entrySet()`, `.keySet()`, `.values()`.

```java
HashMap<Integer, String> map = new HashMap<>();
map.put(1, "One");
map.put(2, "Two");

for (Map.Entry<Integer, String> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " = " + entry.getValue());
}

map.keySet().forEach(System.out::println);
map.values().forEach(System.out::println);
```

---

## ✅ **7. Queue (LinkedList or PriorityQueue)**

```java
Queue<String> queue = new LinkedList<>();
queue.add("A");
queue.add("B");

for (String item : queue) {
    System.out.println(item);
}
```

---

## ✅ **8. Stack**

```java
Stack<Integer> stack = new Stack<>();
stack.push(1); stack.push(2);

for (int val : stack) {
    System.out.println(val);
}
```

---

## 💡 Summary Table:

| Data Structure | Iterator | For-each | ListIterator | Stream | Order Maintained? |
|----------------|----------|----------|--------------|--------|-------------------|
| Array          | ✅        | ✅        | ❌            | ✅      | ✅                 |
| ArrayList      | ✅        | ✅        | ✅            | ✅      | ✅                 |
| LinkedList     | ✅        | ✅        | ✅            | ✅      | ✅                 |
| HashSet        | ✅        | ✅        | ❌            | ✅      | ❌                 |
| TreeSet        | ✅        | ✅        | ❌            | ✅      | ✅ (Sorted)        |
| HashMap        | ✅        | ✅        | ❌            | ✅      | ❌                 |
| Queue          | ✅        | ✅        | ❌            | ✅      | Depends on impl.  |
| Stack          | ✅        | ✅        | ❌            | ✅      | ✅ (LIFO)          |

---

Let me know if you want custom **interview-style questions** based on this topic!
