package LanguageMODULE;

class Student {

    String name;

    int rollNo;


    // Constructor 1

    Student(int num) {

        rollNo = num;

        name = "abc";

    }


    // Constructor 2

    Student(int num, String str) {

        rollNo = num;

        name = str;

    }


    public void print() {

        System.out.print(name + " " + rollNo + " ");

    }

}


public class StudentUse {

    public static void main(String[] args) {

        Student s1 = new Student(101);

        s1.print();

        Student s2 = new Student(150, "xyz");

        s2.print();

    }

}