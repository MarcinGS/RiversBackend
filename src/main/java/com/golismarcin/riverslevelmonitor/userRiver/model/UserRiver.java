package com.golismarcin.riverslevelmonitor.userRiver.model;

import com.golismarcin.riverslevelmonitor.note.model.Note;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRiver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long stationId;
    private String stationName;
    private String riverName;
    private Long regionId;
    private Double waterLevel;
    private LocalDateTime  waterDate;
    private Double waterTemp;
    private LocalDateTime  tempDate;
    private Double iceLevel;
    private LocalDateTime  iceDate;
    private Double growLevel;
    private LocalDateTime growDate;
    private String image;
    @OneToMany
    @JoinColumn(name = "riverId")
    private List<Note> note;
}
