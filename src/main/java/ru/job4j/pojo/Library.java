package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Gray Wolf", 10);
        Book book2 = new Book("Jack Sparrow", 100);
        Book book3 = new Book("Black Flag", 1000);
        Book book4 = new Book("Clean Code", 10000);

        Book[] books = new Book[4];

        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;

        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " have " + book.getPages() + " pages");
        }

        Book temp = books[3];
        books[3] = books[0];
        books[0] = temp;

        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " have " + book.getPages() + " pages");
        }

        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if (book.getName().equals("Clean Code")) {
                System.out.println(book.getName() + " have " + book.getPages() + " pages");
            }
        }
    }
}
