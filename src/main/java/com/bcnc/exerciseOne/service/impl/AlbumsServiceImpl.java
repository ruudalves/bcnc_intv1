package com.bcnc.exerciseOne.service.impl;

import com.bcnc.exerciseOne.bridge.AlbumBridge;
import com.bcnc.exerciseOne.entities.Album;
import com.bcnc.exerciseOne.entities.Photo;
import com.bcnc.exerciseOne.repository.AlbumRepository;
import com.bcnc.exerciseOne.service.AlbumsService;
import com.bcnc.exerciseOne.service.PhotosService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@EnableTransactionManagement
@Transactional
public class AlbumsServiceImpl implements AlbumsService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private AlbumBridge restBridge;


    private final ModelMapper modelMapper;

    @Autowired
    private PhotosService photosService;

    public AlbumsServiceImpl(){
        this.modelMapper = new ModelMapper();
    }


    public AlbumsServiceImpl(AlbumBridge albumBridge, PhotosService photosService){
        this.restBridge = albumBridge;
        this.modelMapper = new ModelMapper();
        this.photosService = photosService;
    }

    @Override
    public List<Album> saveAllRemote() {
        List<Album> albumList = getRemoteAlbums();
        for (Album album : albumList){
            albumRepository.save(album);
        }
        return albumList;
    }

    @Override
    public List<Album> getRemoteAlbums() {
        List<Photo> photos = photosService.getRemotePhotos();
        List<Album> albums = restBridge.getList().stream().map(element -> modelMapper.map(element, Album.class)).toList();
        albums.forEach(album -> {
            for(Photo photo: photos){
                if(photo.getAlbumId()==album.getId()) album.getPhotos().add(photo);
            }
        });
        return albums;
    }

    @Override
    public List<Album> getAllFromDB() {
        return albumRepository.findAll();
    }
}
