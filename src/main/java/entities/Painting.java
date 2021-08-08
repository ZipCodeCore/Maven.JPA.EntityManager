package entities;

import javax.persistence.*;

@Entity
@Table(name = "Painting")
public class Painting {

    @Id
    private Long id;
    private String title;
    private String medium;
    private String artistName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "name", nullable = false)
    private Artist artist;

    public Painting(){}

    public Painting(Long id, String title, String medium, String artistName, Artist artist){
        this.id = id;
        this.title = title;
        this.medium = medium;
        this.artistName = artistName;
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

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public Artist getArtist() { return artist; }

    public void setArtist(Artist artist) { this.artist = artist; }

    @Override
    public String toString() {
        return "Painting {" +
                "ID = " + id +
                ", Title = " + title +
                ", Medium = " + medium +
                ", Artist = " + artistName +
                "}";
    }
}
