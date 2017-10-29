package net.hackyeah.giveahand.data;

import net.hackyeah.giveahand.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepo extends CrudRepository<User, Long> {
    User getUserByToken(String token);
    User findByToken(String token);
}
