package exercitii.library;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book(2008, "Harry Potter", "fiction", "J.K.Rowling");
        Book book2 = new Book(2000, "Romeo and Juliet", "drama", "William Shakespeare");
        Book book3 = new Book(2012, "Foundation", "SF", "Isaac Asimov");
        Book book4 = new Book(2005, "Little woman", "drama", "Louisa May Alcott");
        Book book5 = new Book(2020, "Less", "comedy", "Sean Greer");

        Set<Book> bookSet = new HashSet<>();
        BookStore bookStore = new BookStore(bookSet);
        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);
        bookStore.addBook(book4);
        bookStore.addBook(book5);

        System.out.println(bookStore.getBooks());

        bookStore.deleteBook(book1);
        System.out.println(bookStore.getBooks());

        System.out.println(bookStore.getAllBooksOrderedByYear());

        System.out.println(bookStore.getAllGenres());

        System.out.println(bookStore.getAllBooksOrderedByAuthor());

        System.out.println(bookStore.getAllBooksByGenre());

        System.out.println(bookStore.getBooksByGenre("drama"));
    }
}
