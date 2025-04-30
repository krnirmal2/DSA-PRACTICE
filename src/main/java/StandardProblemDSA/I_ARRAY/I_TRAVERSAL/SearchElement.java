package StandardProblemDSA.I_ARRAY.I_TRAVERSAL;

import StandardProblemDSA.Utility;

public class SearchElement {
  public boolean isElementPrsent(int[] A, int element) {
    return Utility.linearSearch(A, element);
  }
}
