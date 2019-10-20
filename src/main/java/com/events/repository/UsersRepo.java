package com.events.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.events.entities.Users;

public interface UsersRepo extends JpaRepository<Users, String> {

}
