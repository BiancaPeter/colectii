package exercitii.exercisesS17.IMDB;

import java.util.*;
import java.util.stream.Collectors;

public class IMDBService {
    private List<Movie> movieList;

    public IMDBService(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    //generez o mapa cu chei genre si valori liste de filme
    public Map<Genre, List<Movie>> getAllMoviesByGenre() {
        Map<Genre, List<Movie>> moviesByGenre = new HashMap<>();
        for (Movie movie : movieList) {
            if (!moviesByGenre.containsKey(movie.getGenre())) {
                List<Movie> movies = new ArrayList<>();
                movies.add(movie);
                moviesByGenre.put(movie.getGenre(), movies);
            } else {
                moviesByGenre.get(movie.getGenre()).add(movie);
            }
        }
        return moviesByGenre;
    }

    public List<Movie> getAllFilmsInWhichACertainActorPlays(String actorFound) {
        List<Movie> allFilmsInWhichACertainActorPlays = new ArrayList<>();
        for (Movie movie : movieList) {
            for (String actor : movie.getCast()) {
                if (actorFound.equals(actor)) {
                    allFilmsInWhichACertainActorPlays.add(movie);
                }
            }
        }
        return allFilmsInWhichACertainActorPlays;
    }

    //TODO: cum colectez filmele???
//    public List<Movie> findAllFilmsInWhichACertainActorPlays(String actorFound) {
//        return movieList.stream()
//                .flatMap(movie -> movie.getCast().stream())
//                .filter(actor -> actor.equals(actorFound))
//                .
//    }

    public List<Movie> getAllMoviesOrderedByReleaseYear() {
        List<Movie> allMoviesOrderedByReleaseYear = new ArrayList<>();
        allMoviesOrderedByReleaseYear.addAll(movieList);
        Collections.sort(allMoviesOrderedByReleaseYear);
        return allMoviesOrderedByReleaseYear;
    }

    public List<String> getMoviesReversOrderedByAverageReview(List<Movie> movieList) {
//        List<Movie>moviesOrderedByAverageReview=new ArrayList<>();
//        moviesOrderedByAverageReview.addAll(movieList);
//        moviesOrderedByAverageReview.sort(Comparator.comparingDouble(Movie::getAverageReviewValueForMovie));
//        return moviesOrderedByAverageReview;
        return movieList.stream()
                .sorted(Comparator.comparingDouble(Movie::getAverageReviewValueForMovie).reversed()).map(movie -> movie.getTitle() + " " + movie.getReviewAverage()).collect(Collectors.toList());
    }


    public Set<String> getAllActorsWhoPlayedInFilmsOfACertainTypeAndGenre(Type typeFound, Genre genreFound) {
        Set<String> allActorsWhoPlayedInFilmsOfACertainTypeAndGenre = new HashSet<>();
        for (Movie movie : movieList) {
            if ((movie.getType().equals(typeFound)) && (movie.getGenre().equals(genreFound))) {
                allActorsWhoPlayedInFilmsOfACertainTypeAndGenre.addAll(movie.getCast());
            }
        }
        return allActorsWhoPlayedInFilmsOfACertainTypeAndGenre;
    }

    public Movie getTheMostAppreciatedMovieOfACertainTypeAndGenre(Type typeFound, Genre genreFound) {
        Movie theMostAppreciatedMovieOfACertainTypeAndGenre = null;
        double max = 0;
        for (Movie movie : movieList) {
            if (movie.getGenre().equals(genreFound) && movie.getType().equals(typeFound) && movie.getReviewAverage() > max) {
                theMostAppreciatedMovieOfACertainTypeAndGenre = movie;
                max = movie.getAverageReviewValueForMovie();
            }
        }
        return theMostAppreciatedMovieOfACertainTypeAndGenre;
    }

    //todo: cum verific partea de max cu java8?
//    public Movie findTheMostAppreciatedMovieOfACertainTypeAndGenre(Type typeFound, Genre genreFound) {
//        return movieList.stream()
//                .filter(movie -> (movie.getGenre()).equals(genreFound) && movie.getType().equals(typeFound))
//
//    }

    // Java8
    public List<String> findAllActorsWhoPlayedInFilmsOfACertainTypeAndGenre(Type typeFound, Genre genreFound) {
        return movieList.stream()
                .filter(movie -> (movie.getGenre()).equals(genreFound) && movie.getType().equals(typeFound))
                .flatMap(movie -> movie.getCast().stream())
                .collect(Collectors.toList());
    }

    public Map<String, Integer> getActorsByNumberOfApparitions() {
        Map<String, Integer> actorsByNumberOfApparitions = new HashMap<>();
        for (Movie movie : movieList) {
            for (String actor : movie.getCast()) {
                if (!actorsByNumberOfApparitions.containsKey(actor)) {
                    actorsByNumberOfApparitions.put(actor, 1);
                } else {
                    actorsByNumberOfApparitions.put(actor, actorsByNumberOfApparitions.get(actor) + 1);
                }
            }
        }
        return actorsByNumberOfApparitions;
    }

    public String getActorWhoPlayedInTheMostMovies() {
        Map<String, Integer> actorsByNumberOfApparitions = getActorsByNumberOfApparitions();
        int max = 0;
        String foundActor = "";
        for (String actor : actorsByNumberOfApparitions.keySet()) {
            if (actorsByNumberOfApparitions.get(actor) > max) {
                max = actorsByNumberOfApparitions.get(actor);
                foundActor = actor;
            }
        }
        return foundActor;
    }


}


