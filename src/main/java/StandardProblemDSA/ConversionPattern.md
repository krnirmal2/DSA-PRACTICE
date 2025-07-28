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
