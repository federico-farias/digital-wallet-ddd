package com.bintics.context.customer.domain.model;

import com.bintics.context.customer.domain.exception.CustomerEmailNoValidException;
import com.bintics.context.customer.domain.exception.CustomerFieldRequiredException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerEmailTest {

    @Test
    void shouldNoCreateEmailWhenEmailIsNull() {
        assertThrows(CustomerFieldRequiredException.class, () -> new CustomerEmail(null));
    }

    @Test
    void shouldNoCreateEmailWhenEmailNoValid() {
        List<String> emails = Arrays.asList(
                "federico",
                "federico.farias@"
        );
        for (String email : emails) {
            assertThrows(CustomerEmailNoValidException.class, () -> new CustomerEmail(email));
        }
    }

    @Test
    void shouldCreateEmailWhenSuccess() {
        CustomerEmail email = new CustomerEmail("federico.farias@outlook");
        assertNotNull(email);
        assertEquals("federico.farias@outlook", email.getValue());
    }

}