package LanguageMODULE;

class Book {

    static int count;
    int price;


    public Book(int price) {

        this.price = price;

        count++;

    }

}


public class MCQs {

    public static void main(String[] args) {

        System.out.print(Book.count + " ");

        Book b1 = new Book(500);

        Book b2 = new Book(600);

        System.out.println(Book.count);

    }

}
