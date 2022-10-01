package exercitii.exercisesS17.IMDB;

import java.util.List;

public class Movie implements Comparable<Movie> {
    private String title;
    private Integer releaseYear;
    private Genre genre;
    private List<String> cast;
    private Type type;
    private List<Review> reviews;
    private Double reviewAverage = getAverageReviewValueForMovie();


    public Movie(String title, Integer releaseYear, Genre genre, List<String> cast, Type type, List<Review> reviews) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.cast = cast;
        this.type = type;
        this.reviews = reviews;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Double getReviewAverage() {
        return reviewAverage;
    }

    public void setReviewAverage(Double reviewAverage) {
        this.reviewAverage = reviewAverage;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", genre=" + genre +
                ", cast=" + cast +
                ", type=" + type +
                ", reviews=" + reviews +
                '}';
    }

    @Override
    public int compareTo(Movie anotherMovie) {
        return Integer.compare(releaseYear, anotherMovie.releaseYear);
    }

    public double getAverageReviewValueForMovie() {
        int sum = 0;
        for (Review review : reviews) {
            sum += review.reviewValue;
        }
        return sum / reviews.size();
    }
}
