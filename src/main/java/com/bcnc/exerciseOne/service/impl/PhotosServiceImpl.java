package com.bcnc.exerciseOne.service.impl;

import com.bcnc.exerciseOne.bridge.PhotoBridge;
import com.bcnc.exerciseOne.entities.Photo;
import com.bcnc.exerciseOne.repository.PhotoRepository;
import com.bcnc.exerciseOne.service.PhotosService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotosServiceImpl  implements PhotosService {

    @Autowired
    private PhotoBridge restBridge;

    private ModelMapper modelMapper;
    @Autowired
    private PhotoRepository photoRepository;

    public PhotosServiceImpl() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<Photo> getRemotePhotos() {
        return restBridge.getPhotos().stream().map((element) -> modelMapper.map(element, Photo.class)).toList();
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
