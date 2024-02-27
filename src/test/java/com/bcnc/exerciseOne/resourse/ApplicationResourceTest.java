package com.bcnc.exerciseOne.resourse;

import com.bcnc.exerciseOne.resource.ApplicationResource;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApplicationResourceTest {
    @Autowired
    private ApplicationResource applicationResource;

    @Test
    @Order(1)
    void should_displayAlbumsEnhanced(){
        assertNotEquals(0, Objects.requireNonNull(applicationResource.displayAlbumsEnhanced().getBody()).stream().findAny().get().getPhotos().size());
    }

    @Test
    @Order(2)
    void should_saveInDB(){
        assertNotEquals(0, Objects.requireNonNull(applicationResource.saveInH2().getBody()).size());
    }

    @Test
    @Order(3)
    void returns_listOfAlbums_fromH2(){
        assertNotEquals(ResponseEntity.noContent().build(),applicationResource.getAlbums());
    }

}
