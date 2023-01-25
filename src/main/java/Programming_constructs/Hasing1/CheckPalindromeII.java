package Programming_constructs.Hasing1;


public class CheckPalindromeII {
//    public int solve(String A) {
//        // thhree step
//        //  check that the length of the String A
//        // if odd then put in the hash and only one element having frequency one and other must be in even no. or
//        // all are same then only one element present in the hashmap and the frequency may be anything (means size
//        // of the hashmap will 1)
//        // if frequency of the no is even then every no. has even no  of pair
//
//        int result = 0;
//        // length of the String
//        int size = A.length();
//        // create a array of character
//        char s[] = A.toCharArray();
//        HashMap<Character, Integer > mp = new HashMap();
//        //for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//        // System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//        for(int i=0;i<size;i++){
//            if(mp.containsKey(s[i])){
//                mp.put(s[i], mp.get(s[i])+1);
//            }
//            else{
//                mp.put(s[i],1);
//            }
//        }
//
//        // now check the size of the hashmap
//       result =  mp.size()==1?1:0;
//        return result;
//        // now check that if the length of the string is odd
//        if(size %2 !=0){
//
//        }
//    }

    public static int solve(String A) {
        int[] freq = new int[26];
        int n = A.length();

        for(int i = 0; i < n; i++){
            char a = A.charAt(i);
            freq[a-'a']++;
        }

        boolean oneOdd = false;
        for(int i = 0; i < 26 ; i++){
            if((freq[i] % 2) != 0 && oneOdd)
                return 0;
            else if((freq[i] % 2) != 0 && !oneOdd)
                oneOdd = true;
        }
        return 1;
    }
//    public int solve(String A) {
//        int[] freq = new int[26];
//        for (int i = 0; i < A.length(); i++)
//            freq[A.charAt(i) - 97]++;
//        int odd = 0;
//        for (int a: freq)
//            if (a % 2 == 1)
//                odd++;
//        if (odd > 1)
//            return 0;
//        return 1;
//    }

    public static void main(String[] args) {
        solve("nirmal");
    }
}

