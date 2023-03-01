package Programming_constructs.BinarySearch;

public class SqrtOfANo {

        public static int sqrt(int A) {
            return recursion(1,A,A);

        }
        static int recursion(int left, int right, int A){

            // find
            int  mid = (left+right)/2;

            //  we know that the square root lie between 1 to A
            if(mid * mid == A ) return (int) Math.floor(mid);
//            if(left == right ==mid) return mid;



            if(mid *mid <A) { return recursion( mid, right,  A); }
            if(mid *mid >A) { return recursion( left , mid-1,  A);

        }
            return mid;
        }

    public static void main(String[] args) {
        System.out.println(sqrt(74));
    }

}
