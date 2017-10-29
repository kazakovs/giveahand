package net.hackyeah.giveahand.data;

import net.hackyeah.giveahand.entity.Event;
import net.hackyeah.giveahand.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepo extends CrudRepository<Event, Long> {
    List<Event> getEventByCategoryContainingAndOwnerUserEquals(List<Long> categories, User user);
    List<Event> getEventsByOwnerUserEquals(User user);
 }
