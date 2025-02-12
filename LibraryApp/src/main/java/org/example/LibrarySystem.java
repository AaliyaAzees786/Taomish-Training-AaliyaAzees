package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.Date;

public class LibrarySystem {
    private void printLogs(String errorDetails) {
        String fileName = "library_error_logs.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("\n=== Library System Error Log ===\n");
            writer.write("Timestamp: " + new Date() + "\n");
            writer.write(errorDetails);
            writer.write("\n=============================\n");

        } catch (IOException e) {
            System.err.println("Failed to write to library log file: " + e.getMessage());
        }
    }

    public void borrowBook(Book book, Member member)
            throws BookNotFoundException, BookAlreadyBorrowedException {
        try {
            // Validate inputs
            if (book == null || member == null) {
                throw new IllegalArgumentException("Book or member details are invalid");
            }

            // Check if book exists in library
            if (book.getIsbn() == null || book.getIsbn().trim().isEmpty()) {
                throw new BookNotFoundException("Book with ISBN not found in library system");
            }

            // Check if book is already borrowed
            if (!book.isAvailable()) {
                throw new BookAlreadyBorrowedException(
                        String.format("Book '%s' is already borrowed", book.getTitle())
                );
            }

            // Check if member has too many books (simulate a system error)
            if (member.getBorrowedBooks().size() >= 5) {
                throw new IOException("System error: Maximum borrowing limit reached");
            }

            // Process borrowing
            book.setAvailable(false);
            member.getBorrowedBooks().add(book);
            System.out.println("Book borrowed successfully!");
            System.out.printf("Book '%s' borrowed by %s%n", book.getTitle(), member.getName());

        } catch (IllegalArgumentException | BookNotFoundException |
                 BookAlreadyBorrowedException | IOException e) {
            // Print stack trace
            e.printStackTrace();

            // Get error message
            String errorMessage = e.getMessage();
            System.out.println("Borrowing Failed! Error: " + errorMessage);

            // Log error details
            String logMessage = String.format(
                    "Book Borrowing Failed!\nBook: %s (ISBN: %s)\nMember: %s (ID: %s)\n" +
                            "Error Type: %s\nError Message: %s\n" +
                            "Stack Trace:\n%s",
                    book != null ? book.getTitle() : "NULL",
                    book != null ? book.getIsbn() : "NULL",
                    member != null ? member.getName() : "NULL",
                    member != null ? member.getMemberId() : "NULL",
                    e.getClass().getSimpleName(),
                    errorMessage,
                    getStackTraceAsString(e)
            );

            printLogs(logMessage);

            // Rethrow specific exceptions
            if (e instanceof BookNotFoundException) {
                throw (BookNotFoundException) e;
            } else if (e instanceof BookAlreadyBorrowedException) {
                throw (BookAlreadyBorrowedException) e;
            }

        } finally {
            System.out.println("Borrowing process completed. Updating library records...");
        }
    }

    private String getStackTraceAsString(Exception e) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement element : e.getStackTrace()) {
            sb.append(element.toString()).append("\n");
        }
        return sb.toString();
    }
}
