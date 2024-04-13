package Programming_constructs.Introduction_to_array;

/*public class ArrayOfEvenOdd {

        public static void main(String[] args) {
            Scanner sc = new Scanner (System.in);

            int t = sc.nextInt ();
            while(t>0){
                int n = sc.nextInt ();
                int[] arr = new int[n];
                for(int i=0;i<n;i++){
                    arr[i] = sc.nextInt ();
                }
                solve(arr,n);
                t–-;
            }
        }
        private static int solve(int[] arr, int n) {
            int[] evenArr = new int[n];
            int[] oddArr = new int[n];
            int even = 0;
            int odd = 0;
            for(int i=0;i<n;i++){
                if(arr[i] % 2 == 0){
                    evenArr[even] = arr[i];
                    even++;
                } else {
                    oddArr[odd] = arr[i];
                    odd++;
                }
            }
            for(int i = 0; i < odd; i++){
                System.out.print(oddArr[i] + " ");
            }
            System.out.println();
            for(int i = 0; i < even; i++){
                System.out.print(evenArr[i] + " ");
            }
            System.out.println();
            return 1;
        }
    }*/
//        public static void solve(int A[]){
//            int odd[] = new int[A.length];
//            int even[] = new int[A.length];
//            // order of the array should be maintained during the insertion
//            int eveni =0;
//            int oddi =0;
//            for(int i =0 ;i<A.length;i++){
//                if((A[i]&1 )== 0){
//                    even[eveni] = A[i];
//                    eveni++;
//                }
//                else
//                    odd[oddi] = A[i];
//                oddi++;
//            }
//            for(int k=0;k<odd.length;k++){
//
//                System.out.print(odd[k]);
//
//            }
//            System.out.print("\n");
//            for(int j=0;j<even.length;j++){
//                System.out.print(even[j]);
//
//            }
//            System.out.print("\n");
////            return new Object[]{odd, even};
//
//        }
//
//        public static void main(String[] args) {
////            Scanner sc = new Scanner(System.in);
////                int TestCase = sc.nextInt();
////
//////            int A[] = new int[TestCase];
////
////            int i = 0;
////            while (i < TestCase) {
////                int lengthOfArray = sc.nextInt();
////                int A[] = new int[lengthOfArray];
////                for(int j=0;j<lengthOfArray;j++){
////                    // take element of a the given array
////                    A[j] = sc.nextInt();
////                }
//            int A[] ={1 ,2 ,3 ,4 ,5};
//                solve (A);
//
////                System.out.println("hello");
////                i++;
//            }
//
//        }
//    }

/*
2
5
1 2 3 4 5
3
4 3 2
*/


//public class Main /*{
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int test_cases = sc.nextInt();
//        int i = 1;
//        while (i++<= test_cases) {
//            int n = sc.nextInt();
//            int[] A = new int[n];
//            List<Integer> even = new ArrayList<>();
//            List<Integer> odd = new ArrayList<>();
//            //even.clear();
//            //odd.clear();
//            for (int j = 0; j<n; j++) {
//                A[j] = sc.nextInt();
//                if (A[j] % 2 == 0)
//                    even.add(A[j]);
//                else
//                    odd.add(A[j]);
//            }
//            for (int k = 0; k<odd.size(); k++)
//                System.out.print(odd.get(k) + " ");
//            System.out.println();
//            for (int k = 0; k<even.size(); k++)
//                System.out.print(even.get(k) + " ");
//            System.out.println();
//        }
//
//    }
//}*/