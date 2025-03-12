package Programming_constructs.Hasing2;

import java.util.HashMap;

public class Sum2 {
    public static int[] twoSum(int[] numbers, int target) {

        HashMap<Integer, Integer> mp = new HashMap<>();
        int[] result = new int[2];
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (mp.containsKey(target - numbers[i])) {
                result[0] = mp.get(target - numbers[i]) + 1;
                result[1] = i + 1;
                break;
            } else {
                if (mp.containsKey(numbers[i])) {
                    minIndex = Math.min(minIndex, mp.get(numbers[i]));
                    mp.put(numbers[i], i);
                    mp.put(numbers[i], i);

                }

            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8};

        int[] k = twoSum(a, -3);
        for (int i = 0; i < 2; i++)
            System.out.println(k[i]);


    }


}
