package net.hackyeah.giveahand.service;

import net.hackyeah.giveahand.data.EventCategoryRepo;
import net.hackyeah.giveahand.data.EventRepo;
import net.hackyeah.giveahand.data.UsersRepo;
import net.hackyeah.giveahand.entity.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Converter implements ConverterService{

    @Resource private UsersRepo usersRepo;
    @Resource private EventCategoryRepo eventCategoryRepo;
    @Resource private EventRepo eventRepo;

    public Event toRepoEvent(EventProxy eventProxy) {

        Event event = new Event();
        event.setName(eventProxy.getName());
        event.setAddress(eventProxy.getAddress());
        event.setCategory(eventCategoryRepo.findOne(eventProxy.getCategoryId()));
        event.setOwnerUser(usersRepo.findByToken(eventProxy.getOwnerUserToken()));
        event.setDescription(eventProxy.getDescription());
        event.setPeopleNumber(eventProxy.getPeopleNumber());
        event.setTime(eventProxy.getTime());
        event.setDuration(eventProxy.getDuration());

        return event;
    }

    public JoinedEvents toJoinedEvents(JoinedEventsProxy joinedEventsProxy) {
        JoinedEvents joinedEvents = new JoinedEvents();
        JoinedEventsKey joinedEventsKey = new JoinedEventsKey();
        joinedEventsKey.setEventId(eventRepo.findOne(joinedEventsProxy.getEventId()));
        joinedEventsKey.setUserId(usersRepo.findByToken(joinedEventsProxy.getUserToken()));
        joinedEvents.setJoinedEventsKey(joinedEventsKey);
        return joinedEvents;
    }

}
