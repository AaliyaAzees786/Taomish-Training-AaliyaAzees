package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        Book book1 = new Book("ISBN001", "The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("ISBN002", "1984", "George Orwell");
        Book book3 = new Book("ISBN003", "Pride and Prejudice", "Jane Austen");

        Member member1 = new Member("M001", "John Doe");
        Member member2 = new Member("M002", "Jane Smith");

        try {

            System.out.println("\nScenario 1: Successful borrowing");
            library.borrowBook(book1, member1);


            System.out.println("\nScenario 2: Already borrowed book");
            library.borrowBook(book1, member2);

        } catch (BookNotFoundException | BookAlreadyBorrowedException e) {
            System.out.println("Main: Borrowing failed: " + e.getMessage());
        }

        try {

            System.out.println("\nScenario 3: Invalid book");
            library.borrowBook(null, member1);

        } catch (BookNotFoundException | BookAlreadyBorrowedException e) {
            System.out.println("Main: Borrowing failed: " + e.getMessage());
        }


        for (int i = 0; i < 5; i++) {
            member2.getBorrowedBooks().add(new Book("ISBN" + i, "Book" + i, "Author" + i));
        }

        try {

            System.out.println("\nScenario 4: Maximum borrowing limit");
            library.borrowBook(book2, member2);

        } catch (BookNotFoundException | BookAlreadyBorrowedException e) {
            System.out.println("Main: Borrowing failed: " + e.getMessage());
        }
    }
}