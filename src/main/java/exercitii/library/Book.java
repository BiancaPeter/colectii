package exercitii.library;

import demo.comparingcollections.Coin;

public class Book implements Comparable<Book>{
    private int year;
    private String title;
    private String genre;
    private String author;

    public Book(int year, String title, String genre, String author) {
        this.year = year;
        this.title = title;
        this.genre = genre;
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "year='" + year + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", author='" + author + '\'' +
                '}';
    }


    @Override
    public int compareTo(Book anotherBook) {
        return Integer.compare(year,anotherBook.getYear());
    }
}
