package com.bcnc.exerciseOne.bridge.impl;

import com.bcnc.exerciseOne.bridge.PhotoBridge;
import com.bcnc.exerciseOne.bridge.util.Bridge;
import com.bcnc.exerciseOne.bridge.util.EndpointConfig;
import com.bcnc.exerciseOne.service.dto.PhotoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PhotoBridgeImpl implements PhotoBridge {

    @Autowired
    private Bridge bridge;
    @Autowired
    private EndpointConfig endpointConfig;

    @Override
    public List<PhotoDto> getPhotos() {
        return bridge.getList(endpointConfig.getPhotosEndpoint(), new ParameterizedTypeReference<>() {
        });
    }
}
