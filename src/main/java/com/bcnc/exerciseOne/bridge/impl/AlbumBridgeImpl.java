package com.bcnc.exerciseOne.bridge.impl;

import com.bcnc.exerciseOne.bridge.AlbumBridge;
import com.bcnc.exerciseOne.bridge.util.Bridge;
import com.bcnc.exerciseOne.bridge.util.EndpointConfig;
import com.bcnc.exerciseOne.service.dto.AlbumDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlbumBridgeImpl implements AlbumBridge {

    @Autowired
    private Bridge bridge;
    @Autowired
    private EndpointConfig endpointConfig;

    @Override
    public List<AlbumDto> getList() {
        return bridge.getList(endpointConfig.getAlbumEndpoint(), new ParameterizedTypeReference<>() {
        });
    }
}
