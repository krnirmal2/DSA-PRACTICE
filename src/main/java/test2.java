public class test2 {

  public static void main(String[] args) {
    System.out.println("Try programiz.pro");
    int[] a = {1, 3, 4, 4, 6};
    int b = 4;
    System.out.println(lessThanNum(a, b));
  }

  private static int lessThanNum(int[] a, int b) {
    int low = 0;
    int high = a.length - 1;
    int mid = (high - low) / 2;
    System.out.println("resutl" + low);
    int count = 0;
    while (low < high) {
      if (a[mid] > b) {
        high = mid - 1;
        System.out.println(high);
      } else {
        low = mid + 1;
        count = low;
        System.out.println("count " + low);
        //   System.out.println(mid);
      }
    }
    System.out.println("resutl " + count);
    // at last low give the exact point 4
    return count + 1;
  }
}
