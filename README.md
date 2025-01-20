

# Project Status
### 🟠 Paused

# TrailQuest

# Content:
 * [Description](#Description)
 * [Details](#Details)
 * [Demo](#Demo)
 
# Description
This is a mobile application which helps people go out and explore the world. TrailQuest gamifies the process of exploration using: Levels, Experience, Achievements and Badges. This app also offers statistics in order to track progress.

# Details

### Domain Details
&nbsp; &nbsp;&nbsp;   Entities:

 - User
 - Country
 - Attraction
 - Type

### CRUD Details
&nbsp; &nbsp;&nbsp; Most of the CRUD operation are going to be done on the **Attraction** Entity, namely

 - Creating attractions
 - Retrieving attractions
 - Updating attractions
 - Deleting attractions
 
&nbsp; &nbsp;&nbsp; With statistics support, you are going to be able to
 - Retrieve automaticaly updated statistics

### Persistence Details
All the data on all the entities is going to be persisted in a local and remote relational database.

### Server Details
-   Update/Delete while offline: a message indicating that the operation is not available will be shown.
-   Retrieve while offline: the data in the local database will be used and the user will be notified that the connection is down.
-   Create while offline: the new entity will be created and saved in the local database, syncing its contents with the server when the connection is up again.

# Demo
<p align="center"><img src="https://github.com/DanLaurentiu1/TrailQuest/blob/main/TrailQuestDemo.gif" width="369" height="805"/></p>
