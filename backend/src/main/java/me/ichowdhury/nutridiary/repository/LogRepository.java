package me.ichowdhury.nutridiary.repository;

import me.ichowdhury.nutridiary.model.Log;
import me.ichowdhury.nutridiary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

// This interface  maps the Log object to a database table containing all logs. Represents the "logs" database table.
// It has methods that can be used to perform CRUD operations on the database, such as retrieving or deleting all logs.
// Implement custom methods to do more specific operations with the data in the database table, and display it at a url endpoint.
public interface LogRepository extends JpaRepository<Log, Long> {
}
