# NutriDiary: Design Notes

## Tech Stack

- **Frontend**: HTML/CSS/JS, JQuery, React
- **Backend**: Java, Spring Boot, Spring Data JPA, Hibernate
- **Database**: PostgreSQL
- **Web Server**: Embedded Apache Tomcat
- **Deployment**: Heroku
- **Build Tools**: Maven
- **Unit Testing:** JUnit

## Features

- **T1: Core Features**
  - Account creation
       - Create account
            - Name
            - Goals (+/-/custom weekly weight loss)
  - Track nutrition info
    - Daily weight, protein and calories
    - Average weight, protein, and calories per week.
  - Calculate TDEE 
    - Auto calculate TDEE and recommended daily calorie intake.
 - **T2: Important Features**
   - Calculates weekly surplus/deficits in protein and calories.
     - Show surplus (how much to eat in 1 day to make it up)
     - Show surplus divided by days remaining (how much to eat for the rest of the week to make it up)
   - Track workouts
     - Set goal number of days per week for exercise (walk 10k steps, cardio, strength training)
     - Count how many times per week you've trained (e.g. 3/4 strength training)
 - **T3: Stretch Features**
   - Account creation
     - Add profile pic to profile
     - Add drop down menu for goals (0.5,1,1.5,2)
   - Sync with MFP 
     - Import MFP calories and protein to NutriDiary daily. 
- **T4 Features**
  - Sync with Google Fit (steps)
    - Import number of steps to NutriDiary daily.
    - If step count passes 10k, track workout in NutriDiary.
  - Generates reports
    - Process and visualize last 2-4 weeks data into data visualizations, graphs, etc. based on NSun TDEE sheet monthly summaries. 
    - Reports tell you to lower or raise calories to meet your goal.
  - Fancy UI
- **T5 Features**
  - Submit a feature form.
  - Export to nSuns TDEE 3.0 CSV
  - Import nSuns TDEE 3.0 CSV
  - Night mode
