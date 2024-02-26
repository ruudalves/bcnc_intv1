package com.bcnc.exerciseOne.service;

import com.bcnc.exerciseOne.entities.Album;

import java.util.List;

public interface AlbumsService {
    List<Album> saveAllRemote();

    List<Album> getRemoteAlbums();

    List<Album> getAllFromDB();
}
