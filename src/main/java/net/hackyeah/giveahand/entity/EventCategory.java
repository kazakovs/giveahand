package net.hackyeah.giveahand.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "event_categories")
public class EventCategory {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String color;

}
