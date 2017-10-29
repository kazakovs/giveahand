package net.hackyeah.giveahand.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String token;
    private String name;
    private String email;
    private String location;
    private Integer age;
    private String about;
    private String pictureUrl;

}
