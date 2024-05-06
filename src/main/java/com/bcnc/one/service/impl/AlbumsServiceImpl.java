package com.bcnc.one.service.impl;

import com.bcnc.one.bridge.AlbumBridge;
import com.bcnc.one.entities.Album;
import com.bcnc.one.entities.Photo;
import com.bcnc.one.repository.AlbumRepository;
import com.bcnc.one.service.AlbumsService;
import com.bcnc.one.service.PhotosService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumsServiceImpl implements AlbumsService {


    private final AlbumRepository albumRepository;


    private AlbumBridge restBridge;

    private final ModelMapper modelMapper;


    private PhotosService photosService;

    public AlbumsServiceImpl(AlbumRepository albumRepository, AlbumBridge albumBridge, PhotosService photosService){
        this.albumRepository = albumRepository;
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
