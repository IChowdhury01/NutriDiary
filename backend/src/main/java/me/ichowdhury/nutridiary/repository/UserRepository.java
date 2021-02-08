package me.ichowdhury.nutridiary.repository;

import me.ichowdhury.nutridiary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Map the User object to a database table containing all users.
public interface UserRepository extends JpaRepository<User,Long> {
}
