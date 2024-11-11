package com.bintics.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DomainEventPubisherImpl implements DomainEventPubisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void pubish(List<DomainEvent> events) {
        for (DomainEvent event : events) {
            this.applicationEventPublisher.publishEvent(event);
        }
    }

}
