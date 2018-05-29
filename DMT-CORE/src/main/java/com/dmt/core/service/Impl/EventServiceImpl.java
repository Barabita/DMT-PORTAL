package com.dmt.core.service.Impl;

import com.dmt.core.domain.Event;
import com.dmt.core.repository.EventRepository;
import com.dmt.core.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author mali.sahin
 * @since 27-May-18
 */
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    @Transactional
    public Event save(Event event) {
        event.setCreDate(new Date());
        event.setId(String.valueOf(new Date().getTime()));
        return this.eventRepository.save(event);
    }

    @Override
    @Transactional
    public void delete(String eventId) {
        this.eventRepository.deleteById(eventId);
    }

    @Override
    public List<Event> findAll() {
        return this.eventRepository.findAll();
    }
}
