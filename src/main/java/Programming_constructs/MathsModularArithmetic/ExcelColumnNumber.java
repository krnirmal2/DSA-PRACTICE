package Programming_constructs.MathsModularArithmetic;

public class ExcelColumnNumber {

    public static int titleToNumber(String A) {
        int asciiValue[] = new int[26];
        int startAsciiValue = 65;
        for(int i=0;i<26;i++){
            asciiValue[i]= startAsciiValue;
            startAsciiValue++;

        }

//        for( int i=0;i<asciiValue.length;i++)
//        {
//            System.out.println(asciiValue[i]);
//        }

        int sum =0;
        if(A.length()==1){
            for(int j=0;j<26;j++){
                System.out.println(asciiValue[j]);
                if(A.charAt(j)== asciiValue[j] ){
                    sum = 26 + ((asciiValue[j] % 26));
                    System.out.println(sum);
                }
            }}
        for(int i = 0;i<A.length();i++){
            for(int j=0;j<26;j++){
//                System.out.println(asciiValue[j]);
                if((int)A.charAt(i) == asciiValue[j] ){
                    sum = 26 + ((asciiValue[j] % 65))+1;
//                    System.out.println(sum);
                }
            }

        }
        return sum;
    }
    public static void main(String[] args) {
        String A = "BA";
//        int B =41;
        System.out.println(titleToNumber( A));

    }
}


