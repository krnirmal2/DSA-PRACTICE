package LanguageMODULE;

//IB is an abstract class and it implements Scaler interface. Java allows abstract
//class to miss implementing
//                functions in interface. But since abstract class cannot be instantiated and its sub class implements its unimplemented functions. Hence, missing interface functions will also be implemented by sub class of IB’s sub class. In the run time, sub class’s object will execute getInfo().


interface Scaler1 {
    void myMethod();

    void getInfo();

}


abstract class ib implements Scaler1 {

    void getData() {
        System.out.println("IB");
    }
}

class InterFACE extends ib {
    public static void main(String[] args) {
        ib obj = new InterFACE();
        obj.getInfo();
    }

    public void myMethod() {
        System.out.println("InterviewBit");
    }

    public void getInfo() {
        System.out.println("Scaler");
    }
}