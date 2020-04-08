package entities;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(
        name = "movie",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"title", "releaseDate"})}
)
public class Movie
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private LocalDate releaseDate;
    private String director;
    @ManyToMany(cascade =
            {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "movie_cast",
        joinColumns = {@JoinColumn(name = "movie_id")},
        inverseJoinColumns = {@JoinColumn(name = "actor_id")}
    )
    private Set<Actor> cast;
    String summary;

    public Movie()
    {
    }

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

    @Override
    public int hashCode()
    {
        return Objects.hash(this.getTitle());
    }
}
