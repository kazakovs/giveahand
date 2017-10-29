package net.hackyeah.giveahand.data;

import net.hackyeah.giveahand.entity.JoinedEvents;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JoinedEventsRepo extends CrudRepository<JoinedEvents, Long> {
    List<JoinedEvents> getAllByJoinedEventsKey_UserIdToken(String token);
}
