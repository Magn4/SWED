package com.monitoring.services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NotificationServiceTest {
    @Test
    public void testNotificationService() {
        NotificationService notificationService = new NotificationService();
        // Test sending email
        notificationService.sendEmail("user@example.com", "Test message");
        // Test sending SMS
        notificationService.sendSMS("1234567890", "Test message");
        // Add assertions based on the implementation
    }
}
