Perfect. Here's a **curated ladder of in-place "duplicate removal" questions** from **basic to advanced**, covering
arrays, sorted/unsorted, cyclic sort, and edge cases — **all require O(1) extra space**, no HashSet.

---

## 📚 In-Place Duplicate Removal Questions Ladder

| Level   | Problem                                                  | Pattern                             | Link                                                                           |
|---------|----------------------------------------------------------|-------------------------------------|--------------------------------------------------------------------------------|
| 🔰 Easy |                                                          |                                     |                                                                                |
| 1       | Remove Duplicates from Sorted Array                      | Two pointers                        | [LC 26](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)    |
| 2       | Remove Element                                           | Two pointers (filtering)            | [LC 27](https://leetcode.com/problems/remove-element/)                         |
| 3       | Remove Duplicates from Sorted List (LinkedList)          | Linked list pointer manipulation    | [LC 83](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)     |
| 4       | Remove Duplicates from Sorted Array II (Allow at most 2) | Two pointers (controlled allowance) | [LC 80](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/) |

---

\| ⚙️ Medium |
\|---------|---------|------|-----|
\| 5 | Move Duplicates to End (like Move Zeroes variation) | Two pointers (non-dup move) | *Custom* |
\| 6 | Remove All Duplicates from Linked List II (only unique allowed) | Edge-case LL
handling | [LC 82](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/) |
\| 7 | Find All Duplicates in an Array | Index marking (
sign) | [LC 442](https://leetcode.com/problems/find-all-duplicates-in-an-array/) |
\| 8 | Find the Duplicate Number (Exactly one duplicate) | Cycle detection (
Floyd's) | [LC 287](https://leetcode.com/problems/find-the-duplicate-number/) |
\| 9 | Set Mismatch (Duplicate and missing) | Cyclic sort | [LC 645](https://leetcode.com/problems/set-mismatch/) |

---

\| 🔥 Advanced |
\|------------|------|------|-----|
\| 10 | First Missing Positive | Cyclic sort + in-place
marking | [LC 41](https://leetcode.com/problems/first-missing-positive/) |
\| 11 | Remove Duplicates from Unsorted Array (Allow only 1) | Sort + In-place remove | *Custom* |
\| 12 | Remove All Adjacent Duplicates in String (using char\[] in-place) | Stack simulation
in-place | [LC 1047](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/) |
\| 13 | Minimum Deletions to Make Character Frequencies Unique | Greedy with freq array (Not strictly in-place but very
close) | [LC 1647](https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/) |

---

| Day          | Problem                                        | Link                                                                                             | Goal                                     |
|--------------|------------------------------------------------|--------------------------------------------------------------------------------------------------|------------------------------------------|
| 🟢 **Day 1** | 1. Remove Duplicates from Sorted Array         | [LC 26](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)                      | Learn in-place overwrite (two pointers)  |
| 🟢 **Day 1** | 2. Remove Element                              | [LC 27](https://leetcode.com/problems/remove-element/)                                           | Practice filtering values in-place       |
| 🔜 Day 2     | 3. Remove Duplicates from Sorted LinkedList    | [LC 83](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)                       | Apply pointer logic on linked list       |
| 🔜 Day 2     | 4. Remove Duplicates from Sorted Array II      | [LC 80](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)                   | Allow only 2 copies (advanced overwrite) |
| 🔜 Day 3     | 5. Move Duplicates to End (Custom variant)     | Provided by me                                                                                   | Practice pattern transformation          |
| 🔜 Day 3     | 6. Remove All Duplicates from Linked List II   | [LC 82](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)                    | Linked list edge case handling           |
| 🔜 Day 4     | 7. Find All Duplicates in an Array             | [LC 442](https://leetcode.com/problems/find-all-duplicates-in-an-array/)                         | In-place marking via signs               |
| 🔜 Day 4     | 8. Find the Duplicate Number                   | [LC 287](https://leetcode.com/problems/find-the-duplicate-number/)                               | Floyd’s Cycle Detection                  |
| 🔜 Day 5     | 9. Set Mismatch                                | [LC 645](https://leetcode.com/problems/set-mismatch/)                                            | Cyclic sort variant                      |
| 🔜 Day 5     | 10. First Missing Positive                     | [LC 41](https://leetcode.com/problems/first-missing-positive/)                                   | Hardcore cyclic in-place                 |
| 🔜 Day 6     | 11. Remove Duplicates from Unsorted Array      | *Custom variant*                                                                                 | Simulate in-place with sort              |
| 🔜 Day 6     | 12. Remove All Adjacent Duplicates             | [LC 1047](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/)               | Stack using char\[] in-place             |
| 🔜 Day 7     | 13. Minimum Deletions to Make Frequency Unique | [LC 1647](https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/) | Greedy + frequency constraints           |

### 💡 Want Hints or Templates?

I can give you hints or starter templates for each in Java when you're ready.

---

### ✅ Your Task:

* Start from Level 1.
* Once solved, reply with the problem number (e.g. “Solved 1”), and I’ll give feedback if needed.

Want me to set it up as a **daily challenge with tracker**?
