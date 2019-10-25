package com.events.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.events.entities.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, String> {

}
