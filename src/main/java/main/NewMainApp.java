package main;

import entities.Artist;
import entities.Album;
import services.ArtistService;
import services.AlbumService;
import java.util.ArrayList;
import java.util.List;

public class NewMainApp {

    public static void main(String[] args) {

        ArtistService artistService = new ArtistService();
        AlbumService albumService = new AlbumService();
        List<Artist> artistList = new ArrayList<>();
        List<Album> albumList = new ArrayList<>();

        Artist artist1 = new Artist(1L, "Dippity", "Triangle", 20);
        Artist artist2 = new Artist(2L, "Pandotopanzanite", "Vocals", 45);
        artistList.add(artist1);
        artistList.add(artist2);

        Album album1 = new Album(1L, "All Them Dips", "Hip Hop", "Dippity", artist1);
        Album album2 = new Album(2L, "Gems", "Rock", "Pandotopanzanite", artist2);
        albumList.add(album1);
        albumList.add(album2);


        //CREATE
        artistService.createMultiple(artistList);
        albumService.createMultiple(albumList);


        //READ
        Artist art1 = artistService.findById(1L);
        Artist art2 = artistService.findById(2L);
        System.out.println(art1.toString());
        System.out.println(art2.toString());

        Album alb1 = albumService.findById(1L);
        Album alb2 = albumService.findById(2L);
        System.out.println(alb1.toString());
        System.out.println(alb2.toString());

    }
}
