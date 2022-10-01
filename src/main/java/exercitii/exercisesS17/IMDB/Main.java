package exercitii.exercisesS17.IMDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //TODO: de ce imi spune ca lista de review e null(a)??
        List<String> cast1 = Arrays.asList("Leonardo DiCaprio", "Kate Winslet", "Billy Zane");
        List<Review> reviews1 = Arrays.asList(Review.FOUR_STARS, Review.FIVE_STARS, Review.FOUR_STARS);
        Movie movie1 = new Movie("Titanic", 1997, Genre.DRAMA, cast1, Type.MOVIE, reviews1);

        List<String> cast2 = Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Cillian Murphy", "Marion Cotillard");
        List<Review> reviews2 = Arrays.asList(Review.FOUR_STARS, Review.THREE_STARS, Review.FOUR_STARS);
        Movie movie2 = new Movie("Inception", 2010, Genre.ACTION, cast2, Type.MOVIE, reviews2);

        List<String> cast3 = Arrays.asList("Eugenio Derbez", "Samara Weaving", "Marisol Nichols");
        List<Review> reviews3 = Arrays.asList(Review.TWO_STARS, Review.THREE_STARS, Review.TWO_STARS);
        Movie movie3 = new Movie("The Valet", 2022, Genre.COMEDY, cast3, Type.MOVIE, reviews3);

        List<String> cast4 = Arrays.asList("Sam Worthington", "Zoe Saldana", "Sigourney Weaver", "Kate Winslet");
        List<Review> reviews4 = Arrays.asList(Review.FOUR_STARS, Review.FIVE_STARS, Review.THREE_STARS);
        Movie movie4 = new Movie("Avatar", 2022, Genre.ACTION, cast4, Type.MOVIE, reviews4);

        List<Movie> movieList = new ArrayList<>();
        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);
        movieList.add(movie4);
        IMDBService imdbService = new IMDBService(movieList);

        System.out.println("Movies by genre" + imdbService.getAllMoviesByGenre());
        System.out.println("All films in which a certain actor plays" + imdbService.getAllFilmsInWhichACertainActorPlays("Leonardo DiCaprio"));
        System.out.println("Movies ordered by release year" + imdbService.getAllMoviesOrderedByReleaseYear());
        System.out.println("All actors who played in films of a certain type and genre" + imdbService.getAllActorsWhoPlayedInFilmsOfACertainTypeAndGenre(Type.MOVIE, Genre.ACTION));
        System.out.println("Java8 - All actors who played in films of a certain type and genre" + imdbService.findAllActorsWhoPlayedInFilmsOfACertainTypeAndGenre(Type.MOVIE, Genre.ACTION));
        System.out.println("All movies descending ordered by average review " + imdbService.getMoviesReversOrderedByAverageReview(movieList));

        System.out.println("The actor who played in the most movies is: " + imdbService.getActorWhoPlayedInTheMostMovies());
    }
}
