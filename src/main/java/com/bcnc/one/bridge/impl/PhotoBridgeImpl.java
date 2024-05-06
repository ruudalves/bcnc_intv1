package com.bcnc.one.bridge.impl;

import com.bcnc.one.bridge.PhotoBridge;
import com.bcnc.one.bridge.util.Bridge;
import com.bcnc.one.bridge.util.EndpointConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
@Service
public class PhotoBridgeImpl implements PhotoBridge {

    @Autowired
    private Bridge bridge;
    @Autowired
    private EndpointConfig endpointConfig;

    @Override
    public List<LinkedHashMap> getPhotos() {
        return bridge.getList(endpointConfig.getPhotosEndpoint(), new ParameterizedTypeReference<>() {
        });
    }
}
