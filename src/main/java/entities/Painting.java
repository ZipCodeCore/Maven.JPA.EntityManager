package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Painting {

    @Id
    private Long id;
    private String title;
    private String medium;
    private String artist;

    public Painting(){}

    public Painting(Long id, String title, String medium, String artist){
        this.id = id;
        this.title = title;
        this.medium = medium;
        this.artist = artist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Painting {" +
                "ID = " + id +
                ", Title = " + title +
                ", Medium = " + medium +
                ", Artist = " + artist +
                "}";
    }
}
