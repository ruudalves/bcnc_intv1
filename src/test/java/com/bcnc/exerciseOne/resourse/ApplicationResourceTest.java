package com.bcnc.exerciseOne.resourse;

import com.bcnc.exerciseOne.bridge.AlbumBridge;
import com.bcnc.exerciseOne.resource.ApplicationResource;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApplicationResourceTest {
    @Autowired
    private ApplicationResource applicationResource;

    @Test
    @Order(1)
    void should_displayAlbumsEnhanced(){
        assertNotEquals(0,applicationResource.displayAlbumsEnhanced().getBody().stream().findAny().get().getPhotos().size());
    }

    @Test
    @Order(2)
    void should_saveInDB(){
        assertNotEquals(0,applicationResource.saveInH2().getBody().size());
    }

    @Test
    @Order(3)
    void returns_listOfAlbums_fromH2(){
        assertNotEquals(ResponseEntity.noContent().build(),applicationResource.getAlbums());
    }

}
