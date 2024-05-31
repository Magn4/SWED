package com.monitoring.services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.monitoring.models.Subscription;
import com.monitoring.models.User;

import java.util.ArrayList;
import java.util.List;

public class WebsiteMonitorTest {
    @Test
    public void testWebsiteMonitor() {
        User user = new User("1", "user@example.com", "1234567890");
        Subscription subscription = new Subscription("sub1", "1", "http://example.com", "daily", "email");
        user.addSubscription(subscription);

        List<User> users = new ArrayList<>();
        users.add(user);

        WebsiteMonitor monitor = new WebsiteMonitor();
        monitor.checkForUpdates(users);
        // Additional assertions based on the implementation of checkForUpdates
    }
}
