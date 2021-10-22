package com.aflevering.loginopgave.repositories;
import com.aflevering.loginopgave.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    Optional<User> findUserByName(String username);

    @Query("SELECT u FROM User u where u.username = ?1 AND u.password = ?2")
    Optional<User> findByUserAndPassword(String username, String password);


}
