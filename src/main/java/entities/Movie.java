package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "movie")
public class Movie
{
    Long id;
    String title;
    LocalDate releaseDate;
    String director;
    @ManyToMany
//    @JoinTable(name = "CAST",
//            joinColumns=@JoinColumn(name="movie_id"),
//            inverseJoinColumns=@JoinColumn(name="actor_id"))
    Set<Actor> cast;
    String summary;

    public Movie()
    {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public LocalDate getReleaseDate()
    {
        return this.releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    public String getDirector()
    {
        return this.director;
    }

    public void setDirector(String director)
    {
        this.director = director;
    }

    public Set<Actor> getCast()
    {
        return this.cast;
    }

    public void setCast(Set<Actor> cast)
    {
        this.cast = cast;
    }

    public String getSummary()
    {
        return this.summary;
    }

    public void setSummary(String summary)
    {
        this.summary = summary;
    }
}
