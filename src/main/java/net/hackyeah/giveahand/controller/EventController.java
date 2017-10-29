package net.hackyeah.giveahand.controller;

import net.hackyeah.giveahand.data.EventRepo;
import net.hackyeah.giveahand.data.JoinedEventsRepo;
import net.hackyeah.giveahand.data.UsersRepo;
import net.hackyeah.giveahand.entity.Event;
import net.hackyeah.giveahand.entity.EventProxy;
import net.hackyeah.giveahand.entity.JoinedEventsProxy;
import net.hackyeah.giveahand.service.ConverterService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("events")
public class EventController {

    @Resource private EventRepo eventRepo;
    @Resource private UsersRepo usersRepo;
    @Resource private JoinedEventsRepo joinedEventsRepo;
    @Resource private ConverterService converter;

    @GetMapping
    public List<Event> getAllEvents(){
        return (List<Event>) eventRepo.findAll();
    }

    @GetMapping("/{eventId}")
    public Event getEventById(@PathVariable("eventId") Long eventId){
        return eventRepo.findOne(eventId);
    }

    @PostMapping
    public void createEvent(@RequestBody EventProxy eventProxy){
        eventRepo.save(converter.toRepoEvent(eventProxy));
    }


    @GetMapping("/user/{userToken}")
    public List<Event> getEventsForUser(@PathVariable("userToken") String token){
        return eventRepo.getEventsByOwnerUserEquals(usersRepo.getUserByToken(token));
    }

    @PostMapping("{eventId}/join/{userToken}")
    public void joinEvent(@PathVariable("eventId") Long eventId,
                          @PathVariable("userToken") String userToken){
        JoinedEventsProxy joinedEventsProxy = new JoinedEventsProxy();
        joinedEventsProxy.setEventId(eventId);
        joinedEventsProxy.setUserToken(userToken);
        joinedEventsRepo.save(converter.toJoinedEvents(joinedEventsProxy));
    }

    @DeleteMapping("{eventId}/join/{userToken}")
    public void leaveEvent(@PathVariable("eventId") Long eventId,
                           @PathVariable("userToken") String userToken){
        JoinedEventsProxy joinedEventsProxy = new JoinedEventsProxy();
        joinedEventsProxy.setEventId(eventId);
        joinedEventsProxy.setUserToken(userToken);
        joinedEventsRepo.delete(converter.toJoinedEvents(joinedEventsProxy));
    }

    @DeleteMapping("/{eventId}")
    public void cancelEvent(@PathVariable("eventId") Long eventId){
        eventRepo.delete(eventId);
    }

}
