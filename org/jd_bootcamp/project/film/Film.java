package org.jd_bootcamp.project.film;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Film {

    // region fields
    private String id;
    private String title;
    private String director;
    private List<String> actors;
    private String date;
    private String description;
    private FilmType type;

    //endregion

    //region Getter&Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    //endregion
    public Film() {
    }

    public Film(String title, String director, List<String> actors, String date, String description, FilmType type) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.director = director;
        this.actors = actors;
        this.date = date;
        this.description = description;
        this.type = type;
    }

    @Override
    public String toString() {
        return  "\n\tID = " + id +
                "\n\tTitle = '" + title + '\'' +
                "\n\tDirector = " + director +
                "\n\tActors = " + actors +
                "\n\tDate = " + date +
                "\n\tDescription = '" + description + '\'' +
                "\n\tType = '" + type + '\'' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(id, film.id) && Objects.equals(title, film.title) && Objects.equals(director, film.director) && Objects.equals(actors, film.actors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, director, actors);
    }
}