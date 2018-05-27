package com.dmt.core.service.Impl;

import com.dmt.core.domain.Event;
import com.dmt.core.repository.EventRepository;
import com.dmt.core.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author mali.sahin
 * @since 27-May-18
 */
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository repository;

    @Override
    public Event save(Event event) {
        event.setCreDate(new Date());
        event.setId(String.valueOf(new Date().getTime()));
        return this.repository.save(event);
    }

    @Override
    public void delete(String eventId) {
        this.repository.deleteById(eventId);
    }

    @Override
    public List<Event> findAll() {
        return this.repository.findAll();
    }
}
