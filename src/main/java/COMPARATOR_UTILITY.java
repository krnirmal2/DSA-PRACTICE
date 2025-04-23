import java.util.*;
public class COMPARATOR_UTILITY {

    /** ------------------- 1. Sort int[][] ------------------- **/

    // Sort by specific column (ascending)
    public static void sortIntMatrixByColumn(int[][] arr, int colIndex) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[colIndex], b[colIndex]));
    }

    // Sort by specific column (descending)
    public static void sortIntMatrixByColumnDesc(int[][] arr, int colIndex) {
        Arrays.sort(arr, (a, b) -> Integer.compare(b[colIndex], a[colIndex]));
    }

    /** ------------------- 2. Sort List<List<Integer>> ------------------- **/

    // Sort by index in List<List<Integer>> (ascending)
    public static void sortListOfListsByIndex(List<List<Integer>> list, int index) {
        Collections.sort(list, (a, b) -> Integer.compare(a.get(index), b.get(index)));
    }

    // Sort by index (descending)
    public static void sortListOfListsByIndexDesc(List<List<Integer>> list, int index) {
        Collections.sort(list, (a, b) -> Integer.compare(b.get(index), a.get(index)));
    }

    /** ------------------- 3. Sort List<int[]> ------------------- **/

    // Sort List<int[]> by column
    public static void sortListOfArraysByIndex(List<int[]> list, int index) {
        list.sort((a, b) -> Integer.compare(a[index], b[index]));
    }

    /** ------------------- 4. Sort List of Custom Pair ------------------- **/

    public static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x; this.y = y;
        }
        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    // Sort by x, then y
    public static void sortPairList(List<Pair> list) {
        list.sort(Comparator.comparing((Pair p) -> p.x).thenComparing(p -> p.y));
    }

    // Descending by x, then y
    public static void sortPairListDesc(List<Pair> list) {
        list.sort(Comparator.comparing((Pair p) -> p.x).reversed().thenComparing(p -> p.y));
    }

    /** ------------------- 5. Sort List<Object[]> ------------------- **/

    public static void sortObjectListByString(List<Object[]> list, int stringIndex) {
        list.sort((a, b) -> ((String) a[stringIndex]).compareTo((String) b[stringIndex]));
    }

    public static void sortObjectListByInteger(List<Object[]> list, int intIndex) {
        list.sort((a, b) -> ((Integer) a[intIndex]).compareTo((Integer) b[intIndex]));
    }

    /** ------------------- 6. Priority Queue with Comparator ------------------- **/

    // Min Heap by second value of int[]
    public static PriorityQueue<int[]> minHeapBySecond() {
        return new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
    }

    // Max Heap by second value of int[]
    public static PriorityQueue<int[]> maxHeapBySecond() {
        return new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
    }

    public static void main(String[] args) {
        int[][] arr = {{5, 20}, {2, 10}, {8, 15}};
        sortIntMatrixByColumn(arr, 1); // sort by column 1

        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(5, 20));
        list.add(Arrays.asList(2, 10));
        sortListOfListsByIndex(list, 1);

        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(3, 4));
        pairs.add(new Pair(1, 2));
        sortPairList(pairs);

        PriorityQueue<int[]> pq = minHeapBySecond();
        pq.offer(new int[]{3, 20});
        pq.offer(new int[]{1, 10});

    }
}
