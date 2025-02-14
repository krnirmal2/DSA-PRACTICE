package StandardProblemDSA.STRING.STRING_MANIPULATION_PATTERN;

public class StringManipulation {
}
/*Below are the problems and implementations for each task, along with explanations. The solutions are designed to build understanding of basic string manipulation concepts.

---

### 1. **Reverse a String**

#### **Problem Statement:**
Write a program to reverse a given string. For example:
- Input: `"hello"`
- Output: `"olleh"`

#### **Explanation:**
Reversing a string involves iterating over it from the end to the start and appending each character to a new string or using a two-pointer approach.

#### **Solution in Java:**
```java
public class ReverseString {
    public static String reverse(String str) {
        if (str == null || str.isEmpty()) {
            return str; // Handle null or empty strings
        }
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        String input = "hello";
        String output = reverse(input);
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + output);
    }
}
```

#### **Output:**
- Original: `hello`
- Reversed: `olleh`

---

### 2. **Check if a String is a Palindrome**

#### **Problem Statement:**
Write a program to check if a string reads the same backward as forward (case-insensitive). For example:
- Input: `"Madam"`
- Output: `true`

#### **Explanation:**
A palindrome is a word that reads the same in both directions. Use a two-pointer approach to compare characters at the beginning and end.

#### **Solution in Java:**
```java
public class PalindromeCheck {
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        str = str.toLowerCase(); // Make the comparison case-insensitive
        int start = 0, end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "Madam";
        System.out.println("Is \"" + input + "\" a palindrome? " + isPalindrome(input));
    }
}
```

#### **Output:**
- Input: `Madam`
- Output: `true`

---

### 3. **Concatenate Strings**

#### **Problem Statement:**
Concatenate two strings into one. For example:
- Input: `"Hello"` and `"World"`
- Output: `"HelloWorld"`

#### **Explanation:**
Concatenation is the process of combining two strings. You can use `+`, `concat()` method, or `StringBuilder` in Java.

#### **Solution in Java:**
```java
public class ConcatenateStrings {
    public static String concatenate(String str1, String str2) {
        return str1 + str2; // Concatenation using +
    }

    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";
        String result = concatenate(str1, str2);
        System.out.println("Concatenated String: " + result);
    }
}
```

#### **Output:**
- Input: `Hello`, `World`
- Output: `HelloWorld`

---

### 4. **Split a String by a Delimiter**

#### **Problem Statement:**
Split a string into substrings using a delimiter. For example:
- Input: `"apple,banana,orange"`, Delimiter: `,`
- Output: `["apple", "banana", "orange"]`

#### **Explanation:**
The `split()` method splits a string into an array of substrings using the specified delimiter.

#### **Solution in Java:**
```java
import java.util.Arrays;

public class SplitString {
    public static String[] splitByDelimiter(String str, String delimiter) {
        if (str == null || delimiter == null) {
            return new String[0]; // Handle null cases
        }
        return str.split(delimiter); // Split using the delimiter
    }

    public static void main(String[] args) {
        String input = "apple,banana,orange";
        String delimiter = ",";
        String[] result = splitByDelimiter(input, delimiter);
        System.out.println("Split Result: " + Arrays.toString(result));
    }
}
```

#### **Output:**
- Input: `apple,banana,orange`, Delimiter: `,`
- Output: `["apple", "banana", "orange"]`

---

### 5. **Substring Extraction (Using Indices or Patterns)**

#### **Problem Statement:**
Extract a substring from a given string using starting and ending indices. For example:
- Input: `"hello world"`, Start: `0`, End: `5`
- Output: `"hello"`

#### **Explanation:**
Substring extraction involves using indices to fetch a part of the string. In Java, this is achieved using the `substring()` method.

#### **Solution in Java:**
```java
public class SubstringExtraction {
    public static String extractSubstring(String str, int start, int end) {
        if (str == null || start < 0 || end > str.length() || start > end) {
            throw new IllegalArgumentException("Invalid indices");
        }
        return str.substring(start, end); // Extract substring
    }

    public static void main(String[] args) {
        String input = "hello world";
        int start = 0, end = 5;
        String result = extractSubstring(input, start, end);
        System.out.println("Original: " + input);
        System.out.println("Substring: " + result);
    }
}
```

#### **Output:**
- Input: `hello world`, Start: `0`, End: `5`
- Output: `hello`

---

### **Concepts Built by These Problems:**
1. **Basic String Manipulation**:
   - Helps understand core operations like reversing, concatenating, and splitting strings.

2. **Two-Pointer Technique**:
   - Used in palindrome checking and substring extraction, which are essential for solving advanced problems.

3. **Efficiency**:
   - Familiarizes you with how strings work in Java, including immutability and efficient manipulation using tools like `StringBuilder`.

4. **Problem-Solving Foundation**:
   - Builds confidence in handling string-related questions, which are frequently asked in interviews.

Let me know if you'd like further examples or enhancements!*/