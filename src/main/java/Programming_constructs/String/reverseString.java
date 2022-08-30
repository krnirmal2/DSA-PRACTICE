package Programming_constructs.String;

public class reverseString {

        // take the string and then put it in character arrray
        // reverse the whole string from 0 to n-1
        // now take each word by start from 0 if no space starting other wise start from the initial letter and go
        // upto if not found space and reverese this word

        // function for reverse the start to end index of an arrray
        public static char[] revereseString(int start, int end, char stringToCharArray[]){
            while(start<end) {
                char temp = stringToCharArray[start];
                stringToCharArray[start] = stringToCharArray[end];
                stringToCharArray[end] = temp;
                start++;
                end--;
            }
            return stringToCharArray;
        }


        public static String solve(String A)
        {
            String removeSpaces = A.replaceAll("\\s+", " ");

            char stringToCharArray[] =  removeSpaces.trim().toCharArray();
            //
            int j = stringToCharArray.length-1, i=0;
            String result = "";
//            for( ; i<j; i++,j--){
            revereseString(i, j, stringToCharArray);


//        }

            int temp = -1;
            int k=0;
            for( ; k<stringToCharArray.length; k++){
                if(stringToCharArray[k]== ' '){
                    revereseString(temp+1, k-1, stringToCharArray);
                    temp =k;
                    //  if(i>=0 && j<stringToCharArray.length-1)

                }


            }
            revereseString(temp+1, k-1, stringToCharArray);

            for( int l =0; l<stringToCharArray.length; l++){
                result+=stringToCharArray[l];


            }
            return result;
        }

    public static void main(String[] args) {
        System.out.println(solve("crulgzfkif gg ombt vemmoxrgf qoddptokkz op xdq hv "));

    }

}



