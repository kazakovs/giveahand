package net.hackyeah.giveahand.controller;

import net.hackyeah.giveahand.data.UsersRepo;
import net.hackyeah.giveahand.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Resource
    private UsersRepo usersRepo;

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

    @PutMapping
    public void saveUser(@RequestBody User user){
        usersRepo.save(user);
    }

}
