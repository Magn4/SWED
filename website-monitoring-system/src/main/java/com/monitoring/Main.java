package com.monitoring;

import com.monitoring.models.User;
import com.monitoring.models.Subscription;
import com.monitoring.services.WebsiteMonitor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Example data
        User user = new User("1", "user@example.com", "1234567890");
        Subscription subscription = new Subscription("sub1", "1", "http://example.com", "daily", "email");
        user.addSubscription(subscription);

        List<User> users = new ArrayList<>();
        users.add(user);

        // Create WebsiteMonitor instance
        WebsiteMonitor monitor = new WebsiteMonitor();
        monitor.checkForUpdates(users);

        System.out.println("Website monitoring started.");
    }
}
