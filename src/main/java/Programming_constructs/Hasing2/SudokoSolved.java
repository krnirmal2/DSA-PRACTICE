package Programming_constructs.Hasing2;

import java.util.HashSet;

public class SudokoSolved {
//    public static int isValidSudoku(final String[] A) {
//    for(int i=0;i<9;i++){
//        for(int j=0;j<9;j++){
//            char ch=A[i].charAt(j);
//            if(ch !='.'){
//                for(int k=0;k<9;k++){
//                    // row--wise check
//                    if(k!=j && A[i].charAt(k)==ch){
//                        return 0;
//                    }
//                    // column - wise check
//                    if(k!=i && A[k].charAt(j)==ch){
//                        return 0;
//                    }
//                }
//                // check in cube
//                int r1,r2,c1,c2;
//                if(i/3==0){r1=0;r2=2;}
//                else if(i/3==1){r1=3;r2=5;}
//                else{r1=6;r2=8;}
//                if(j/3==0){c1=0;c2=2;}
//                else if(j/3==1){c1=3;c2=5;}
//                else{c1=6;c2=8;}
//
//                for(int k=r1;k<r2;k++){
//                    for(int l=c1;l<c2;l++){
//                        if(k!=i && l!=j && A[k].charAt(l)==ch){
//                            return 0;
//                        }
//                    }
//                }
//            }
//        }
//    }
//    return 1;
//
//
//}

    public static int isValidSudoku(final String[] A) {
        HashSet<Character>[] row = new HashSet[9];
        HashSet<Character>[] col = new HashSet[9];
        HashSet<Character>[][] box = new HashSet[3][3];
        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                box[i][j] = new HashSet<>();
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = A[i].charAt(j);
                if (c == '.') {
                    continue;
                }

                // if row contain element then return or otherwise add to row set
                if (row[i].contains(c)) {
                    return 0;
                }
                row[i].add(c);

                // if colmn contain character then reudrn or otherwise add it to coloumn set
                if (col[j].contains(c)) {
                    return 0;
                }
                col[j].add(c);

                // check it in 3*3 subarray if the element present or not
                if (box[i / 3][j / 3].contains(c)) {
                    return 0;
                }
                box[i / 3][j / 3].add(c);
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        String[] s = {"53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"};


//        System.out.println(isValidSudoku(new ArrayList<>(List.of("53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"))));
        System.out.println(isValidSudoku(s));


    }
}
