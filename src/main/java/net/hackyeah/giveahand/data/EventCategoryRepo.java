package net.hackyeah.giveahand.data;

import net.hackyeah.giveahand.entity.EventCategory;
import org.springframework.data.repository.CrudRepository;

public interface EventCategoryRepo extends CrudRepository<EventCategory, Long> {
}
