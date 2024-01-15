package com.luciggl.webservice.repositories;

import com.luciggl.webservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
