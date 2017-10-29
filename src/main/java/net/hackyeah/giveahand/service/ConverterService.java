package net.hackyeah.giveahand.service;

import net.hackyeah.giveahand.entity.Event;
import net.hackyeah.giveahand.entity.EventProxy;
import net.hackyeah.giveahand.entity.JoinedEvents;
import net.hackyeah.giveahand.entity.JoinedEventsProxy;

public interface ConverterService {
    Event toRepoEvent(EventProxy eventProxy);
    JoinedEvents toJoinedEvents(JoinedEventsProxy joinedEventsProxy);
}
