package com.dmt.core.service;

import com.dmt.core.domain.Event;

import java.util.List;

/**
 * @author mali.sahin
 * @since 27-May-18
 */
public interface EventService {

    public Event save(Event event);

    public void delete(String eventId);

    public List<Event> findAll();
}
