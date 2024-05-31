package com.monitoring;

import com.monitoring.models.User;
import com.monitoring.models.Subscription;
import com.monitoring.services.WebsiteMonitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User loggedInUser = null;

        while (loggedInUser == null) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                loggedInUser = login(scanner);
            } else if (choice == 2) {
                loggedInUser = register(scanner);
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Welcome, " + loggedInUser.getEmail());

        System.out.println("Enter the website URL you want to monitor:");
        String websiteURL = scanner.nextLine();

        System.out.println("Enter the frequency of checks (e.g., 'daily', 'hourly'):");
        String frequency = scanner.nextLine();

        System.out.println("Enter your preferred communication channel (email/sms):");
        String communicationChannel = scanner.nextLine();

        Subscription subscription = new Subscription("sub" + (loggedInUser.getSubscriptions().size() + 1), loggedInUser.getUserID(), websiteURL, frequency, communicationChannel);
        loggedInUser.addSubscription(subscription);

        System.out.println("Monitoring website: " + websiteURL);

        // Create WebsiteMonitor instance
        WebsiteMonitor monitor = new WebsiteMonitor();

        // Start monitoring in a separate thread to continuously check for updates
        new Thread(() -> {
            while (true) {
                monitor.checkForUpdates(users);
                try {
                    Thread.sleep(10000); // Sleep for 10 seconds before the next check
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static User login(Scanner scanner) {
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        System.out.println("Enter your phone number:");
        String phoneNumber = scanner.nextLine();

        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPhoneNumber().equals(phoneNumber)) {
                return user;
            }
        }
        System.out.println("Invalid email or phone number. Please try again.");
        return null;
    }

    private static User register(Scanner scanner) {
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        System.out.println("Enter your phone number:");
        String phoneNumber = scanner.nextLine();
        String userID = "user" + (users.size() + 1);

        User newUser = new User(userID, email, phoneNumber);
        users.add(newUser);
        return newUser;
    }
}
