# NutriDiary: Design Notes

## Tech Stack

- **Frontend**: React
- **Backend**: Spring Boot, Spring Data JPA, Hibernate
- **Database**: PostgreSQL
- **Web Server**: Embedded Apache Tomcat
- **Deployment**: Heroku
- **Build Tools**: Maven, Git
- **Unit Testing:** JUnit

## Feature Roadmap

- **v1.0:** Working
  - Account creation
    - Enter goal weekly weight change.
  - Track nutrition info
    - Save or modify daily weight, protein and calories.
    - Display past day records.
    - Display average weight, protein, and calories per week.
  - Calculate TDEE 
    - Auto calculate TDEE based on recent records.
    - Calculate and display recommended daily calorie intake, based on TDEE and goal weekly weight change.
 - **v1.5:** Ready for live display
    - UI
      - Live display weekly stats and recommended calorie intake. Change when records are modified.  
 - **v2.0**
   - Calculate and display weekly surplus/deficits in protein and calories.
     - Show surplus (how much to eat in 1 day to make it up)
     - Show surplus divided by days remaining (how much to eat on average for the rest of the week to make it up)
   - Account creation
     - Username
     - Password encryption.
     - Goal weekly weight change.
   - Cookies. Remember last sign-in.
 - **v3.0: Completion**
   - Sign in with Google
   - Sync with MyFitnessPal
     - Manual import calories and protein from MyFitnessPal.
     - Automatic import. Choose time of day to import data.
   - Account creationn
     - Profile picture
     - Drop down menu for goals (+/-, 0.5, 1.0, 1.5, 2.0)
 - **v4.0**
   - Track exercise data.
     - Set goal number of days for different exercises (strength training, cardio, custom step count)
     - Save counter for exercises completed.
     - Display exercises completed (e.g. 3/4 strength training, 2/5 cardio, etc.)
   - Sync with Google Fit
     - Automatic import: daily step counter. Import at same time as MFP data.
 - **v5.0**
   - Generate reports
     - Process and visualize last 2-4 weeks data into graphs and other data visualizes. Based on NSun TDEE spreadsheet monthly summaries. 
     - Generate reports recording your progress last month or 6 months, and telling you to lower or raise calories to meet your goal.
   - Submit a feature form.
   - Donate button.
 - **v6.0**
   - Two-factor authentication
   - Import nSuns TDEE 3.0 CSV
   - Export to nSuns TDEE 3.0 CSV
