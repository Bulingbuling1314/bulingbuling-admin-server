package com.bulingbuling.admin.server.pc.entity;

import com.bulingbuling.admin.server.pc.vo.PageEventEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="tracks_logging")
@Getter
@Setter
public class TracksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "from_path")
    private String fromPath;

    @Column(name = "to_path")
    private String toPath;

    @Column(name = "date")
    private String date;

    //    时长
    @Column(name = "tracks")
    private long tracks;

    public TracksEntity(int id, String fromPath, String toPath, String date, long tracks) {
        this.id = id;
        this.fromPath = fromPath;
        this.toPath = toPath;
        this.date = date;
        this.tracks = tracks;
    }

    public TracksEntity() {

    }
}
