package Programming_constructs.Sorting;

public class ThreeColorSorting {
    public static int[] sortColors(int[] A) {
        int count =0;
        int index =0;
        int result[] = new int[A.length];
        for(int i =0;i<A.length;i++){
            if(A[i] <1){
                result[count]=A[i];
                count++;
            }
        }
        for(int k =0;k<A.length;k++){
            if(A[k] == 1){
                result[count]=A[k];
                count++;
            }
        }
        for(int j =0;j<A.length;j++){
            if(A[j] >1){
                result[count]=A[j];
                count++;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int A [] = {2, 0, 0, 1, 0, 0, 2, 2, 1, 1, 0, 0, 1, 0, 2, 1, 1, 0, 1, 0, 1, 2, 2, 2, 0, 0, 1, 0, 2, 1, 1, 2,
                1, 2, 2, 1, 0, 2, 2, 1, 1, 1, 0, 1, 0, 1, 0, 2, 1, 2, 0, 2, 0, 1, 1, 0, 2, 2, 1, 2, 0, 2, 1, 1, 1, 2,
                0, 1, 0, 2, 2, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 2, 1, 1, 0, 2, 1, 2, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 1, 1,
                0, 2, 1, 2, 2, 2, 1, 2, 2, 0, 1, 0, 1, 2, 1, 1, 0, 1, 2, 0, 1, 0, 2, 2, 1, 2, 1, 0, 2, 2, 1, 1, 0, 2, 1, 2 };
       A=  sortColors(A);
        for(int i =0;i<A.length;i++){
            System.out.print(A[i]);
        }

    }


}
