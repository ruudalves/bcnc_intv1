package com.bcnc.exerciseOne.service;

import com.bcnc.exerciseOne.entities.Photo;

import java.util.List;

public interface PhotosService {
    List<Photo> getRemotePhotos();

    List<Photo> getAllFromDB();

    List<Photo> saveAllRemote();
}
