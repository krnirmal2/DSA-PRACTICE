package Programming_constructs.Arrays_carray_forward;

public class ClosestMaxMin {
    static int solve(int [] A){
        int sizeA = A.length;
        //find the max and min value from the array
        int min;
        int max=min= A[0];
        for(int i=0;i<sizeA;i++)
        {
            if(A[i]>max){
                max = A[i];
            }
            if(A[i]<min){
                min = A[i];
            }

        }
        int ans = sizeA;

        // now two case are arise
        // first fine max and then min
        int min_index = -1;
        for(int j=sizeA-1 ;j>=0;j--){

            if(A[j]==min){
                // update max_index
                min_index = j;
          ans = Math.min(ans, j-min_index- +1);
            }


            //case two when find

        }


        return ans;
    }

    public static void main(String[] args) {
        int a[] = {};

    }
}
