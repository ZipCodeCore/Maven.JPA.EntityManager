package entities;


import javax.persistence.*;

@Entity
@Table(name = "Album")
public class Album {

    @Id
    Long id;
    String name;
    int numberOfSongs;
    int price;

    private Long elId;
    @ManyToOne
    @JoinColumn(name = "elId", referencedColumnName = "id", insertable = false, updatable = false)
    private Artist a;

    public Album(){
    }

    public Album(Long id, String name, int numberOfSongs, int price) {
        this.id = id;
        this.name = name;
        this.numberOfSongs = numberOfSongs;
        this.price = price;
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

    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", numberOfSongs=" + numberOfSongs +
                ", price=" + price +
                '}';
    }
}
