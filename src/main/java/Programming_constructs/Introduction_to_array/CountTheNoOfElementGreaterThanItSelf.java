package Programming_constructs.Introduction_to_array;

public class CountTheNoOfElementGreaterThanItSelf {

//    let arr[]={-3,-2,6,8,4,8,5}

    public static void main(String[] args) {
        int[] arr = {-3, 6, 8, 4, 8, 5};

        count(arr);
    }

    private static int count(int[] arr) {
        int max = arr[0];
        int size = arr.length;

        int frequency = 0, count = 0;
        for (int i = 0; i < size; i++) {
            max = Math.max(arr[i], max);

            if (arr[i] != max) {
                frequency++;
            } else
                count++;
        }
        return frequency;


    }


}
