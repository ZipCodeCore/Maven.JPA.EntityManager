package main;

import entities.Artist;
import entities.Painting;
import services.ArtistService;
import services.PaintingService;
import java.util.ArrayList;
import java.util.List;

public class NewMainApp {

    public static void main(String[] args) {

        ArtistService artistService = new ArtistService();
        PaintingService paintingService = new PaintingService();
        List<Artist> artistList = new ArrayList<>();
        List<Painting> paintingList = new ArrayList<>();

        Artist vanGogh = new Artist(1L, "Vincent van Gogh", "Netherlands", 1853);
        Artist hopper = new Artist(2L, "Edward Hopper", "New York", 1882);
        artistList.add(vanGogh);
        artistList.add(hopper);

        Painting almondBlossom = new Painting(1L, "Almond Blossom", "oil", "Vincent van Gogh", vanGogh);
        Painting nightHawks = new Painting(2L, "NightHawks", "oil", "Edward Hopper", hopper);
        paintingList.add(almondBlossom);
        paintingList.add(nightHawks);


        //CREATE
        artistService.createMultiple(artistList);
        paintingService.createMultiple(paintingList);


        //READ
        Artist artist1 = artistService.findById(1L);
        Artist artist2 = artistService.findById(2L);
        System.out.println(artist1.toString());
        System.out.println(artist2.toString());

        Painting painting1 = paintingService.findById(1L);
        Painting painting2 = paintingService.findById(2L);
        System.out.println(painting1.toString());
        System.out.println(painting2.toString());

    }
}
