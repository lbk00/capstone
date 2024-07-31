// com.example.capstone.User.UserRepository.java
package com.example.capstone.User;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByCID(String cId);

}