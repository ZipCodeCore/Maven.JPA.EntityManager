package entities;

import javax.persistence.*;

@Entity
@Table(name = "Artist")
public class Artist {



    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String stageName;
    int numOfAwards;

    public Artist(){

    }
    public Artist (Long id, String name, String stageName, int numOfAwards){
        this.id = id;
        this.name = name;
        this.stageName = stageName;
        this.numOfAwards = numOfAwards;
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

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public int getNumOfAwards() {
        return numOfAwards;
    }

    public void setNumOfAwards(int numOfAwards) {
        this.numOfAwards = numOfAwards;
    }



    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stageName='" + stageName + '\'' +
                ", numOfAwards=" + numOfAwards +
                '}';
    }
}
