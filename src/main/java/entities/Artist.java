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
    private String instrument;
    private Integer age;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Album> album = new HashSet<>();

    public Artist() {}

    public Artist(Long id, String name, String instrument, Integer age) {
        this.id = id;
        this.name = name;
        this.instrument = instrument;
        this.age = age;
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

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Artist {" +
                "ID = " + id +
                ", Name = " + name +
                ", Birth Place = " + instrument +
                ", Birth Year = " + age +
                "}";
    }
}
