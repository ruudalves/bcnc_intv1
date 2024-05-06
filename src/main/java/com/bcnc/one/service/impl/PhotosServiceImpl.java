package com.bcnc.one.service.impl;

import com.bcnc.one.bridge.PhotoBridge;
import com.bcnc.one.entities.Photo;
import com.bcnc.one.repository.PhotoRepository;
import com.bcnc.one.service.PhotosService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotosServiceImpl  implements PhotosService {

    private final PhotoBridge restBridge;
    private final ModelMapper modelMapper;
    private final PhotoRepository photoRepository;

    public PhotosServiceImpl(PhotoBridge restBridge, PhotoRepository photoRepository) {
        this.restBridge = restBridge;
        this.photoRepository = photoRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<Photo> getRemotePhotos() {
        return restBridge.getPhotos().stream().map(element -> modelMapper.map(element, Photo.class)).toList();
    }

    @Override
    public List<Photo> getAllFromDB() {
        return photoRepository.findAll();
    }

    @Override
    public List<Photo> saveAllRemote() {
        List<Photo> photoList = getRemotePhotos();
        photoRepository.saveAll(photoList);
        return photoList;
    }
}
