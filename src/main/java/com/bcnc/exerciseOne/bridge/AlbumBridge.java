package com.bcnc.exerciseOne.bridge;

import com.bcnc.exerciseOne.service.dto.AlbumDto;

import java.util.List;


public interface AlbumBridge {
    List<AlbumDto> getList();
}
