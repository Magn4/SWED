package com.monitoring.services;

import com.monitoring.models.Subscription;
import com.monitoring.models.User;

import java.util.List;

public class WebsiteMonitor {
    public void checkForUpdates(List<User> users) {
        for (User user : users) {
            for (Subscription subscription : user.getSubscriptions()) {
                boolean updateDetected = checkWebsite(subscription.getWebsiteURL());
                if (updateDetected) {
                    notifyUser(user, subscription);
                }
            }
        }
    }

    private boolean checkWebsite(String websiteURL) {
        // Logic to check if website has updates
        return true; // Placeholder
    }

    private void notifyUser(User user, Subscription subscription) {
        String message = "Update detected on website: " + subscription.getWebsiteURL();
        NotificationService notificationService = new NotificationService();
        if (subscription.getCommunicationChannel().equals("email")) {
            notificationService.sendEmail(user.getEmail(), message);
        } else if (subscription.getCommunicationChannel().equals("sms")) {
            notificationService.sendSMS(user.getPhoneNumber(), message);
        }
    }
}
