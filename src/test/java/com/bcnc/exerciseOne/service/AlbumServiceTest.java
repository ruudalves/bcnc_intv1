package com.bcnc.exerciseOne.service;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AlbumServiceTest {

    @Autowired
    private AlbumsService albumsService;

    @Test
    @Order(1)
    void should_getRemoteEnchanced(){
        assertNotEquals(0, albumsService.getRemoteAlbums().size());
    }

    @Test
    @Order(2)
    void should_saveInDB(){
        assertNotEquals(0,albumsService.saveAllRemote().size());
    }

    @Test
    @Order(2)
    void should_getAlbumsEnhancedFromDB(){
        Assertions.assertFalse(albumsService.getAllFromDB().isEmpty());
    }

}
