package com.bulingbuling.admin.server.pc.dao;

import com.bulingbuling.admin.server.pc.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventDo extends JpaRepository<EventEntity, Integer> {

    @Query(value ="select distinct event_name from event_logging", nativeQuery = true)
    List<String> findAllEventName();

    @Query(value ="select count(*) from event_logging where event_logging.event_name = ?1", nativeQuery = true)
    int findCountByEventName(String eventName);
}
