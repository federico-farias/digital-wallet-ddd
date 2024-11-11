package com.bintics.shared;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

public class DomainDate {

    private final LocalDateTime value;

    public DomainDate() {
        this.value = LocalDateTime.now(ZoneOffset.UTC);
    }

    public DomainDate(Date date) {
        this.value = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public Date getValue() {
        return java.sql.Date.from(value.atZone(ZoneId.systemDefault()).toInstant());
    }

}
