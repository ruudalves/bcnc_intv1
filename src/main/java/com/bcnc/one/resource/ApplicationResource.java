package com.bcnc.one.resource;

import com.bcnc.one.entities.Album;
import com.bcnc.one.service.AlbumsService;
import com.bcnc.one.service.PhotosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApplicationResource {


    private final AlbumsService albumsService;

    private final PhotosService photosService;

    public ApplicationResource(AlbumsService albumsService, PhotosService photosService) {
        this.albumsService = albumsService;
        this.photosService = photosService;
    }


    @PostMapping("/save")
    public ResponseEntity<List<Album>> saveInH2(){
        photosService.saveAllRemote();
        return ResponseEntity.of(Optional.ofNullable(albumsService.saveAllRemote()));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Album>> displayAlbumsEnhanced(){
        albumsService.getRemoteAlbums();
        return ResponseEntity.of(Optional.ofNullable(albumsService.getRemoteAlbums()));
    }

    @GetMapping("/*")
    public ResponseEntity<List<Album>> getAlbums(){
        return ResponseEntity.of(Optional.ofNullable(albumsService.getAllFromDB()));
    }
}
