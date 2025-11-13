import java.util.*;

public class twoD {

  /**
   * Utility method to create a 2D ArrayList of Integers Preserves dynamic sizing and value
   * insertion patterns
   *
   * @return 2D ArrayList with sample data
   */
  public static List<List<Integer>> create2DArrayList() {
    List<List<Integer>> matrix = new ArrayList<>();

    // Row 0
    matrix.add(new ArrayList<>());
    matrix.get(0).add(0, 3);

    // Row 1
    matrix.add(new ArrayList<>(Arrays.asList(3, 4, 6)));
    matrix.get(1).add(0, 366);
    matrix.get(1).add(4, 576);
    matrix.get(1).addAll(3, Arrays.asList(22, 1000));

    // Row 2
    matrix.add(2, new ArrayList<>(Arrays.asList(3, 84)));

    // Row 3
    matrix.add(new ArrayList<>(Arrays.asList(83, 6684, 776)));

    // Row 4
    matrix.add(new ArrayList<>(List.of(8)));
    matrix.get(4).addAll(Arrays.asList(9, 10, 11));

    return matrix;
  }

  /**
   * Utility method to create a 2D LinkedHashSet of Strings Preserves insertion order and ensures
   * row-level uniqueness
   *
   * @return 2D LinkedHashSet with sample data
   */
  public static Set<Set<String>> create2DLinkedHashSet() {
    Set<Set<String>> set2D = new LinkedHashSet<>();

    // Row 0
    set2D.add(new LinkedHashSet<>(Arrays.asList("Apple", "Orange")));

    // Row 1
    set2D.add(new LinkedHashSet<>(Arrays.asList("Tea", "Coffee", "Milk", "Coffee", "Water")));

    // Row 2
    set2D.add(new LinkedHashSet<>(Arrays.asList("Tomato", "Potato", "Onion")));

    // Row 3 (duplicate of Row 2 - won't be added)
    set2D.add(new LinkedHashSet<>(Arrays.asList("Tomato", "Potato", "Onion")));

    return set2D;
  }
  // empty array
  /*
  int [][] input = {
          {,},{,},{,},
          {,},{,},{,}
  };
  */

}
