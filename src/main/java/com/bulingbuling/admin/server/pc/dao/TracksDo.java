package com.bulingbuling.admin.server.pc.dao;

import com.bulingbuling.admin.server.pc.entity.TracksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TracksDo extends JpaRepository<TracksEntity, Integer> {

    @Query(value ="select distinct from_path from tracks_logging", nativeQuery = true)
    List<String> findAllFromPath();

    @Query(value ="select sum(tracks) from tracks_logging where tracks_logging.from_path = ?1", nativeQuery = true)
    Long findTracksByFromPath(String fromPath);
}
