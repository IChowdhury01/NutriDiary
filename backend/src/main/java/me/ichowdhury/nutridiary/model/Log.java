package me.ichowdhury.nutridiary.model;

import java.util.Date;

public class Log {
    private Date date;
    private double weight;
    private int calories;
    private int protein;

    public Log(Date date, double weight, int calories, int protein) {
        this.date = date;
        this.weight = weight;
        this.calories = calories;
        this.protein = protein;
    }

    public Log(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Log { ");
            sb.append("Date: ").append(date);
            sb.append("Weight: ").append(weight);
            sb.append("Calorie Intake: ").append(calories);
            sb.append("Protein Intake: ").append(protein);
            sb.append(" }");
            return sb.toString();
    }
}
