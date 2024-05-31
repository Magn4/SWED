package com.monitoring.models;

public class Subscription {
    private String subscriptionID;
    private String userID;
    private String websiteURL;
    private String frequency;
    private String communicationChannel;

    public Subscription(String subscriptionID, String userID, String websiteURL, String frequency, String communicationChannel) {
        this.subscriptionID = subscriptionID;
        this.userID = userID;
        this.websiteURL = websiteURL;
        this.frequency = frequency;
        this.communicationChannel = communicationChannel;
    }

    public void modifySubscription(String newFrequency, String newChannel) {
        this.frequency = newFrequency;
        this.communicationChannel = newChannel;
    }

    public void cancelSubscription() {
        // Logic to cancel subscription
    }

    // Getters and setters
    public String getSubscriptionID() {
        return subscriptionID;
    }

    public String getUserID() {
        return userID;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public String getFrequency() {
        return frequency;
    }

    public String getCommunicationChannel() {
        return communicationChannel;
    }
}
