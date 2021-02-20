package me.ichowdhury.nutridiary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@AllArgsConstructor // Lombok automatically generates constructors for the User class. 1 with all fields, 1 with none.
@NoArgsConstructor
@Entity // Use this class as a database entity.
@Data   // Lombok automatically generates getters, setters, and constructors.
@Table(name="users") // Assign this class to a database titled "user".
public class User {

    @Id // Primary Key
    private Long id;    // Unique user id.

    @NonNull
    @NotEmpty(message = "Username must not be empty.")
    @Size(min = 3, max = 30, message = "Username must be between 3 and 30 characters.")
    private String username;

    @NonNull
    @NotEmpty(message = "Password must not be empty.")
    private String password;

    @NotNull(message = "Goal must not be null. Enter 0 instead.")
    private double goalWWC;   // Goal weekly weight change. Example: -1.5 lbs/week.

    private String profilePic;  // Path to uploaded profile photo.

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)  // Deleting a user deletes all of the user's logs.
    private Set<Log> logs;
}