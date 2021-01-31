![Logo](/frontend/assets/logos/nutridiary.jpg)

An adaptive nutrition tracking web app, built with React and Spring Boot.

![build-pending](https://img.shields.io/badge/build-pending-yellow) ![release-v0.1](https://img.shields.io/badge/release-v0.1-blue) ![dependencies-up-to-date](https://img.shields.io/badge/dependencies-up%20to%20date-green) ![license-MIT](https://img.shields.io/badge/license-MIT-blue)

# Project Description

NutriDiary is a web app made to assist users with calorie tracking and workout logging. It features an adaptive calculator that tracks your calorie consumption and weight, and calculates how many calories you need to eat to lose or gain weight in accordance with your goals. To use the app, simply create an account, enter your weight gain/loss goals, and track your calories and weight each day. The calculator will automatically determine how many calories you'll need to consume daily to reach your goals, and its accuracy will increase over time.  

See the [design](/design) folder for more information.

# Getting Started

## Prerequisites

- [Java JDK 11+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Node.js and NPM](https://nodejs.org/en/download/)

## Local Installation

### Frontend

1. Open your shell and navigate to the `/frontend` folder.

2. `npm start`
3. Open your browser and go to http://localhost:3000/

### Backend

1. Download the JAR file from the [releases](https://github.com/IChowdhury01/NutriDiary-Adaptive-Nutrition-Tracker/releases) tab.
2. Open a shell and navigate to the folder with the JAR file: `/backend/target`.
3. `java -jar nutridiary-<version_number>.jar`
4. Open your browser and go to http://localhost:8080/hello

# Contributing

This project is currently not accepting open-source contributors, though it may in the future.

# License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

# Acknowledgements

The algorithm used for calculating TDEE was adapted from nSuns' [TDEE 3.0](https://drive.google.com/file/d/0B8EbfzFB0mBrMGJ6V2N5QWNfeTg/view) spreadsheet.
