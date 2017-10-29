package net.hackyeah.giveahand.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private User ownerUser;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categories_id")
    private EventCategory category;
    private String name;
    private String description;
    private String address;
    private Date time;
    private Integer duration;
    private Integer peopleNumber;

}
