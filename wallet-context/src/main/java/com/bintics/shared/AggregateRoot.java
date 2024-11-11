package com.bintics.shared;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AggregateRoot {

    private List<DomainEvent> events = new LinkedList<>();

    protected void record(DomainEvent event) {
        this.events.add(event);
    }

    public List<DomainEvent> pullEvents() {
        List<DomainEvent> events = this.events;
        this.events = new ArrayList<>();
        return events;
    }
}
