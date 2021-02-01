package me.ichowdhury.nutridiary;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id  // Primary key = UserID
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userID;

    private String username;
    private String password;
    private double goalWC;   // Weekly weight change goal, ex. -1.5 lbs
    private String profilePic;  // Path to uploaded profile photo.

    protected User() {}

    public User(Long userID, String username, String password, Double goalWC) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.goalWC = goalWC;
        this.profilePic = "";   // Path to default profile photo.
    }

    public User(Long userID, String username, String password, Double goalWC, String profilePic) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.goalWC = goalWC;
        this.profilePic = profilePic;
    }

    public Long getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getGoalWC() {
        return goalWC;
    }

    public void setGoalWC(Double goalWC) {
        this.goalWC = goalWC;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        User user = (User) obj;

        return user.userID == this.userID && user.username.equals(this.username) && user.password.equals(this.password) && user.goalWC == this.goalWC && user.profilePic.equals(this.profilePic);
    }
    @Override
    public int hashCode() {
        int result = 17;
        int castedGoalWC = (int) goalWC;
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + profilePic.hashCode();
        result = 31 * result + userID.intValue();
        result = 31 * result + castedGoalWC;

        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User {");
        sb.append("ID: ").append(userID);
        sb.append("Username: ").append(username);
        sb.append(", Password: ").append(password);
        sb.append(", Weekly Weight Change Goal: ").append(goalWC);
        sb.append(" lbs, Profile Picture: ").append(profilePic);
        sb.append(" }");
        return sb.toString();
    }
}