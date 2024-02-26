package com.bcnc.exerciseOne.bridge;

import com.bcnc.exerciseOne.service.dto.PhotoDto;

import java.util.List;

public interface PhotoBridge {

    List<PhotoDto> getPhotos();
}
