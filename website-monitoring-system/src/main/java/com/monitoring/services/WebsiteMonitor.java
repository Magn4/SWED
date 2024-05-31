package com.monitoring.services;

import com.monitoring.models.Subscription;
import com.monitoring.models.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebsiteMonitor {
    private NotificationService notificationService = new NotificationService();
    private Map<String, String> previousContent = new HashMap<>();

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
        try {
            String content = fetchWebsiteContent(websiteURL);
            String previous = previousContent.get(websiteURL);

            if (previous != null && !previous.equals(content)) {
                previousContent.put(websiteURL, content);
                return true; // Content has changed
            } else if (previous == null) {
                previousContent.put(websiteURL, content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private String fetchWebsiteContent(String websiteURL) throws Exception {
        StringBuilder content = new StringBuilder();
        URL url = new URL(websiteURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
        }
        return content.toString();
    }

    private void notifyUser(User user, Subscription subscription) {
        String message = "Update detected on website: " + subscription.getWebsiteURL();
        if ("email".equalsIgnoreCase(subscription.getCommunicationChannel())) {
            notificationService.sendEmail(user.getEmail(), message);
        } else if ("sms".equalsIgnoreCase(subscription.getCommunicationChannel())) {
            notificationService.sendSMS(user.getPhoneNumber(), message);
        }
    }
}
