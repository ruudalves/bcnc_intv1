package com.bcnc.one.service;

import com.bcnc.one.entities.Album;

import java.util.List;

public interface AlbumsService {
    List<Album> saveAllRemote();

    List<Album> getRemoteAlbums();

    List<Album> getAllFromDB();
}
