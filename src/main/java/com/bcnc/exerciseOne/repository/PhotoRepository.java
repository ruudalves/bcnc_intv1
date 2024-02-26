package com.bcnc.exerciseOne.repository;

import com.bcnc.exerciseOne.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
