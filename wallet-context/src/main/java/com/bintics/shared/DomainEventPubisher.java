package com.bintics.shared;

import java.util.List;

public interface DomainEventPubisher {

    void pubish(List<DomainEvent> events);

}
