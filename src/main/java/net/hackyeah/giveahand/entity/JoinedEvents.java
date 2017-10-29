package net.hackyeah.giveahand.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "joined_events")
public class JoinedEvents {


    @EmbeddedId
    private JoinedEventsKey joinedEventsKey;


}
