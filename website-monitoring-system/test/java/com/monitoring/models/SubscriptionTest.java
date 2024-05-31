package com.monitoring.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SubscriptionTest {
    @Test
    public void testSubscription() {
        Subscription subscription = new Subscription("sub1", "1", "http://example.com", "daily", "email");
        assertEquals("http://example.com", subscription.getWebsiteURL());
        assertEquals("daily", subscription.getFrequency());
        assertEquals("email", subscription.getCommunicationChannel());
    }
}
