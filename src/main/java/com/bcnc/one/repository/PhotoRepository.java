package com.bcnc.one.repository;

import com.bcnc.one.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
