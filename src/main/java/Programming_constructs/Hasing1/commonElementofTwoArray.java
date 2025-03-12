package Programming_constructs.Hasing1;


import java.util.HashMap;

public class commonElementofTwoArray {
    public static int[] solve(int[] A, int[] B) {
        int sizeOfResultArrray = Math.min(A.length, B.length);
        int[] result = new int[sizeOfResultArrray];

        int index = 0;
        int count = 0;
        // create two hashmap of A and B
        HashMap<Integer, Integer> mapA = new HashMap();
        HashMap<Integer, Integer> mapB = new HashMap();
        HashMap<Integer, Boolean> visited = new HashMap();

        // insert the element and count the frequency of each element in A and B
        for (int i = 0; i < A.length; i++) {
            if (mapA.containsKey(A[i])) {
                mapA.put(A[i], mapA.get(A[i]) + 1);
            } else {
                mapA.put(A[i], 1);
            }

        }

        for (int i = 0; i < B.length; i++) {
            if (mapB.containsKey(B[i])) {
                mapB.put(B[i], mapB.get(B[i]) + 1);
            } else {
                mapB.put(B[i], 1);
            }

        }

        for (int i = 0; i < A.length; i++) {
            if (mapA.containsKey(A[i])) {
                visited.put(A[i], true);
                if (mapB.containsKey(A[i]) && index < sizeOfResultArrray) {
                    if (mapA.get(A[i]) < mapB.get(A[i])) {
                        count = 0;
                        while (count < mapA.get(A[i])) {
                            result[index] = A[i];
                            index++;
                            count++;
                        }
                    } else {
                        count = 0;
                        while (count < mapB.get(A[i]) && index < sizeOfResultArrray) {
                            result[index] = A[i];
                            index++;
                            count++;
                        }
                    }

                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 2, 1};
        int[] B = {2, 3, 1, 2};
        int[] result = solve(A, B);

        for (int i = 0; i < result.length; i++) {
            System.out.println(A[i]);
        }

    }

}





