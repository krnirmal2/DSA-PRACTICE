package LanguageMODULE;

class test {
    void myMethod(){
        System.out.println("InterviewBit");
    }
}

public class Derived extends test {
    void myMethod(){
        System.out.println("IB");
    }

    public static void main(String[] args){
//        Derived object = new test(); Java doesn’t allow sub class’s reference to hold object of base class. Hence, it is illegal in java.
//        object.myMethod();
    }
}