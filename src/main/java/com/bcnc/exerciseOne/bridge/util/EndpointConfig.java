package com.bcnc.exerciseOne.bridge.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class EndpointConfig {

    @Configuration
    @PropertySource({"classpath:endpoint.properties"})
    static class EndpointLocalConfig{

    }

    @Value("${endpoint.album}")
    private String albumEndpoint;

    @Value("${endpoint.photos}")
    private String photosEndpoint;

    public String getAlbumEndpoint() {
        return albumEndpoint;
    }

    public String getPhotosEndpoint() {
        return photosEndpoint;
    }
}
