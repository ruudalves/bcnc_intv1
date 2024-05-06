package com.bcnc.one.bridge.impl;

import com.bcnc.one.bridge.AlbumBridge;
import com.bcnc.one.bridge.util.Bridge;
import com.bcnc.one.bridge.util.EndpointConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
@Service
public class AlbumBridgeImpl implements AlbumBridge {

    @Autowired
    private Bridge bridge;
    @Autowired
    private EndpointConfig endpointConfig;

    @Override
    public List<LinkedHashMap> getList() {
        return bridge.getList(endpointConfig.getAlbumEndpoint(), new ParameterizedTypeReference<>() {
        });
    }
}
