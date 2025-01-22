# Earthquake Data Management System

## Overview

This project is a Java-based system for analyzing and managing earthquake data from 1965 to 2016. It categorizes and processes earthquake information using advanced data structures, including queues, stacks, linked lists, and collections. The system integrates a reverse geocoding library to extract city and country details from geographic coordinates.

---

## Problem Statement

### Step-by-Step Implementation:

1. **Reverse Geocoding**:
   - Use the [Reverse Geocoding Library for Java](https://www.daniel-braun.com/technik/reverse-geocoding-library-for-java/) to find city and country names from coordinates.
   - Store the data in yearly earthquake collections, including the magnitude.

2. **Queue for Maximum Earthquakes**:
   - Create a queue containing the largest earthquake for each year (1965-2016).

3. **Country-Specific Stacks**:
   - For each country, maintain a stack storing earthquakes with the most recent event on top.

4. **Linked List for Recent Earthquakes**:
   - Build a linked list to save the most recent earthquake (with magnitude and country name) for each country.

---

### Analytical Problems

1. **Average Earthquakes per Year**:
   - Find the average number of earthquakes per year for each country.
   - Determine the most vulnerable country.

2. **Biggest Earthquakes (2005-2015)**:
   - Identify the largest earthquakes during this period and their respective countries.

3. **Recent Earthquakes by Country**:
   - Retrieve the five most recent earthquakes from each country.

4. **Significant Earthquakes**:
   - Find recent earthquakes with magnitudes above 6.

---

## Requirements

- **Java Version**: 8 or higher.
- **Dependencies**:
  - [Reverse Geocoding Library for Java](https://www.daniel-braun.com/technik/reverse-geocoding-library-for-java/)
  - Apache POI for Excel handling.

---

## Setup Instructions

1. Clone this repository:
   ```bash
   git clone https://github.com/username/repo-name.git
2. Add the database.xlsx file containing earthquake data to the root directory.

3. Download and add the reverse geocoding library to your Java project.

4. Compile and run the project:
   ```bash
   javac Main.java
   java Main

## Code Explanation

### Class Descriptions

* **Main**:
  - Entry point of the program.
  - Handles user interaction and executes steps and analytical problems.
* **Collections**:
  - Manages earthquake data grouped by year.
* **LinkedStack**:
  - Implements a stack for managing earthquake data by country.
* **Linked_list**:
  - Represents the most recent earthquake for each country.
* **Queue**:
  - Custom queue to store yearly maximum earthquakes.
* **list and node**:
  - Helper classes for building linked lists.
* **Database**:
  - Handles reading and writing data to/from Excel files.
* **Location**:
  - Uses reverse geocoding to fetch country and city names based on latitude and longitude.
