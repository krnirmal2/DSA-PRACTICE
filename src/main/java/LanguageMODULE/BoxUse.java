package LanguageMODULE;

class Box{

    int width;

    int height;

    int length;

    void volume(){

        System.out.println(length * width * height);

    }

}


public class BoxUse {

    public static void main(String[] args) {
//To solve this question, keep in mind that uninitialised data members are given default value.
        Box b = new Box();

        b.height = 5;

        b.width = 4;

        b.volume();

    }

}