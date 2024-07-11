// com.example.capstone.User.UserRepository.java
package com.example.capstone.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}