#!/bin/bash

# Project root directory
mkdir -p website-monitoring-system

# Main source directories
mkdir -p website-monitoring-system/src/main/java/com/monitoring/models
mkdir -p website-monitoring-system/src/main/java/com/monitoring/services
mkdir -p website-monitoring-system/src/main/java/com/monitoring/utils

# Resource directory
mkdir -p website-monitoring-system/src/main/resources

# Test directories
mkdir -p website-monitoring-system/test/java/com/monitoring/models
mkdir -p website-monitoring-system/test/java/com/monitoring/services

# Documentation and lib directories
mkdir -p website-monitoring-system/lib
mkdir -p website-monitoring-system/docs

# Create main Java files
touch website-monitoring-system/src/main/java/com/monitoring/models/User.java
touch website-monitoring-system/src/main/java/com/monitoring/models/Subscription.java
touch website-monitoring-system/src/main/java/com/monitoring/services/WebsiteMonitor.java
touch website-monitoring-system/src/main/java/com/monitoring/services/NotificationService.java
touch website-monitoring-system/src/main/java/com/monitoring/utils/Utils.java

# Create resource files
touch website-monitoring-system/src/main/resources/application.properties

# Create test Java files
touch website-monitoring-system/test/java/com/monitoring/models/UserTest.java
touch website-monitoring-system/test/java/com/monitoring/models/SubscriptionTest.java
touch website-monitoring-system/test/java/com/monitoring/services/WebsiteMonitorTest.java
touch website-monitoring-system/test/java/com/monitoring/services/NotificationServiceTest.java

# Create build configuration files
touch website-monitoring-system/pom.xml
touch website-monitoring-system/build.gradle

echo "Project structure created successfully!"
