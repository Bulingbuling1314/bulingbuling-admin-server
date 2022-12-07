package com.bulingbuling.admin.server.pc.entity;

import com.bulingbuling.admin.server.pc.vo.PageEventEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="event_logging")
@Getter
@Setter
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "date")
    private String date;

    public EventEntity(int id, String eventName, String date) {
        this.id = id;
        this.eventName = eventName;
        this.date = date;
    }

    public EventEntity() {

    }
}
