package com.bcnc.exerciseOne.bridge;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AlbumBridgeTest {

    @Autowired
    private AlbumBridge albumBridge;

    @Test
    @Order(1)
    void returns_listOfRemoteAlbums(){
        assertNotEquals(0,albumBridge.getList().size());
    }
}
