package me.ichowdhury.nutridiary.controller;

import me.ichowdhury.nutridiary.model.Log;
import me.ichowdhury.nutridiary.repository.LogRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;
import java.util.Collection;
import java.util.Optional;

// This class implements all URL routing and database operations for the Log class.
@RestController     // Indicates that this class will access the REST API, i.e. it will use URL mappings to handle HTTP requests sent from the frontend.
@RequestMapping("/api") // Establishes endpoint at http://server:port/api. Server will wait for any HTTP request to this url. When it receives a request, it will respond with the appropriate method, depending on the URL and HTTP request type.
public class LogController {
    private LogRepository logRepository;    // Represents the "logs" DB table.

    public LogController(LogRepository logRepository) {
        super();    // Inherit methods from parent.
        this.logRepository = logRepository;
    }

    // Retrieving logs from database
    // Wait for HTTP requests at various endpoints. Then access the database using LogRepository interface methods, and return a response entity.
    @GetMapping("/logs")    // Establishes an endpoint for GET requests at /api/logs. If an HTTP GET request is sent here, the method displayLogs() will be invoked.
    Collection<Log> displayLogs() {
        return logRepository.findAll(); // * Gets all log entries from the database (SQL: SELECT * FROM logs) then returns it as an HTTP response entity.
    }

    @GetMapping("/log/{id}")   // Wait for GET request at /api/logs/log_id.
    ResponseEntity<?> displayLogByID(@PathVariable Long id) {   // Extract an ID from the URL using @PathVariable and store it in Long id, then use it to return an HTTP response entity (in JSON form). <?> is used because we don't know whether we'll get a Log or NULL
        Optional<Log> log = logRepository.findById(id); // Search the logs table for the log ID in the URL. If found, return the log. Optional<Log> is used because the specified log ID might not be found in the database.
        return log.map(response -> ResponseEntity.ok().body(response))  // Return an HTTP response. Status "ok" with Log JSON, or status NOT_FOUND.
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Adding logs to database
    @PostMapping("/log")    // Wait for POST request to /api/log
    ResponseEntity<Log> createLog(@Valid @RequestBody Log log) throws URISyntaxException {    // Check if the POST request is valid. Then use the request body to make a Log object. Return the newly created Log as a ResponseEntity.
        Log fixedLog = fixLogDate(log);
        Log newLog=logRepository.save(fixedLog); // Save new log into database table, then return the log.
        return ResponseEntity.created(new URI("/api/log" + newLog.getId())).body(newLog);   // Create a response entity using the new log, and return it as an HTTP response.
    }

    // Updating logs in database
    @PutMapping("/log/{id}")    // Wait for PUT request to /api/log/log_id
    ResponseEntity<Log> updateLog(@Valid @RequestBody Log log) {    // Check if request body is valid. If it is, create a Log object out of it.
        Log fixedLog = fixLogDate(log);
        Log updatedLog = logRepository.save(fixedLog);   // Update database with log object, then return it.
        return ResponseEntity.ok().body(updatedLog);    // Send a response entity with status "ok" and the new log in the body.
    }

    // Deleting logs from database
    @DeleteMapping("/log/{id}")     // Wait for a DELETE request to /api/log/log_id
    ResponseEntity<?> deleteLog(@PathVariable Long id) { // Use id in URL as a parameter
        logRepository.deleteById(id);   // Delete log from database.
        return ResponseEntity.ok().build();   // Return response entity with status "ok".
    }

    // Fixes bug where a log inserted into the database has its date lowered by one day.
    private static Log fixLogDate(Log log) {
        log.setLogDate(new Date(log.getLogDate().getTime() + 24*60*60*1000));   // Add one day to logDate field.
        return log;
    }
}
