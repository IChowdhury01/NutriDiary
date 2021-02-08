package me.ichowdhury.nutridiary.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.sql.Date;

@NoArgsConstructor
@Entity
@Data
@Table(name="logs")
public class Log {
    @Id
    private Long id;    // Unique log id.

    @NonNull
    private Date logDate;   // Date of log. In YYYY-MM-DD format

    private double weight;
    private int calories;
    private int protein;

    // Establishes a Many-to-One relationship between Logs and a User.
    @ManyToOne(cascade = CascadeType.PERSIST)   // Persist: when a user is updated, so is the log.
    private User user;
}
