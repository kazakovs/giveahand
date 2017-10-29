package net.hackyeah.giveahand.controller;

import net.hackyeah.giveahand.data.JoinedEventsRepo;
import net.hackyeah.giveahand.data.UsersRepo;
import net.hackyeah.giveahand.entity.Event;
import net.hackyeah.giveahand.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users")
public class UserController {

    @Resource
    private UsersRepo usersRepo;

    @Resource
    private JoinedEventsRepo joinedEventsRepo;

    @GetMapping
    public List<User> getAllUsers(){
        return (List<User>) usersRepo.findAll();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") Long userId){
        return usersRepo.findOne(userId);
    }

    @GetMapping("/token/{token}")
    public User getUserByToken(@PathVariable("token") String token){
        return usersRepo.findByToken(token);
    }

    @GetMapping("/token/{token}/events")
    public List<Event> getEventsForUser(@PathVariable("token") String token){
        return joinedEventsRepo.getAllByJoinedEventsKey_UserIdToken(token)
                .stream()
                .map(s -> s.getJoinedEventsKey().getEventId())
                .collect(Collectors.toList());
    }

    @PutMapping
    public void saveUser(@RequestBody User user){
        User exUser = usersRepo.findByToken(user.getToken());
        if (exUser != null){
            user.setId(exUser.getId());
        }
        usersRepo.save(user);
    }

}
