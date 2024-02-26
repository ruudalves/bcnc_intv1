package com.bcnc.exerciseOne.resource;

import com.bcnc.exerciseOne.entities.Album;
import com.bcnc.exerciseOne.service.AlbumsService;
import com.bcnc.exerciseOne.service.PhotosService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private AlbumsService albumsService;
    @Autowired
    private PhotosService photosService;
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
