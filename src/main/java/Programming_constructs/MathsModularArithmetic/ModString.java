package Programming_constructs.MathsModularArithmetic;

public class ModString {
    public static int findMod(String A, int B) {
        int res=0;

// One by one process all digits of 'num'
// xy (mod a) ≡ ((x (mod a) * 10) + (y (mod a))) mod a

// where, x : left-most digit

// y: rest of the digits except x.

// for example:

// 625 % 5 = (((6 % 5)*10) + (25 % 5)) % 5 = 0
        for (int i = 0; i < A.length(); i++)
            res = (res * 10 + (int)A.charAt(i) - '0') % B;

        return res;

//          int IntegerValueOfStringA=0;
//             int j=0;
//             int i,l,n=0;
//             // int mod;
// //            if(A.length()<=5)
// //            {  l= A.length()-1;
// //                while(l>=0 && n<=A.length()-1)
// //                    // System.out.println(Character.getNumericValue(A.charAt(i)));
// //                    IntegerValueOfStringA += (Character.getNumericValue(A.charAt(l))*Math.pow(10,n));
// //                l=l+1;
// //                n=n+1;
// //            }
// //            else{//43535321
//                 i= A.length()-1;
//                 while(i>=0 && j<= A.length()-1){
//                     // System.out.println(Character.getNumericValue(A.charAt(i)));
//                     IntegerValueOfStringA += (Character.getNumericValue(A.charAt(i))*Math.pow(10,j));
//                     i--;
//                     j++;

//                 }
//                 IntegerValueOfStringA = (IntegerValueOfStringA % B);
// //            }

//             // else{
//             //     IntegerValueOfStringA= IntegerValueOfStringA;
//             // }


//             // System.out.println(IntegerValueOfStringA);
//             int mod = (IntegerValueOfStringA % B);
//             // return (IntegerValueOfStringA % B);
//             return mod;
//         }
    }

    public static void main(String[] args) {
            String A = "842554936302263";
            int B =41;
        System.out.println(findMod(A,B));

    }
    }

