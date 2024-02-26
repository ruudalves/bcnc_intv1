package com.bcnc.exerciseOne.repository;

import com.bcnc.exerciseOne.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long>{
}
