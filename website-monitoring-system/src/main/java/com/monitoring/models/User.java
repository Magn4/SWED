package com.monitoring.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String userID;
    private String email;
    private String phoneNumber;
    private final List<Subscription> subscriptions;

    public User(String userID, String email, String phoneNumber) {
        this.userID = userID;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.subscriptions = new ArrayList<>();
    }

    public void register(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void updatePreferences(String newEmail, String newPhoneNumber) {
        this.email = newEmail;
        this.phoneNumber = newPhoneNumber;
    }

    public void cancelSubscription(String subscriptionID) {
        subscriptions.removeIf(subscription -> subscription.getSubscriptionID().equals(subscriptionID));
    }

    public void addSubscription(Subscription subscription) {
        subscriptions.add(subscription);
    }

    // Getters and setters
    public String getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }
}
