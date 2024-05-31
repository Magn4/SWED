package com.monitoring.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    public void testUser() {
        User user = new User("1", "user@example.com", "1234567890");
        assertEquals("user@example.com", user.getEmail());
        assertEquals("1234567890", user.getPhoneNumber());
    }
}
