package com.db.userdb.repository;

import com.db.userdb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
