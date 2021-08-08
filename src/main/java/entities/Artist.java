package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Artist")
public class Artist {

    @Id
    private Long id;
    private String name;
    private String birthPlace;
    private Integer birthYear;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Painting> painting = new HashSet<>();

    public Artist() {}

    public Artist(Long id, String name, String birthPlace, Integer birthYear) {
        this.id = id;
        this.name = name;
        this.birthPlace = birthPlace;
        this.birthYear = birthYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return "Artist {" +
                "ID = " + id +
                ", Name = " + name +
                ", Birth Place = " + birthPlace +
                ", Birth Year = " + birthYear +
                "}";
    }
}
