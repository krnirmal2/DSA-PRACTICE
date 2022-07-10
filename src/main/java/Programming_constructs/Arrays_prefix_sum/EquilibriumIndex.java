package Programming_constructs.Arrays_prefix_sum;
/* Problem Description
You are given an array A of integers of size N.

Your task is to find the equilibrium index of the given array

The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.

NOTE:

Array indexing starts from 0.
If there is no equilibrium index then return -1.
If there are more than one equilibrium indexes then return the minimum index.



Problem Constraints
1 <= N <= 105
-105 <= A[i] <= 105


Input Format
First arugment is an array A .


Output Format
Return the equilibrium index of the given array. If no such index is found then return -1.


Example Input
Input 1:
A=[-7, 1, 5, 2, -4, 3, 0]
Input 2:

A=[1,2,3]


Example Output
Output 1:
3
Output 2:

-1


Example Explanation
Explanation 1:
3 is an equilibrium index, because:
A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
Explanation 1:

There is no such index.
*/
public class EquilibriumIndex {

    static int solve(int A[]){

        int sum = 0;
        int size = A.length;

        int arr[] = new int [size];
        for (int i = 0;i<size;i++){
            sum = sum + A[i];
            arr[i] = sum;
        }
        int result =-1;
        int count = 0;
        int minIndex = 0;

        for(int j=0;j<size;j++)
        {

            int leftsum = 0;
            int rightSum = 0;
            if(j!=0){
                leftsum = arr[j-1];

            }
            rightSum = arr[size-1]-arr[j];

            if (leftsum == rightSum){

                count=count+1;
                if(count==1){
                    minIndex = j;
                }
                else
                    continue;

            }
        }
        if(count >= 1){
            result =  minIndex;
        }
        if(count == 0 ){
            result= -1;
        }
        return result;
    }




    public static void main(String[] args) {

        int  A[]={-7, 1, 5, 2, -4, 3, 0};

        System.out.println(solve(A));



    }


}
