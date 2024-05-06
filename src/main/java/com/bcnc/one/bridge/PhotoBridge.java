package com.bcnc.one.bridge;

import com.bcnc.one.service.dto.PhotoDto;

import java.util.LinkedHashMap;
import java.util.List;

public interface PhotoBridge {

    List<LinkedHashMap> getPhotos();
}
