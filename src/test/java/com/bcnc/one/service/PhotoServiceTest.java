package com.bcnc.one.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PhotoServiceTest {
    @Autowired
    private PhotosService photosService;

    @Test
    @Order(1)
    void should_getRemotePhotos(){
        assertNotEquals(Collections.EMPTY_LIST,photosService.getRemotePhotos());
    }

    @Test
    @Order(2)
    void should_storeRemotePhotosInDB(){
        assertNotEquals(Collections.EMPTY_LIST,photosService.saveAllRemote());
    }

    @Test
    @Order(3)
    void should_getPhotosFromDB(){
        assertNotEquals(Collections.EMPTY_LIST, photosService.getAllFromDB());
    }
}
