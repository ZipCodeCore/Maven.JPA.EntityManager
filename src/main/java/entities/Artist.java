package entities;

import com.sun.javafx.beans.IDProperty;

public class Artist {

    private Long id;
    private String name;
    private String birthPlace;
    private Integer birthYear;

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
}
