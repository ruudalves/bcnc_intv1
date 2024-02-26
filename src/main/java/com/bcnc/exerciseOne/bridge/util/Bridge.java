package com.bcnc.exerciseOne.bridge.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Bridge {

    <T> List<T> getList(String url, ParameterizedTypeReference<List<T>> response);

    @Autowired
    default EndpointConfig getEndpointConfig() {
        return new EndpointConfig();
    }
}
