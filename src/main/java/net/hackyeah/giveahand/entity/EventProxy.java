package net.hackyeah.giveahand.entity;

import lombok.Data;
import net.hackyeah.giveahand.data.EventCategoryRepo;
import net.hackyeah.giveahand.data.UsersRepo;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
@Data
public class EventProxy{

    private String ownerUserToken;
    private Long categoryId;
    private String name;
    private String description;
    private String address;
    private Date time;
    private Integer duration;
    private Integer peopleNumber;


}
