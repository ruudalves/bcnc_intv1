package com.bcnc.one.bridge.util;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;
@Service
public class RestBridgeHttps implements Bridge{

    @Override
    public <T> List<T> getList(String url, ParameterizedTypeReference<List<T>> response) {

        List<T> t;
        RestClient restClient = RestClient.builder().baseUrl(url).build();

        ResponseEntity<List> responseList = restClient.get().retrieve().toEntity(List.class);
        if (responseList.getStatusCode().equals(HttpStatus.OK)) {
            t = responseList.getBody();
        } else if (responseList.getStatusCode().equals(HttpStatus.NO_CONTENT)) {
            t = new ArrayList<>();
        } else {
            throw new RuntimeException(String.valueOf(responseList.getStatusCode()));
        }

        return t;
    }
}
