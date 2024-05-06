package com.bcnc.one.service;

import com.bcnc.one.entities.Photo;

import java.util.List;

public interface PhotosService {
    List<Photo> getRemotePhotos();

    List<Photo> getAllFromDB();

    List<Photo> saveAllRemote();
}
