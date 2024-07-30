package com.example.capstone.Manager;

import com.example.capstone.Search.ManagerSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long>, ManagerSearch{
}