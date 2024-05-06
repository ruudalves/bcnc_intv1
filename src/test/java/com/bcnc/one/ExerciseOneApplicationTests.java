package com.bcnc.one;

import com.bcnc.one.bridge.AlbumBridge;
import com.bcnc.one.repository.AlbumRepository;
import com.bcnc.one.service.PhotosService;
import com.bcnc.one.service.impl.AlbumsServiceImpl;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

//Integration Tests
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ExerciseOneApplicationTests {


    @Mock
    private AlbumBridge albumBridge;

    @Mock
    private PhotosService photosService;

    @Mock
    private AlbumRepository albumsService;

    @Test
    @Order(1)
    void should_callBridgeToGetAlbumsAndGetRemotePhotosToAttachToAlbum(){
        //Mock elements
        albumBridge = mock(AlbumBridge.class);
        photosService = mock(PhotosService.class);
        albumsService = mock(AlbumRepository.class);
        //Attach mocks
        AlbumsServiceImpl albumsServiceImpl = new AlbumsServiceImpl(albumsService,albumBridge, photosService);
        //Call
        albumsServiceImpl.getRemoteAlbums();
        //test verifications
        verify(albumBridge, times(1)).getList();
        verify(photosService, times(1)).getRemotePhotos();
    }
}
