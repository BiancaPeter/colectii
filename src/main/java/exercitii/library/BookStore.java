package exercitii.library;

import java.util.*;
import java.util.stream.Collectors;

public class BookStore {
    private Set<Book> books = new HashSet<>();

    public BookStore(Set<Book> bookSet) {
        this.books = bookSet;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "bookSet=" + books +
                '}';
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void deleteBook(Book book) {
        books.remove(book);
    }

    public List<Book> getAllBooksOrderedByYear() {
        List<Book> allBooksOrderedByYear = new ArrayList<>(); //am creat o lista in care am introdus setul
        allBooksOrderedByYear.addAll(books);                   //pentru a apela metoda Collections.sort()
        Collections.sort(allBooksOrderedByYear);                //aceasta metoda poate fi apelata pe List (si nu pe Set)
        return allBooksOrderedByYear;
    }


    public Set<String> getAllGenres() {
        return books.stream()
                .map(book -> book.getGenre())
                .collect(Collectors.toSet());
    }

    public Set<Book> getAllBooksOrderedByAuthor() {
        Set<Book> allBooksOrderedByAuthor = new TreeSet<>(new AuthorComparator());
        allBooksOrderedByAuthor.addAll(books);
        return allBooksOrderedByAuthor;
    }


    public Map<String, Set<Book>> getAllBooksByGenre() {
        Map<String, Set<Book>> allBooksByGenre = new HashMap<>();
        for (Book book : books) {
            if (!allBooksByGenre.containsKey(book.getGenre())) {
                Set<Book> list = new HashSet<>();
                list.add(book);
                allBooksByGenre.put(book.getGenre(), list);
            } else {
                allBooksByGenre.get(book.getGenre()).add(book);
            }
        }
        return allBooksByGenre;
    }

    public Set<Book> getBooksByGenre(String genre) {
        Map<String, Set<Book>> allBooksByGenre = getAllBooksByGenre();
        Set<Book> booksByGenre = new HashSet<>();
        if (allBooksByGenre.containsKey(genre)) {
            booksByGenre = allBooksByGenre.get(genre);
        }
        return booksByGenre;
    }
}
