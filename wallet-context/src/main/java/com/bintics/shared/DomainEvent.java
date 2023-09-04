package com.bintics.shared;

import java.util.Date;

public class DomainEvent {

    protected DomainDate eventDate = new DomainDate();

    public Date getEventDate() {
        return this.eventDate.getValue();
    }

}
