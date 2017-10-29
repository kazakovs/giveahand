package net.hackyeah.giveahand.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Embeddable
public class JoinedEventsKey implements Serializable{

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private User userId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "events_id")
    private Event eventId;

}
