package entities;

import javax.persistence.*;

@Entity
@Table(name = "Album")
public class Album {

    @Id
    private Long id;
    private String title;
    private String genre;
    private String artistName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "name", nullable = false)
    private Artist artist;

    public Album(){}

    public Album(Long id, String title, String genre, String artistName, Artist artist){
        this.id = id;
        this.title = title;
        this.genre = genre;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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
                ", Medium = " + genre +
                ", Artist = " + artistName +
                "}";
    }
}
